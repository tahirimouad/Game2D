package com.example.tp2_firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
       Intent playIntent = new Intent(this,gameActity.class);
        startActivity(playIntent);
        //Toast.makeText(getApplicationContext(),"Size x :  y : ",Toast.LENGTH_LONG).show();
    }
}
