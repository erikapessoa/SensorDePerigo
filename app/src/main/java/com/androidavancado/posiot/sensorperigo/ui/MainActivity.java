package com.androidavancado.posiot.sensorperigo.ui;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.ui.LoginActivity;
import com.androidavancado.posiot.sensorperigo.ui.MainMenuActivity;
import com.androidavancado.posiot.sensorperigo.ui.PerfilActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mUsuario;
    private EditText mSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsuario = findViewById(R.id.usuarioText);
        mSenha = findViewById(R.id.password);

    }

    public void VerificarLogin(View v) {

        if (mUsuario.getText().toString().equals("") || mSenha.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nenhum campos pode estar vazio", Toast.LENGTH_SHORT).show();

        } else {


            Intent it = new Intent(this, LoginActivity.class);
            it.putExtra("mUsuario", mUsuario.getText().toString());
            it.putExtra("mSenha", mSenha.getText().toString());
            startActivityForResult(it, 1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1) {
            finish();
        }

    }

    public void abrirPerfil(View v) {
        Intent it = new Intent(this, PerfilActivity.class);
        startActivity(it);

    }



}