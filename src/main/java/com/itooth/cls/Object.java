package com.itooth.cls;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public abstract class Object{

    // 틱마다 업데이트 해야할 사항들
    public abstract void update();

    // 오브젝트 데이터 가져오기
    protected Bounds getBounds(Rectangle rectangle) {
        return rectangle.getBoundsInParent();
    }

    protected Bounds getBounds(Circle circle) {
        return circle.getBoundsInParent();
    }

    protected Bounds getBounds(Polygon polygon){
        return polygon.getBoundsInParent();
    }
    
    protected double[] getPos(Bounds bound){
        return new double[]{bound.getCenterX(), bound.getCenterY()};
    }
}
