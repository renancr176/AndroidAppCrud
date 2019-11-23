package com.example.appcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appcrud.Banco.AppBanco;
import com.example.appcrud.Modelos.Cadastro;

public class AlteraExcluiActivity extends AppCompatActivity {
    private AppBanco mDb;
    private Cadastro mCadastro;

    private TextView mTvCodigo;
    private EditText mEtCampo1;
    private EditText mEtCampo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_exclui);

        mDb = AppBanco.getInstance(this);

        obterDadosDaNavegacao();

        mTvCodigo = findViewById(R.id.tvCodigo);
        mEtCampo1 = findViewById(R.id.etCampo1);
        mEtCampo2 = findViewById(R.id.etCampo2);

        mTvCodigo.setText(String.format("Código: %d", mCadastro.getID()));
        mEtCampo1.setText(mCadastro.getNome());
        mEtCampo2.setText(mCadastro.getDescricao());
    }

    private void obterDadosDaNavegacao(){
        Bundle extras = getIntent().getExtras();

        int id = 0;

        try
        {
            id = extras.getInt("ID", 0);
        }
        catch (Exception e){}

        if (id == 0)
            this.finish();

        mCadastro = mDb.getCadastroDao().obterCadastroPorId(id);

        if (mCadastro == null)
            this.finish();
    }

    public void AlteraOnClick(View view){
        if (!mEtCampo1.getText().toString().equals("")
        && !mEtCampo2.getText().toString().equals("")){

            mCadastro.setNome(mEtCampo1.getText().toString());
            mCadastro.setDescricao(mEtCampo2.getText().toString());

            mDb.getCadastroDao().update(mCadastro);

            this.finish();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("Atenção")
                    .setMessage("Informe todos os campos.")
                    .show();
        }
    }

    public void ExcluirOnClick(View view){
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Atenção")
            .setMessage("Você tem certeza que deseja excluir este registro?")
            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    mDb.getCadastroDao().delete(mCadastro);

                    AlteraExcluiActivity.this.finish();
                }

            })
            .setNegativeButton("Não", null)
            .show();
    }
}
