package randomforest.com.dxb;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by blueb on 5/7/2017.
 */

public class Bar extends Drawable{

    float top,bottom,left,right;

    Paint paint;

    public Bar(float l, float t, float r, float b){
        super();

        this.left=l;
        this.top=t;
        this.right=r;
        this.bottom=b;
        paint=new Paint();

        paint.setColor(Color.BLACK);



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

    public void moveRight(){

        if(right<1070){
            left+=60;
            right+=60;

        }
    }

    public void moveLeft(){
        if(left>8){
            left-=60;
            right-=60;
        }
    }

//    public void moveBar(boolean leftPos,boolean rightPos, Canvas canvas){
//        if(leftPos==true){
//            if(canvas.getWidth()>=right) {
//                left = left + 4;
//                right = right + 4;
//            }
//
//
//        }
//        else if(rightPos==true){
//            if(0<=left) {
//                //if()
//                left = left - 4;
//                right = right - 4;
//            }
//
//        }
//
//    }

}
