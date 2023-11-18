package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Jumpblock extends Block{

    private Rectangle rectangle;


    public Jumpblock(Rectangle block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        runBlock(getBounds(rectangle));
    }

    @Override
    public void bottomCrash(){
        super.bottomCrash();
        Sys.getInstance().
    }
}