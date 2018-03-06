package com.androidavancado.posiot.sensorperigo.ui;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.model.PersonalIDs;
import com.androidavancado.posiot.sensorperigo.model.User;

import java.util.regex.Pattern;


public class PerfilActivity extends AppCompatActivity {

    private User mUser;
    private EditText mTextNome;
    private EditText mTextDatNasc;
    private EditText mTextCPF;
    private EditText mTextRG;
    private EditText mTextOrgEm;
    private EditText mTextDataExp;
    private EditText mTextUF;
    private RadioGroup mTextSexo;
    private EditText mTextNacionalidade;
    private EditText mTextEstadoCivil;
    private EditText mTextDdd;
    private EditText mTextTelefone;
    private EditText mEmail;
    private EditText mTextSenha;


    private PersonalIDs mIDs;
    private EditText mTextNome;
    private EditText mTextDatNasc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        mTextNome = findViewById(R.id.editTextNome);
        mTextDatNasc = findViewById(R.id.editTextNasc);
        mTextCPF = findViewById(R.id.editTextCPF);
        mTextRG = findViewById(R.id.editTextRG);
        mTextOrgEm = findViewById(R.id.editTextOrgao);
        mTextDataExp = findViewById(R.id.editTextDataEx);
        mTextUF = findViewById(R.id.editTextUFexp);
        mTextSexo = findViewById(R.id.editRadio);
        mTextNacionalidade = findViewById(R.id.editTextNacionalidade);
        mTextEstadoCivil = findViewById(R.id.editTextEstadoCivil);
        mTextDdd = findViewById(R.id.editTextDDD);
        mTextTelefone = findViewById(R.id.editTextTele);
        mEmail = findViewById(R.id.editTextEmail);
        mTextSenha = findViewById(R.id.editTextSenha);




        mUser.setmName(mTextNome.getText().toString());
        mUser.setmDateOfBirth(mText);




        if (mUser != null) {

            Log.i("dados do usuário", "Entrei");
            mTextNome.setText(mUser.getmName());

        }
    }


    public void Cancelar(View v) {


    }


    public void Salvar(View v) {

        if(isValidEmaillId(mEmail.getText().toString().trim())){
            // Salvar no

            Toast.makeText(getApplicationContext(), "Endereço de Email Válido", Toast.LENGTH_SHORT).show();



        }else{
            Toast.makeText(getApplicationContext(), "Endereço de Email Inválido", Toast.LENGTH_SHORT).show();
        }

    }


    private boolean isValidEmaillId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }


}
