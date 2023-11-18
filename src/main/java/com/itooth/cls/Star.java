package com.itooth.cls;

import com.itooth.cls.abstractcls.Object;

import javafx.scene.shape.Polygon;

public class Star extends Object{

    private Polygon polygon;

    public Star(Polygon p){
        polygon = p;
    }

    @Override
    public void update(){
        
         if (( polygon != null) && (isCrashto(getBounds(polygon)))){
            //System.out.println("asd");
            Sys.getInstance().reduceStar(this.polygon);
            polygon = null;
         }
    }

    // //충돌 감지
    // private boolean isCrashto(Bounds bound){
    //     return bound.intersects(Sys.getInstance().getBallBounds());
    // }
  
    // public Bounds getBounds(){
    //     return getBounds(polygon);
    // }
}
