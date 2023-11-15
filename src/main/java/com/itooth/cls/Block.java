package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    //충돌 감지
    // TODO 불필요한 if문인듯?
    protected boolean isCrashto(Bounds bound) {

        if (bound.intersects(Sys.getInstance().getBallbound())){
            return true;
        }
        else{
            return false;
        }

    }
}
