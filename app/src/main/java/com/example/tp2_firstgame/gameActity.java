package com.example.tp2_firstgame;

import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2_firstgame.MyClasses.gameView;

public class gameActity extends AppCompatActivity {
    private gameView gameV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        gameV = new gameView(this,size.x,size.y);
        setContentView(gameV);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameV.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        gameV.resume();
    }
}
