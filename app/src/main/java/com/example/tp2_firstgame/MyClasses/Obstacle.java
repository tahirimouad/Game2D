package com.example.tp2_firstgame.MyClasses;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.tp2_firstgame.R;
import java.util.Random;

public class Obstacle {
    public boolean isGoingUp=false;

    int x,y,width,height, winCounter;
    Bitmap obstacle;
    Random r;
    public Obstacle(int screenX,int screenY , Resources res) {
        r=new Random();
        winCounter = r.nextInt(5);
        switch (winCounter){
            case 1:
                obstacle= BitmapFactory.decodeResource(res, R.drawable.ob1);
                break;
            case 2:
                obstacle=  BitmapFactory.decodeResource(res, R.drawable.ob2);
                break;
            case 3:
                obstacle=  BitmapFactory.decodeResource(res, R.drawable.ob3);
                break;
            case 4:
                obstacle=  BitmapFactory.decodeResource(res, R.drawable.ob4);
                break;
            default:
                obstacle=  BitmapFactory.decodeResource(res, R.drawable.ob1);
                break;
        }
        x=screenX;
        height=obstacle.getHeight();
        width=obstacle.getWidth();
        obstacle=Bitmap.createScaledBitmap(obstacle,width,height,false);
        this.y = screenY-obstacle.getHeight()-38;
    }

    Bitmap getSprite(){
       return obstacle;
    }
}
