package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Secretaria;
import com.example.demo.service.SecretariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    SecretariaService secretariaService;

    @GetMapping
    public List<Secretaria> listarSecretarias () {
        return secretariaService.listar();
    }

    @PostMapping
    public Secretaria criar(@Valid @RequestBody Secretaria secretaria) {
        return secretariaService.criar(secretaria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Secretaria secretaria) {
        //return secretariaService.atualizar(id, secretaria);
        if(secretariaService.atualizar(secretaria, id) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(secretaria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(secretariaService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
    @GetMapping("/{id}/relatorio-idiomas")
    public Map<String, Integer> relatorioIdiomas(@PathVariable Long id) {
        return secretariaService.relatorioIdiomas(id);
    }
}
