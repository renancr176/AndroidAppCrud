package com.example.appcrud.Banco;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appcrud.Dao.CadastroDao;
import com.example.appcrud.Modelos.Cadastro;

@Database(entities = {Cadastro.class} , version = 1)
public abstract class AppBanco extends RoomDatabase {

    public abstract CadastroDao getCadastroDao();

    private static AppBanco instance;

    public static AppBanco getInstance(Context contexto){

        if(instance == null ){
            instance = Room.databaseBuilder(contexto,AppBanco.class,"app").allowMainThreadQueries().build();
        }

        return instance;
    }

}
