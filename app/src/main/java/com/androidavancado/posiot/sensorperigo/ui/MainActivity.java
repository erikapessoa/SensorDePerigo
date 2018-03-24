package com.androidavancado.posiot.sensorperigo.ui;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.util.Util;

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