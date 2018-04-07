package com.androidavancado.posiot.sensorperigo.ui;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.App;
import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.util.Constants;
import com.androidavancado.posiot.sensorperigo.util.Util;

public class MainActivity extends AppCompatActivity {

    private EditText mUsuario;
    private EditText mSenha;
    private Button mSignInBtn;
    final Context contx = App.getContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //APENAS PARA CHAMAR O ONCLICK DO BOTÃO
        mSignInBtn = findViewById(R.id.sign_in_button);
        String verifyEmail, verifyPassword;

        //Verificar se o usuário já existe
        SharedPreferences sensorPerigoPreferences = App.getContext().getSharedPreferences(Constants.SENSOR_PERIGO_PREF, contx.MODE_PRIVATE);
        verifyEmail = sensorPerigoPreferences.getString("email", "");
        verifyPassword = sensorPerigoPreferences.getString("senha", "");

        //SE JÁ EXISTE LOGIN E SENHA CADASTRADO, ENTÃO EXISTE USUÁRIO E VAI DIRETO PARA O PERFIL.
        if(!verifyEmail.isEmpty() && !verifyPassword.isEmpty())
        {
            abrirPerfil(mSignInBtn);
        }
        else
        {
            setContentView(R.layout.activity_main);

            mUsuario = findViewById(R.id.usuarioText);
            mSenha = findViewById(R.id.password);
        }


    }

    public void VerificarLogin(View v) {

        if (mUsuario.getText().toString().equals("") || mSenha.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nenhum campos pode estar vazio", Toast.LENGTH_SHORT).show();

        } else if(!Util.verifyUser(mUsuario.getText().toString(), mSenha.getText().toString())){

                Toast.makeText(this, "Usuário Inexistente! Tente novamente ou cadastre-se!", Toast.LENGTH_LONG).show();
               // finish();
            }
            else
            {
                Intent acesso = new Intent(this, MainMenuActivity.class);

                startActivity(acesso);
                finish();

            }



//            Intent it = new Intent(this, LoginActivity.class);
  //          it.putExtra("mUsuario", mUsuario.getText().toString());
    //        it.putExtra("mSenha", mSenha.getText().toString());
      //      startActivity(it);
           // startActivityForResult(it, 1);
    //    }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1) {
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Não encontramos seus dados! Por favor, tente novamente!", Toast.LENGTH_SHORT).show();

        }

    }

    public void abrirPerfil(View v) {
        Intent it = new Intent(this, PerfilActivity.class);
        startActivity(it);

    }



}