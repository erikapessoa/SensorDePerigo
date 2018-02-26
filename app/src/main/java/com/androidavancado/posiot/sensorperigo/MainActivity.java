package com.androidavancado.posiot.sensorperigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirPerfil(View v) {
      //  Intent it = new Intent(this, PerfilActivity.class);
      //  startActivity(it);

    }

    public void abrirMenu(View v) {
      //  Intent it = new Intent(this, MainMenuActivity.class);
      //  startActivity(it);

    }

}
