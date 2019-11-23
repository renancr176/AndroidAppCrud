package com.example.appcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appcrud.Banco.AppBanco;
import com.example.appcrud.Modelos.Cadastro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AppBanco mDb;
    private List<Cadastro> mCadastros;

    private ListView mLvCadastros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = AppBanco.getInstance(this);

        mLvCadastros = findViewById(R.id.lvCadastros);
        mLvCadastros.setOnItemClickListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

        mCadastros = mDb.getCadastroDao().listaCadastros();

        ArrayList<String> lvItens = new ArrayList<String>();

        for (Cadastro cad : mCadastros){
            lvItens.add(String.format("%d - %s", cad.getID(), cad.getNome()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                lvItens);

        mLvCadastros.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cadastro cadastro = mCadastros.get(position);

        Intent intent = new Intent(this, AlteraExcluiActivity.class);
        intent.putExtra("ID", cadastro.getID());
        startActivity(intent);
    }

    public void CadastrarOnClick(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
