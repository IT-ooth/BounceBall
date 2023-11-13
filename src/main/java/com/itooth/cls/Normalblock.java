package com.itooth.cls;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class Normalblock extends Block{

    private Rectangle rectangle;
    
    public Normalblock(Rectangle block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        // 충돌 시 코드
        if (isCrash(getBounds())){
            Sys.getInstance().crash();
        }
    }

    @Override
    protected Bounds getBounds(){
        return rectangle.getBoundsInParent();
    }


}
