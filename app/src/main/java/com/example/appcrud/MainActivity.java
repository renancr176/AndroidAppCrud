package com.example.appcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView mLvCadastros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvCadastros =
    }

    @Override
    protected void onResume(){
        super.onResume();

        //Atualizar lista aqui
    }

    public void CadastrarOnClick(View view){

    }
}
