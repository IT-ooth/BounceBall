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

    @Override
    protected void topCrash() {
        System.out.println(1);
        Sys.getInstance().crash();
    }

    @Override
    protected void bottomCrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bottomCrash'");
    }

    @Override
    protected void leftCrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leftCrash'");
    }

    @Override
    protected void rightCrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rightCrash'");
    }

    @Override
    protected void diagonalCrash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diagonalCrash'");
    }
}
