package com.example.appcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class AlteraExcluiActivity extends AppCompatActivity {
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_exclui);

        obterDadosDaNavegacao();
    }

    private void obterDadosDaNavegacao(){
        Bundle extras = getIntent().getExtras();

        id = 0;

        try
        {
            id = extras.getInt("ID", 0);
        }
        catch (Exception e){}

        if (id == 0)
            this.finish();
    }

    public void AlteraOnClick(View view){

    }

    public void ExcluirOnClick(View view){
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Atenção")
            .setMessage("Você tem certeza que deseja excluir este registro?")
            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //EXCLUI O REGISTRO.

                    AlteraExcluiActivity.this.finish();
                }

            })
            .setNegativeButton("Não", null)
            .show();
    }
}
