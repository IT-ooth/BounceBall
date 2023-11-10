package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Normalblock extends Block{

    private Rectangle rectangle;

    public Normalblock(Rectangle  block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        // 충돌 시 코드
        if (isCrash()){
            Sys.getInstance().crash();
        }
    }

    @Override
    protected boolean isCrash() {
        
        // 충돌 유무 판정 코드
        return false;
    }
}
