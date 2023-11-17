package com.itooth.cls;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static double moveStack = 0;
    private static double initial_speed = 0;
    private static Circle circle;
    private static double floor;

    private static final double acceleration = -50;

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

    // config 값 업데이트
    private void configUpdate(){
        moveStack = (moveStack <= 0) ? moveStack = 0 : moveStack - 0.01;
        time += 0.01;
    }

     //공 낙하 위치(y값) 계산
    private double calPos(double time){
        return initial_speed * time + 0.5 * acceleration * time * time;
    }   

    // 좌우 이동
    private void move(KeyEvent event){
        moveStack = (moveStack >= 1) ? 1 : moveStack + 0.1;
        
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

    // 충돌 시 발생
    public void crashed(){
        initial_speed = 30;
        floor = circle.getCenterY();
        time = 0;
    }
    
    // shape 가져오기
    public Circle getShape(){
        return circle;
    }
}
