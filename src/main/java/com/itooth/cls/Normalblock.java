package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Normalblock extends Block{

    private Rectangle rectangle;
    
    public Normalblock(Rectangle block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        //System.out.println(getradian(getPos(getBounds(rectangle)), getPos(Sys.getInstance().getBallbound())));
        
        if (isCrashto(getBounds(rectangle))){
            System.out.println(whereCrashto(getPos(getBounds(rectangle)), getPos(Sys.getInstance().getBallbound())));
            Sys.getInstance().crash();
        }
    }
}
