package com.example.appcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> mCadastros;

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

        mCadastros = new ArrayList<String>();

        for (int i = 1; i <= 30; i++) {
            mCadastros.add(String.format("Item %d", i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                mCadastros);

        mLvCadastros.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent intent = new Intent(this, AlteraExcluiActivity.class);
        startActivity(intent);
    }

    public void CadastrarOnClick(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
