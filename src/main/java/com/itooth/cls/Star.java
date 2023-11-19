package com.itooth.cls;
import com.itooth.cls.abstractcls.Object;

import javafx.scene.Node;

public class Star extends Object{

    private Node node;

    public Star(Node node){
        this.node = node;
    }

    @Override
    public void update(){
        
         if (( node != null) && (isCrashto(getBounds(node)))){
            //System.out.println("asd");
            Sys.getInstance().reduceStar(this.node);
            node = null;
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
