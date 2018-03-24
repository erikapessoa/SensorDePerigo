package com.androidavancado.posiot.sensorperigo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidavancado.posiot.sensorperigo.R;

public class MainMenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void AbrirPerfilMenu(View v) {

        Intent it = new Intent(this, PerfilActivity.class);
        startActivity(it);

    }

    public void AbrirNotificacao(View v)
    {

    }

}
