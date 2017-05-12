package randomforest.com.dxb;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by blueb on 5/7/2017.
 */

public class Ball extends Drawable{

    private float radius;
    Paint paint;
    private float dx,dy;

    public Ball(float x, float y, float r){
        super(x,y);
        radius=r;
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);



    }

//    public Canvas draw(Canvas canvas){
//
//        canvas.drawRGB(255, 255, 255);
//
//        canvas.drawCircle(x,y, radius, paint);
//       // canvas.drawCircle(x,y, radius, paint);
//
//        return canvas;
//
//
//    }

    public void setXY(float xp, float yp){
        x=xp;
        y=yp;
    }

    public void setR(float r){
        radius=r;
    }
    public float getR(){
        return radius;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }


    public void setDX(float speed) {
        dx=speed;
    }
    public void setDY(float speed) {
        dy=speed;
    }


    public Paint getPaint(){
        return paint;
    }

    public void move()
    {
        x=x+dx;
        y=y+dy;
    }

    public void bounce(Canvas canvas)       //COLLISION DETECTION AND RESOLUTION WITH WALLS
    {
        move();
        //Collision();
        if(x+30>canvas.getWidth()|| x<30)
        {

            dx=dx * -1;
        }
        if( y<30)
        {

            dy=dy * -1;
        }


    }
//
//    public void Collision(){
//        for(int i=2;i<GameCanvas.objects.size();i++) {
//            Brick br=(Brick) GameCanvas.objects.get(i);
//
//            if (((getY() - getR()) <= br.getB())) {
//
//                GameCanvas.objects.remove(i);
//                //score+=1;
//                dy=dy * -1;
//            }
//            else if(((getY() + getR()) >= br.getT())){
//
//                GameCanvas.objects.remove(i);
//                //score+=1;
//                dy=dy * -1;
//            }
//            else if(((getX()) >= br.getL())){
//
//                GameCanvas.objects.remove(i);
//                //score+=1;
//                dx=dx * -1;
//            }
//            else if((getX()) <= br.getR()){
//
//                GameCanvas.objects.remove(i);
//                //score+=1;
//                dx=dx * -1;
//            }
//
//        }
//
//
//
//    }

    public void ballBarCollision(Bar br) {


        if (((getY() - getR()) <= br.getB()) && ((getY() + getR()) >= br.getT()) && ((getX() + getR()) >= br.getL()) && ((getX() - getR()) <= br.getR())) {
            //mp.start();
            //score+=1;
            if (Math.abs((x + radius) - (br.getL())) < Math.abs((y + radius) - (br.getT())) && Math.abs((x + radius) - (br.getL())) < Math.abs((y - radius) - (br.getB()))) {
                dx = dx * (-1);
            } else if (Math.abs((x - radius) - (br.getR())) < Math.abs((y + radius) - (br.getT())) && Math.abs((x - radius) - (br.getR())) < Math.abs((y - radius) - (br.getB()))) {
                dx = dx * (-1);
            } else {
                dy = dy * (-1);
            }


        }
    }



    public void ballBrickCollision( ){
        for(int i=2;i<GameCanvas.objects.size();i++) {
           {
                Brick br=(Brick) GameCanvas.objects.get(i);
                if (((getY() - getR()) <= br.getB()) && ((getY() + getR()) >= br.getT()) && ((getX()+getR()) >= br.getL()) && ((getX()-getR()) <= br.getR())) {
                    //mp.start();
                    GameCanvas.objects.remove(i);
                    //score+=1;
                    if (Math.abs((x + radius) - (br.getL())) < Math.abs((y + radius) - (br.getT())) && Math.abs((x + radius) - (br.getL())) < Math.abs((y - radius) - (br.getB()))) {
                        dx = dx * (-1);
                    } else if (Math.abs((x - radius) - (br.getR())) < Math.abs((y + radius) - (br.getT())) && Math.abs((x - radius) - (br.getR())) < Math.abs((y - radius) - (br.getB()))) {
                        dx = dx * (-1);
                    } else {
                        dy = dy * (-1);
                    }
                }
            }

        }

    }

}
