package com.example.tp2_firstgame.MyClasses;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tp2_firstgame.R;

public class Sprite {
    public boolean isGoingUp=false;

    int x,y,width,height, winCounter=0;
    Bitmap s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

    public Sprite(int screenY , Resources res) {
        s1 = BitmapFactory.decodeResource(res, R.drawable.sp1);
        s2 = BitmapFactory.decodeResource(res, R.drawable.sp2);
        s3 = BitmapFactory.decodeResource(res, R.drawable.sp3);
        s4 = BitmapFactory.decodeResource(res, R.drawable.sp4);
        s5 = BitmapFactory.decodeResource(res, R.drawable.sp5);
        s6 = BitmapFactory.decodeResource(res, R.drawable.sp6);
        s7 = BitmapFactory.decodeResource(res, R.drawable.sp7);
        s8 = BitmapFactory.decodeResource(res, R.drawable.sp8);
        s9 = BitmapFactory.decodeResource(res, R.drawable.sp9);
        s10 = BitmapFactory.decodeResource(res, R.drawable.sp10);
        x=30;
        height=s1.getHeight();
        width=s1.getWidth();
        s1=Bitmap.createScaledBitmap(s1,width,height,false);
        s2 =Bitmap.createScaledBitmap(s2,width,height,false);
        this.y = screenY-s1.getHeight();
    }

    Bitmap getSprite(){
        if(winCounter==10){
            winCounter=1;
        }
        else{
            winCounter++;
        }
        switch (winCounter){
            case 1:
                return s1;
            case 2:
                return s2;
            case 3:
                return s3;
            case 4:
                return s4;
            case 5:
                return s5;
            case 6:
                return s6;
            case 7:
                return s7;
            case 8:
                return s8;
            case 9:
                return s9;
            case 10:
                return s10;
            default:
                return s1;
        }
    }
}
