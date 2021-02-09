package com.example.tp2_firstgame.MyClasses;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tp2_firstgame.R;

public class Background {
    int x = 0, y = 0;
    Bitmap background;
    Background(int screenX, int screenY, Resources res) {
//Création d'une instance de bitmap à partir d'une ressource
        background= BitmapFactory.decodeResource(res, R.drawable.background);
//Agrandir/réduire un bitmap
        background= Bitmap.createScaledBitmap (background,screenX, screenY,false);
    }
}
