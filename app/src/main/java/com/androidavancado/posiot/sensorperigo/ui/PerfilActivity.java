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
import com.androidavancado.posiot.sensorperigo.model.CellPhone;
import com.androidavancado.posiot.sensorperigo.model.PersonalIDs;
import com.androidavancado.posiot.sensorperigo.model.User;
import com.androidavancado.posiot.sensorperigo.util.Util;

import java.net.PasswordAuthentication;
import java.util.regex.Pattern;


public class PerfilActivity extends AppCompatActivity {

    private User mUser;
    private EditText mTextNome;
    private RadioGroup mTextSexo;
    private EditText mTextNacionalidade;
    private EditText mTextEstadoCivil;
    private EditText mEmail;
    private EditText mTextSenha;
    private EditText mDiaNasc;
    private EditText mMesNasc;
    private EditText mAnoNasc;

    private PersonalIDs mIDs;
    private EditText mTextCPF;
    private EditText mTextRG;
    private EditText mTextOrgEm;
    private EditText mTextDataExp;
    private EditText mTextUF;

    private CellPhone mCell;
    private EditText mTextDdd;
    private EditText mTextTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void Salvar(View v) {

        mTextNome = findViewById(R.id.editTextNome);
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

        mDiaNasc = findViewById(R.id.dia);
        mMesNasc = findViewById(R.id.mes);
        mAnoNasc = findViewById(R.id.ano);

        int diaNasc, mesNasc, anoNasc;
        diaNasc = Integer.parseInt(mDiaNasc.getText().toString());
        mesNasc = Integer.parseInt(mMesNasc.getText().toString());
        anoNasc = Integer.parseInt(mAnoNasc.getText().toString());



        mUser.setmName(mTextNome.getText().toString());
        mUser.setmSex(((char) mTextSexo.getCheckedRadioButtonId()));
        mUser.setmMaritalStatus(mTextEstadoCivil.getText().toString());
        mUser.setmNationality(mTextNacionalidade.getText().toString());
        mUser.setmDateOfBirth(Util.mountDate(diaNasc, mesNasc, anoNasc));

        String UserAux = mEmail.getText().toString();
        char[] SenhaAux = mTextSenha.getText().toString().toCharArray();
        mUser.setmPasswordAuthetication(new PasswordAuthentication(UserAux,SenhaAux));

        mIDs.setmCPF(Long.parseLong(mTextCPF.getText().toString()));
        mIDs.setmRG(Long.parseLong(mTextRG.getText().toString()));
        mIDs.setmRG_UF(mTextRG.getText().toString());
        mIDs.setmRG_mInstitutionEmitter(mTextOrgEm.getText().toString());
        // Falta Calendar mRG_ExpeditionDate

        mCell.setmDDD(Integer.parseInt(mTextDdd.getText().toString()));
        mCell.setmNumber(mTextTelefone.getText().toString().toCharArray());



        if(Util.validateEmail(mEmail.getText().toString().trim())){


            //Toast.makeText(getApplicationContext(), "Endereço de Email Válido", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "Endereço de Email Inválido", Toast.LENGTH_SHORT).show();
        }

        if(!Util.validateCPF(mTextCPF.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "CPF Inválido", Toast.LENGTH_SHORT).show();
        }

    }


    public void Cancelar(View v) {


    }



}
