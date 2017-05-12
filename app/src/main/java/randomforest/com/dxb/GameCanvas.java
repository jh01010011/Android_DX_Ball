package randomforest.com.dxb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by blueb on 5/7/2017.
 */


public class GameCanvas extends View implements Runnable{

    public static ArrayList<Drawable> objects;

    float canvasWidth;
    float canvasHeight;

    int score=0;
    int life=3;
    int level=0;
    boolean gameover =false;
    boolean isFirstTime= true;

    int totalBricks=0;


    Ball ball,ball2;
    Brick brick,brick2,brick3;
    Bar bar;
    Paint paint;
    float x=0,y=0;
    boolean firstTime=true;


//    protected void calculateNextPos(){
//        y++;
//        x++;
//    }
    protected void onDraw(Canvas canvas) {

        score=(totalBricks-(objects.size()-2))*10;




        canvasWidth=canvas.getWidth();
        canvasHeight=canvas.getHeight();
//        if(firstTime)
//        {
//            firstTime=false;
//            x=canvas.getWidth() / 2;
//            y=canvas.getHeight() / 2;
//        }

        // calculateNextPos();
       canvas.drawRGB(255, 255, 255);
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
        //ball.setXY(x,y);
       // calculateNextPos();

        paint.setTextSize(40);
         paint.setFakeBoldText(true);
        paint.setColor(Color.RED);
        canvas.drawText("LEVEL : "+level,30 ,70, paint);
        canvas.drawText("SCORE : "+score,400 ,70, paint);
        canvas.drawText("LIFE : "+life,900 ,70, paint);



        Ball b=(Ball) objects.get(0);

        // bar =(Bar) objects.get(1);
        canvas.drawRect(bar.getL(), bar.getT(), bar.getR()+x, bar.getB(), bar.getPaint());
        canvas.drawCircle(b.getX(),b.getY(), b.getR(), b.getPaint());



        for (int i=2;i< objects.size();i++){

            Brick brick=(Brick) objects.get(i);
            canvas.drawRect(brick.getL(), brick.getT(), brick.getR(), brick.getB(), brick.getPaint());

        }

        if(!firstTime){
            b.bounce(canvas);
            //b.Collision();
            b.ballBrickCollision();
            b.ballBarCollision(bar);
        }

        if(b.getY()>1770){
            firstTime=true;
            if(life==0){


                paint.setColor(Color.RED);
                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);

                paint.setColor(Color.BLACK);
                paint.setTextSize(60);
                paint.setFakeBoldText(true);
                canvas.drawText("GAME OVER",canvas.getWidth()/2-110,canvas.getHeight()/2,paint);
                canvas.drawText("FINAL SCORE: "+score,canvas.getWidth()/2-150,canvas.getHeight()/2+60,paint);





                Intent intent=new Intent(getContext(),MainActivity.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
            life--;
            ball.setXY(500,1695);
            bar.setL(350);
            bar.setT(1730);
            bar.setR(650);
            bar.setB(1770);
        }
        else if(life==0) {




        }






        //canvas.drawRect(brick2.getL(), brick2.getT(), brick2.getR(), brick2.getB(), brick2.getPaint());
        //canvas.drawRect(brick3.getL(), brick3.getT(), brick3.getR(), brick3.getB(), brick3.getPaint());



        //canvas.drawCircle(ball2.getX(),ball2.getY(), ball2.getR(), ball2.getPaint());


        //canvas.drawCircle(ball.getX(),ball.getY(),ball.getR(), ball.getPaint());


        invalidate();
        //this.run();

       // h.postDelayed(r,15);
    }

//    private Runnable r=new Runnable()
//    { public void run()
//    { invalidate();
//    }
//    };


    public GameCanvas(Context context, Bundle bundle) {
        super(context);
        paint = new Paint();
//
//        brick=new Brick(10,50,200,150);
//        brick2=new Brick(210,50,410,150);
//        brick3=new Brick(420,50,620,150);




        init(bundle);

    }

    void init(Bundle bundle){
        int NumOfColumn=bundle.getInt("column");
        int NumberOfRow=bundle.getInt("row");
        level=bundle.getInt("level");

        totalBricks=NumberOfRow*NumOfColumn;



        float brickSize=118;
        //int brickBottom=550;
        float brickTop=150;
        //float brickLeft=10;


        bar=new Bar(350,1730,650,1770);

        ball=new Ball(500,1700,30);
       ball.setDX(bundle.getFloat("dx"));
        ball.setDY(bundle.getFloat("dy"));

        //ball.setDX(19);
        //ball.setDY(19);


        objects =new ArrayList<Drawable>();
        objects.add(ball);
        objects.add(bar);
//
//        objects.add(new Brick(10,50, 200,150));
//
//        objects.add(new Brick(220,50, 420,150));
//
//        objects.add(new Brick(10,160,200,260));
//
//        objects.add(new Brick(220,160,420,260));
//
//        objects.add(new Brick(10,270,200,370));
//
//        objects.add(new Brick(220,270,420,370));






        for(int i=0;i<NumberOfRow; i++){
            int brickLeft=10;
            //int brickRight=brickSize;


            for(int j=0; j<NumOfColumn;j++){
                objects.add(new Brick(brickLeft,brickTop,(brickLeft+brickSize),(brickTop+60)));
                brickLeft+=(brickSize+3);
                //brickRight+=brickSize;
            }
            brickTop+=65;
            //brickBottom=550;

        }


    }

    @Override
    public void run() {

        //invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float tx=event.getX();
        float ty=event.getY();

        if(event.getAction()==MotionEvent.ACTION_DOWN){

            Log.v("__ACTION_DOWN____","___DOWN__");
            if( tx <300 && ty>1600){
                bar.moveLeft();
                Log.v("__ACTION_DOWN____","___LEFY__");

                return true;

            }

            else if( tx >700 && ty>1600){
                bar.moveRight();
                Log.v("__ACTION_DOWN____","___RIGHT__");

                return true;

            }
            else if(ty<1600){
                Log.v("__ACTION_DOWN____","___RIGHT__");

                firstTime=false;
            }
            return true;
        }


        if(event.getAction()==MotionEvent.ACTION_UP){
            Log.v("__ACTION_UP____","___UP__");


            return true;
        }

        return super.onTouchEvent(event);
    }
}
