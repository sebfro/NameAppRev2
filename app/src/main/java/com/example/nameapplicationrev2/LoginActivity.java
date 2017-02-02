package com.example.nameapplicationrev2;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class LoginActivity extends AppCompatActivity {

    private static  int RESULT_LOAD_IMG = 1;
    private static int REQUEST_EXTERNAL_STORAGE = 0;
    private final String DEBUG_TAG = "Error";

    private Uri imgUri;

    //Til internal storage
    private static final String FILENAME = "img_file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView tempImg = (ImageView) findViewById(R.id.imageView);
        Button btn =  (Button) findViewById(R.id.submitBtn);
        //Gjemmer Submit før bildet er lagt til
        btn.setVisibility(View.GONE);


    }


        public void submitName(View view) {

            //Henter input fra bruker
            EditText ed = (EditText) findViewById(R.id.nameText);
            String name = ed.getText().toString().toLowerCase();

            //Sjekker at navn er fyllt ut
            if(name.equals("NULL")) {
                Toast.makeText(this, "Please enter a name" , Toast.LENGTH_LONG).show();
            } else {
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


    public void addImage(View view){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(DEBUG_TAG, "Storage permission not granted. Requesting permissions.");
            String[] tmp = { Manifest.permission.READ_EXTERNAL_STORAGE };
            ActivityCompat.requestPermissions(LoginActivity.this, tmp , REQUEST_EXTERNAL_STORAGE);



        } else {
            Log.i(DEBUG_TAG, "Storage permisson granted, opening album.");

            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_LOAD_IMG);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int [] grantResults){
        if (requestCode == REQUEST_EXTERNAL_STORAGE){
            Log.d(DEBUG_TAG, "Received repsonse for contact permissions request.");

            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d(DEBUG_TAG, "Permission granted.");
                Toast.makeText(this, "Permission granted.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMG);

            } else {
                Log.d(DEBUG_TAG, "Permission denied.");
                Toast.makeText(this, " Permission denied.", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // Check what the response is

        if (requestCode == RESULT_LOAD_IMG){
            //Check if successfull
            if(resultCode == RESULT_OK){
                //Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_LONG).show();
                imgUri = data.getData();
                try{
                    //Henter bildet
                    InputStream inputStream = getContentResolver().openInputStream(imgUri);
                    //Gjer bildet om til Bitmap
                    Bitmap bmp = BitmapFactory.decodeStream(inputStream);

                    //Åpner stream
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    //Skriver Bitmap til Stream
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);

                    //Synligjør Submit kanppen
                    Button btn =  (Button) findViewById(R.id.submitBtn);
                    btn.setVisibility(View.VISIBLE);



                } catch(FileNotFoundException e){
                    Log.i(DEBUG_TAG, "File not found.");
                }

            }
        }
    }
}
