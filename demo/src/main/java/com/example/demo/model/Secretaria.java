package com.example.demo.model;

import jakarta.persistence.Entity;
import java.util.HashMap;
import java.util.Map;
@Entity
public class Secretaria extends Funcionario {
    private int senha;
    private int numFuncGerenciados;
    private int experiencia;
    private String[] idiomas;

    public Secretaria() {
    }

    public Secretaria(String nome, String cpf, String idade, double salario, int senha, int numFuncGerenciados, int experiencia, String[] idiomas) {
        super(nome, cpf, idade, salario);
        this.senha = senha;
        this.numFuncGerenciados = numFuncGerenciados;
        this.experiencia = experiencia;
        this.idiomas = idiomas;
    }

    public int getSenha() {
        return senha;
    } //metodos concretos

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumFuncGerenciados() {
        return numFuncGerenciados;
    }

    public void setNumFuncGerenciados(int numFuncGerenciados) {
        this.numFuncGerenciados = numFuncGerenciados;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }
    public Map<String, Integer> relatorioIdiomas() {
        Map<String, Integer> relatorio = new HashMap<>();

        for (String idioma : idiomas) {
            relatorio.put(idioma, relatorio.getOrDefault(idioma, 0) + 1);
        }

        return relatorio;
        //método que de um relatorio dos idiomas falado pelas secretarias
    }
}