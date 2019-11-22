package com.example.appcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appcrud.Modelos.CadastroModelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<CadastroModelo> mCadastros;

    private ListView mLvCadastros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvCadastros = findViewById(R.id.lvCadastros);
        mLvCadastros.setOnItemClickListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

        mCadastros = new ArrayList<CadastroModelo>();
        for (int i = 1; i <= 30; i++) {
            mCadastros.add(new CadastroModelo(i, String.format("Item %d", i), String.format("Descrição %d", i)));
        }

        ArrayList<String> lvItens = new ArrayList<String>();

        for (CadastroModelo cad : mCadastros){
            lvItens.add(cad.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                lvItens);

        mLvCadastros.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CadastroModelo cadastro = mCadastros.get(position);

        Intent intent = new Intent(this, AlteraExcluiActivity.class);
        intent.putExtra("ID", cadastro.getId());
        startActivity(intent);
    }

    public void CadastrarOnClick(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
