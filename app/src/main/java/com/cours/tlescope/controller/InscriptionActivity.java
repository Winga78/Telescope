package com.cours.tlescope.controller;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cours.tlescope.R;
import com.cours.tlescope.model.User;
import com.cours.tlescope.model.UserDAO;

import java.util.List;


public class InscriptionActivity extends AppCompatActivity {
    private TextView mInscriptionTextView;

    private EditText mNomEditText;
    private EditText mPrenomEditText;
    private EditText mMailEditTextInscription;
    private EditText mMdpEditTextInscription;
    private Button mValiderInscriptionnButton;
    private User user;
    UserDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mInscriptionTextView = findViewById(R.id.main_textview_Inscription);
        mPrenomEditText = findViewById(R.id.main_edittext_prenom);
        mNomEditText = findViewById(R.id.main_edittext_nom);
        mMailEditTextInscription = findViewById(R.id.main_edittext_mail_inscription);
        mMdpEditTextInscription = findViewById(R.id.main_edittext_mdp_inscription);
        mValiderInscriptionnButton = findViewById(R.id.main_button_valider_inscription);
        dao = new UserDAO(InscriptionActivity.this);


        mValiderInscriptionnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user= new User(mNomEditText.getText().toString(), mPrenomEditText.getText().toString(),mMdpEditTextInscription.getText().toString(),mMailEditTextInscription.getText().toString());
                dao.open1();
                Cursor us = dao.selectionnerVerif(user);
                if(us.moveToNext()){
                    Toast.makeText(InscriptionActivity.this,"Ce compte existe déjà", Toast.LENGTH_SHORT).show();
                }
                else {
                    dao.open();
                    dao.ajouter(user);
                    Intent gameActivityIntent= new Intent(InscriptionActivity.this, ActuActivity.class);
                    startActivity(gameActivityIntent);

                }
                dao.close();
            }
        });




    }
}