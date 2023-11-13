package com.itooth.cls;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.geometry.Bounds;

public class Ball extends Object{

    private static double time = 0;
    private static double moveStack = 0;
    private static Circle circle;
    private static double floor;

    private static final double acceleration = -10, initial_speed = 10;

    public Ball(Circle c){
        circle = c;
        floor = circle.getCenterY();
        circle.setFocusTraversable(true);
        circle.setOnKeyPressed(e -> move(e));
    }

    @Override
    public void update(){
        
        configUpdate();

        circle.setCenterY(floor - calPos(time) * 10);

    }

    public void crash(){
        time = 0;
        floor = circle.getCenterY();
    }

    private void configUpdate(){
        
        time += 0.01;
    
        if (moveStack <= 0) {moveStack = 0;}
        else {moveStack -= 0.01;}

    }
    
    private void move(KeyEvent event) {

        if (moveStack >= 1) {moveStack = 1;}
        else {moveStack += 0.1;}

        switch (event.getCode()) {
            case LEFT:
                circle.setCenterX(circle.getCenterX() - calPos(moveStack));
                break;
            case RIGHT:
                circle.setCenterX(circle.getCenterX() + calPos(moveStack));
                break;
            default:
                break;
        }
    }

    private double calPos(double time){
        // 공 낙하 로직
        return initial_speed * time + 0.5 * acceleration * time * time;
    }


    public Bounds getBounds(){
        return circle.getBoundsInParent();
    }
}
