package com.example.appcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.appcrud.Banco.AppBanco;
import com.example.appcrud.Modelos.Cadastro;

public class CadastroActivity extends AppCompatActivity {
    private AppBanco mDb;

    private EditText mEtCampo1;
    private EditText mEtCampo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mDb = AppBanco.getInstance(this);

        mEtCampo1 = findViewById(R.id.etCampo1);
        mEtCampo2 = findViewById(R.id.etCampo2);
    }

    public void SalvarOnClick(View view) {
        if (!mEtCampo1.getText().toString().equals("")
        && !mEtCampo2.getText().toString().equals("")){
            mDb.getCadastroDao().insert(
                new Cadastro(
                    mDb.getCadastroDao().getProximoCodigo(),
                    mEtCampo1.getText().toString(),
                    mEtCampo2.getText().toString()
                )
            );

            this.finish();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("Atenção")
                    .setMessage("Informe todos os campos.")
                    .show();
        }
    }
}
