package com.androidavancado.posiot.sensorperigo.ui;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.util.Constants;

public class LoginActivity extends AppCompatActivity {


    private EditText mUsuario;
    private EditText mSenha;
    private Button mBotaoSalvar;


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

                if(mUsuario.getText().toString().equals("") || mSenha.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(), "Nenhum campos pode estar vazio", Toast.LENGTH_SHORT);
                } else{

                }
            }
        });



    }

}
