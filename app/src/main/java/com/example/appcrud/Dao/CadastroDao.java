package com.example.appcrud.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appcrud.Modelos.Cadastro;

import java.util.List;

@Dao
public interface CadastroDao {

    @Insert
    public long[] insert(Cadastro... values);

    @Update
    public int update(Cadastro... values);

    @Delete
    public int delete(Cadastro... values);

    @Query("SELECT * FROM Cadastro")
    public List<Cadastro> listaCadastros();

    @Query("SELECT * FROM Cadastro WHERE ID = :id")
    public Cadastro obterCadastroPorId(Integer id);

    @Query("SELECT IFNULL(MAX(id),0)+1 FROM Cadastro")
    public Integer getProximoCodigo();
}
