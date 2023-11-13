package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    protected boolean isCrash(Bounds bound){
        if (Sys.getInstance().getBallbound().intersects(bound)){
            return true;
        }
        else{
            return false;
        }
    }
    
    protected abstract Bounds getBounds();
}
