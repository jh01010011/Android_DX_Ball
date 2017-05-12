package randomforest.com.dxb;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by blueb on 5/7/2017.
 */

public class Brick extends Drawable{

    float top,bottom,left,right;
    static int color=0;

    Paint paint;

    public Brick(float l, float t, float r, float b){
        super();

        this.left=l;
        this.top=t;
        this.right=r;
        this.bottom=b;
        paint=new Paint();
        if(color==0){
            paint.setColor(Color.BLUE);
            color=1;
        }
        else{
            paint.setColor(Color.RED);
            color=0;

        }

        paint.setStyle(Paint.Style.FILL);

    }


    public void setXY(float l, float t, float r, float b){
        this.left=l;
        this.top=t;
        this.right=r;
        this.bottom=b;
    }



    public float getL(){
        return left;
    }
    public float getT(){
        return top;
    }


    public float getR(){
        return right;
    }
    public float getB(){
        return bottom;
    }

    public void setL(float l){
        left=l;
    }


    public void setT(float t){
        top=t;
    }

    public void setR(float r){
        right=r;
    }


    public void setB(float b){
        bottom=b;
    }



    public Paint getPaint(){
        return paint;
    }


//    public Canvas draw(Canvas canvas){
//        paint=new Paint();
//
//        canvas.drawRGB(255, 255, 255);
//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.FILL);
//       // canvas.drawCircle(x,y, radius, paint);
//        // canvas.drawCircle(x,y, radius, paint);
//        canvas.drawRect(100, 100, 200, 200, paint);
//
//        return  canvas;
//
//    }
}
