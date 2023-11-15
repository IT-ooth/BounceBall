package com.itooth.cls;

import javafx.geometry.Bounds;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static double initial_speed = 2;
    private static Circle circle;
    private static double v; //TODO 변수명 교체 바람

    private static final double acceleration = -10;

    public Ball(Circle c){
        circle = c;

        // circle can update KeyEvent
        circle.setFocusTraversable(true);

        // KeyEvent handler
        circle.setOnKeyPressed(e -> move(e));
        circle.setOnKeyReleased(e -> {v = 0;});
    }

    @Override
    public void update(){
        configUpdate();

        //TODO setCenterX(), setCenterY() 로 대체 가능한듯?
        setPos(circle.getCenterX() - v, circle.getCenterY() - calPos(time));
    }

    // config 값 업데이트
    private void configUpdate(){ 
        time += 0.01;
    }

    //공 낙하 위치 계산
    private double calPos(double time){
        return initial_speed + acceleration * time;
    }   

    //KeyEvent.pressed 일 때 실행되는 함수 TODO <- 함수명이 movement 같이 움직임 전체를 관할하는 느낌으로 바뀌면 좋을듯?
    private void move(KeyEvent event){

        switch (event.getCode()) {
            case LEFT:
                v = 1;
                break;
            case RIGHT:
                v = -1;
                break;
            default: break;
        }

    }

    // 충돌 시 발생
    public void crashed(){
        time = 0;
    }
    
    //TODO bounds 가 있는데 setPos가 필요한가?
    private void setPos(double x, double y){
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
    
    public Bounds getBounds(){
        return getBounds(circle);
    }
}
