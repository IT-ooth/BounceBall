package com.itooth.cls.abstractcls;

import com.itooth.cls.Sys;

import javafx.geometry.Bounds;
import javafx.scene.Node;

public abstract class Object{

    // 틱마다 업데이트 해야할 사항들
    public abstract void update();

    //충돌 감지
    protected boolean isCrashto(Bounds bound){
        return bound.intersects(Sys.getInstance().getBallBounds());
    }

    // 오브젝트 데이터 가져오기
    protected Bounds getBounds(Node node){
        return node.getBoundsInParent();
    }
    
    protected double[] getPos(Bounds bound){
        return new double[]{bound.getCenterX(), bound.getCenterY()};
    }
}
