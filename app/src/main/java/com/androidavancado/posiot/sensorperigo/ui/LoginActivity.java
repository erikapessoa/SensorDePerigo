package com.androidavancado.posiot.sensorperigo.ui;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;

public class LoginActivity extends AppCompatActivity {


    private EditText mUsuario;
    private EditText mSenha;
    private Button mBotaoSalvar;

    public static final String ARQUIVO_PREF = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsuario = (EditText) findViewById(R.id.usuarioText);
        mSenha = (EditText) findViewById(R.id.password);
        mBotaoSalvar = (Button) findViewById(R.id.sign_in_button);

       // mUsuario.setText(settings.getString("login", ""));
      //  mSenha.setText(settings.getString("senha", ""));

        mBotaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ISSO É EM CADASTRO NO PerfilActivity - colocar prefe no UTIL
                SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, 0);
                SharedPreferences.Editor editor = settings.edit();

                if(mUsuario.getText().toString().equals("") || mSenha.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(), "Nenhum campos pode estar vazio", Toast.LENGTH_SHORT);
                } else{
                    // ISSO É EM CADASTRO NO PerfilActivity
                   // salvar
                    editor.putString("login", mUsuario.getText().toString());
                    editor.putString("senha", mSenha.getText().toString());
                    editor.commit();

                }
            }
        });

        // Recuperar os dados salvos lá no PerfilActitivy, como pego de lá?
        SharedPreferences settings = getSharedPreferences(ARQUIVO_PREF, 0);
        if(settings.contains("login") && settings.contains("senha") ){
            //abrir main_menu
        } else{
            Toast.makeText(getApplicationContext(), "Esse usuário não foi cadastrado", Toast.LENGTH_SHORT);

        }

    }

}
