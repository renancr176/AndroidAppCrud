package com.example.appcrud.Modelos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Cadastro implements Serializable {

    @Ignore
    public static final String EXTRA_NAME = "CADASTRO";

    public Cadastro() {
    }

    public Cadastro(Integer ID, String nome, String descricao) {
        this.ID = ID;
        Nome = nome;
        Descricao = descricao;
    }

    @PrimaryKey(autoGenerate = true)
    public Integer ID;

    @ColumnInfo
    public String Nome;

    @ColumnInfo
    public String Descricao;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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
