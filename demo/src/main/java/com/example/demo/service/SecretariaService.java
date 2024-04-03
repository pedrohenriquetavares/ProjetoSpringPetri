package com.example.demo.service;

import com.example.demo.model.Secretaria;
import com.example.demo.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SecretariaService implements PessoaService<Secretaria>{

    @Autowired
    SecretariaRepository secretariaRepository;

    @Override
    public List<Secretaria> listar() {
       return secretariaRepository.findAll();
    }

    @Override
    public Secretaria criar(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    @Override
    public Secretaria atualizar(Secretaria secretaria, Long id) {
        if(secretariaRepository.existsById(id)) {
            secretaria.setId(id);
            return secretariaRepository.save(secretaria);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if(secretariaRepository.existsById(id)) {
            secretariaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Integer> relatorioIdiomas(Long id) {
        Optional<Secretaria> optionalSecretaria = secretariaRepository.findById(id);

        if (optionalSecretaria.isPresent()) {
            Secretaria secretaria = optionalSecretaria.get();
            String[] idiomas = secretaria.getIdiomas();
            Map<String, Integer> relatorio = new HashMap<>();
            for (String idioma : idiomas) {
                relatorio.put(idioma, relatorio.getOrDefault(idioma, 0) + 1);
            }
            return relatorio;
        } else {
            throw new RuntimeException("Secretária não encontrada com o ID: " + id);
        }
    }
}