package com.example.nameapplicationrev2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;


public class LoginActivity extends AppCompatActivity {

    //Preferences
    private static final String MY_PREF = "PREF";
    private static final String ADMIN_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


        public void submitName(View view) {
            EditText ed = (EditText) findViewById(R.id.nameText);
            String name = ed.getText().toString().toLowerCase();

            SharedPreferences settings = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();

            editor.putString(ADMIN_NAME, name);
            editor.apply();
        }
}
