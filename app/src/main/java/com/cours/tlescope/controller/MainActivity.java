package com.cours.tlescope.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cours.tlescope.R;

public class MainActivity extends AppCompatActivity {
    private TextView mGreetingTextView;
    private Button mConnexionButton;
    private Button mInscriptionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreetingTextView= findViewById(R.id.main_textview_logo);
        mConnexionButton= findViewById(R.id.main_button_connexion);
        mInscriptionButton=findViewById(R.id.main_button_inscription);
        mConnexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivityIntent= new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(gameActivityIntent);

            }
        });


        mInscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivityIntent= new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(gameActivityIntent);

            }
        });


    }



}