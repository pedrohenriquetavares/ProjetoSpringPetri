package com.example.demo.service;

import com.example.demo.model.Pessoa;

import java.util.List;

public interface PessoaService <T extends Pessoa> {
    List<T> listar(); //metodos abstratos (da interface)
    T criar(T t);
    T atualizar(T t, Long id);
    boolean deletar(Long id);
//Essa interface é genérica (PessoaService<T>) e parametrizada com um tipo T, o que significa que
// pode ser usada para lidar com diferentes tipos de entidades (por exemplo, Funcionario, Secretaria, etc.),
// permitindo a reutilização do código.
}
