package randomforest.com.dxb;

/**
 * Created by blueb on 5/7/2017.
 */

public abstract class Drawable {

    protected float x,y;

    protected Drawable(){}
    // Paint paint;

    protected Drawable(float x, float y){
        this.x=x;
        this.y=y;
        //this.paint=p;


    }


    public  boolean colide(Drawable drawable){
        return  true;
    };
   // public abstract Canvas draw(Canvas canvas);
}
