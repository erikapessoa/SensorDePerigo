package com.androidavancado.posiot.sensorperigo.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.util.Constants;
import com.androidavancado.posiot.sensorperigo.util.Util;

public class LoginActivity extends AppCompatActivity {

    Intent it = getIntent();

    String mUser = it.getStringExtra("mUsuario");
    String mSenha = it.getStringExtra("mSenha");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!Util.verifyUser(mUser, mSenha))
        {
            Toast.makeText(this, "Usuário Inexistente! Tente novamente ou cadastre-se!", Toast.LENGTH_LONG).show();
            finish();
        }
        else
        {
            Intent acesso = new Intent(this, MainMenuActivity.class);
            setResult(RESULT_OK, it);
            startActivity(acesso);
            finish();

        }

    }



}
