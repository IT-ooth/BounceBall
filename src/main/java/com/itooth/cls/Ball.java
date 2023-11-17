package com.itooth.cls;

import javafx.geometry.Bounds;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static double initial_speed = 2;
    private static Circle circle;
    private static double velocityX;

    private static final double acceleration = -10;

    public Ball(Circle c){
        circle = c;

        // circle can update KeyEvent
        circle.setFocusTraversable(true);

        // KeyEvent handler
        circle.setOnKeyPressed(e -> moveSide(e));
        circle.setOnKeyReleased(e -> {velocityX = 0;});
    }

    @Override
    public void update(){
        configUpdate();

        setPos(circle.getCenterX() - velocityX, circle.getCenterY() - calPos(time));
    }

    // config 값 업데이트
    private void configUpdate(){ 
        time += 0.01;
    }

    //공 낙하 위치 계산
    private double calPos(double time){
        return initial_speed + acceleration * time;
    }   

    private void moveSide(KeyEvent event){
        switch (event.getCode()) {
            case LEFT:
                velocityX = 1;
                break;
            case RIGHT:
                velocityX = -1;
                break;
            default: break;
        }
    }

    // 충돌 시 발생
    public void crashed(Direction direct){
        switch (direct) {
            case TOP:
                time = 0;
                break;
            case BOTTOM:
                time = initial_speed / acceleration;
                break;
            case LEFT:
                setPos(circle.getCenterX() - 1, circle.getCenterY());
                break;
            case RIGHT:
                setPos(circle.getCenterX() + 1, circle.getCenterY());
                break;
            default:
                break;
        }
    }

    // 공 좌표 설정
    private void setPos(double x, double y){
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
    
    public Bounds getBounds(){
        return getBounds(circle);
    }
}