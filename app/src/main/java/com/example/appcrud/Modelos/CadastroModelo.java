package com.example.appcrud.Modelos;

public class CadastroModelo {
    private int id;
    private String Nome;
    private String Descricao;

    public CadastroModelo() {
    }

    public CadastroModelo(int id, String nome, String descricao) {
        this.id = id;
        Nome = nome;
        Descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
