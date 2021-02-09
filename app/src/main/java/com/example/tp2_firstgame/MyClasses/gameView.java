package com.example.tp2_firstgame.MyClasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.tp2_firstgame.R;

import java.util.Random;

public class gameView extends SurfaceView implements Runnable {

    private Thread thread;
    Boolean isPlaying;
    private int screenX,screenY;
    private Background background1,background2;
    Paint paint;
    Obstacle obs;
    int peekCounter=0;
    //Jump jump;

    Sprite jump;
    Gost gost;
    Random random;
    public gameView(Context context, int screenX, int screenY){
        super(context);
        random=new Random();
        this.screenX=screenX;
        this.screenY=screenY;
        //jump= new Jump(screenY,getResources());
        jump= new Sprite(screenY,getResources());
        gost = new Gost(screenX,getResources());
        background1=new Background(screenX,screenY,getResources());
        background2=new Background(screenX,screenY,getResources());
        background2.x=screenX;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.colorAccent);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void run() {
        while(isPlaying){
            update();
            draw();
            sleep();
        }
    }
    private void update() {
        background1.x-=15;
        background2.x-=15;
        if(background1.x+background1.background.getWidth()<=0){
            background1.x=screenX;
        }
        if(background2.x+background2.background.getWidth()<=0){
            background2.x=screenX;
        }

        if(obs !=null){
            obs.x-=15;
            if(obs.x+obs.width<0){
                obs = null;
            }
        }
        if(gost.x<=0)
        {
            gost.x=random.nextInt(screenX*2);
            gost.y=random.nextInt(screenY);
        }
        else{
            gost.x-=30;
        }
        if (jump.isGoingUp) {
            if (jump.y > screenY / 2 - 60)
            {
                jump.y -= 50;
                jump.x+=peekCounter*25;
            }
            peekCounter++;
        } else {
            peekCounter = 0;
            if (jump.y < screenY - jump.height) {
                jump.y += 50;
            } else {
                jump.y = screenY - jump.height;
            }
            if(jump.x>screenX/2){
                jump.x-=10;
            }
        }
        if(peekCounter > 10)
        {
            jump.isGoingUp=false;
        }
    }
    private void draw() {
        if(getHolder().getSurface().isValid()){
            Canvas canvas =getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x,background1.y,paint);
            canvas.drawBitmap(background2.background,background2.x,background2.y,paint);
            //canvas.drawBitmap(jump.getJump(),jump.x,jump.y,paint);
            canvas.drawBitmap(jump.getSprite(),jump.x,jump.y,paint);

            canvas.drawBitmap(gost.getGost(),gost.x,gost.y,paint);
            Rect rect_gost = new Rect(gost.x,gost.y,gost.x+gost.width,gost.y+gost.height);
            Rect rect_obs=new Rect(0,0,0,0);
            paint.setStrokeWidth(15);
            paint.setColor(Color.YELLOW);
            if(random.nextBoolean() && obs ==null){
                obs = new Obstacle(screenX,screenY,getResources());
            }
            if(obs !=null){
                canvas.drawBitmap(obs.getSprite(),obs.x,obs.y,paint);
                rect_obs = new Rect(obs.x,obs.y,obs.x+obs.width,obs.y+obs.height);
                canvas.drawRect(rect_obs, paint);
            }

            Rect r_sprite = new Rect(jump.x,jump.y,jump.x+jump.width,jump.y+jump.height);

            canvas.drawRect(rect_gost, paint);
            paint.setColor(Color.RED);
            canvas.drawRect(r_sprite,paint);

            if(r_sprite.intersect(rect_gost)||
                    r_sprite.intersect(rect_obs)
            ){
                paint.setStrokeWidth(2);
                paint.setTextSize(48);
                canvas.drawText("Colision",screenX/2,screenY/2,paint);
            }
            /*Rect rect11 = new Rect(
                    background1.x + (232 * screenX / 600),
                    215 * screenY / 303,
                    background1.x + (292 * screenX / 600),
                    303 * screenY / 303
            );

            Rect rect12 = new Rect(
                    background2.x + (232 * screenX / 600),
                    215 * screenY / 303,
                    background2.x + (292 * screenX / 600),
                    303 * screenY / 303
            );

            Rect rect21 = new Rect(
                    background1.x + (468*screenX/600),
                    236*screenY/303,
                    background1.x + (538*screenX/600),
                    303*screenY/303
            );

            Rect rect22 = new Rect(
                    background2.x + (468*screenX/600),
                    236*screenY/303,
                    background2.x + (538*screenX/600),
                    303*screenY/303
            );
            Rect r_sprite = new Rect(jump.x,jump.y,jump.x+jump.width,jump.y+jump.height);

            paint.setStrokeWidth(15);
            paint.setColor(Color.YELLOW);
            canvas.drawRect(rect11, paint);
            canvas.drawRect(rect21, paint);
            canvas.drawRect(rect12, paint);
            canvas.drawRect(rect22, paint);
            paint.setColor(Color.RED);
            canvas.drawRect(r_sprite,paint);

            if(r_sprite.intersect(rect11)||
                    r_sprite.intersect(rect21)||
                    r_sprite.intersect(rect12)||
                    r_sprite.intersect(rect12)
            ){
                paint.setTextSize(24);
                canvas.drawText("Colision",screenX/2,screenY/2,paint);
            }*/
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    private void sleep() {
        try {
            Thread.sleep(90);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying=true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try{
            isPlaying=false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(jump.y==screenY-jump.height){
                    jump.isGoingUp=true;
                }
                break;
            case MotionEvent.ACTION_UP:
                jump.isGoingUp=false;
                break;
        }
        return true;
    }
}

