package com.example.nameapplicationrev2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;



public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


        public void submitName(View view) {

            //Henter input fra bruker
            EditText ed = (EditText) findViewById(R.id.nameText);
            String name = ed.getText().toString().toLowerCase();

            //Henter preferansefilen som er dafault
            SharedPreferences settings = getSharedPreferences(MainActivity.MY_PREF, Context.MODE_PRIVATE);
            //Henter editor for å kunne redigere pref filen
            SharedPreferences.Editor editor = settings.edit();

            //Putter string admin name i pref filen
            editor.putString(MainActivity.ADMIN_NAME, name);
            editor.apply();

            //Starter ny intent for å sende tilbake til Menyen
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
}
