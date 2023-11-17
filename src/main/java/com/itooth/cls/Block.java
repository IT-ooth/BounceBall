package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    //충돌 감지
    protected boolean isCrashto(Bounds bound){
        return bound.intersects(Sys.getInstance().getBallbound());
    }
}
