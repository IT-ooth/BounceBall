package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Normalblock extends Block{

    private Rectangle rectangle;
    
    public Normalblock(Rectangle block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        runBlock(getBounds(rectangle));
    }
}