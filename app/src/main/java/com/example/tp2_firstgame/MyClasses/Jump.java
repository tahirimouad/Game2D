package com.example.tp2_firstgame.MyClasses;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tp2_firstgame.R;

public class Jump {

    public boolean isGoingUp=false;

    int x,y,width,height, winCounter=0;
    Bitmap j1, j2;

    public Jump(int screenY , Resources res) {
        j1 = BitmapFactory.decodeResource(res, R.drawable.jump1);
        j2 = BitmapFactory.decodeResource(res, R.drawable.jump2);
        x=30;
        height=j1.getHeight();
        width=j1.getWidth();
        j1=Bitmap.createScaledBitmap(j1,width,height,false);
        j2=Bitmap.createScaledBitmap(j2,width,height,false);
        this.y = screenY-j1.getHeight();
    }

    Bitmap getJump(){
        if(winCounter==0){
            winCounter++;
            return j1;
        }
        else{
            winCounter--;
            return j2;
        }
    }
}
