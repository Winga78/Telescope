package com.cours.tlescope.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cours.tlescope.R;
import com.cours.tlescope.model.User;
import com.cours.tlescope.model.UserDAO;

public class ConnexionActivity extends AppCompatActivity {
    private TextView mConnexionTextView;
    private EditText mMailEditText;
    private EditText mMdpEditText;
    private Button mValiderConnexionButton;
    private User user;
    UserDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        mConnexionTextView= findViewById(R.id.main_textview_connexion);
        mValiderConnexionButton= findViewById(R.id.main_button_valider);
        mMdpEditText= findViewById(R.id.main_edittext_mdp);
        mMailEditText= findViewById(R.id.main_edittext_mail);
        dao = new UserDAO(ConnexionActivity.this);

        mValiderConnexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               user= new User(mMailEditText.getText().toString(),mMdpEditText.getText().toString());
               dao.open1();
                Cursor us=dao.selectionner(user);

               if(us.moveToNext()){
                   Intent gameActivityIntent= new Intent(ConnexionActivity.this, ActuActivity.class);
                   startActivity(gameActivityIntent);
                   Toast.makeText(ConnexionActivity.this,"Connexion réussie", Toast.LENGTH_SHORT).show();

               }
               else{
                   Toast.makeText(ConnexionActivity.this,"Mot de passe ou nom incorrect", Toast.LENGTH_SHORT).show();
               }


            }
        });

    }


}