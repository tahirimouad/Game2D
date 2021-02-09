package com.example.tp2_firstgame.MyClasses;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tp2_firstgame.R;

public class Gost {

    int x,y,width,height;
    Bitmap gost1;

    public Gost(int screenX, Resources res) {
        gost1 = BitmapFactory.decodeResource(res, R.drawable.gost);

        height=gost1.getHeight();
        width=gost1.getWidth();
        gost1=Bitmap.createScaledBitmap(gost1,width,height,false);
        this.y = 10;
        x=screenX;
    }

    Bitmap getGost(){
        return gost1;
    }
}
