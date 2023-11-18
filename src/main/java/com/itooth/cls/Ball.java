package com.itooth.cls;

import com.itooth.cls.abstractcls.Object;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static double initial_speed = 2;
    private static double velocityX;
    private Circle circle;
    private static final double acceleration = -10;

    public Ball(Circle circle){
        this.circle = circle;
        // circle can update KeyEvent
        circle.setFocusTraversable(true);
        
        // 좌우 이동은 추가적인 로직 없이 swtich구문만 있어서 lambda로 넣는게 더 좋아보임
        // 나중에 아이템도 추가 될 건데 moveside는 안어울리기도 하고
        // KeyEvent handler
        circle.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    velocityX = 1;
                    break;
                case RIGHT:
                    velocityX = -1;
                    break;
                default: break;
            }}
        );
        circle.setOnKeyReleased(e -> {velocityX = 0;});
    }

    @Override
    public void update(){
        configUpdate();

        setPos(
            circle.getCenterX() - velocityX,
            circle.getCenterY() - calPosY(time)
            );
    }
    // 틱마다 최신화 할 것들 모음
    private void configUpdate(){ 
        time += 0.01;
    }

    // 공 좌표 설정
    private void setPos(double x, double y){
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    //공 낙하 위치 계산
    private double calPosY(double time){
        return initial_speed + acceleration * time;
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
                setPos(circle.getCenterX() + velocityX, circle.getCenterY());
                break;
            case RIGHT:
                setPos(circle.getCenterX() + velocityX, circle.getCenterY());
                break;
            default:
                break;
        }
    }

    // 공 초기화
    public void resetBall(double x, double y) {
        time = 0;
        setPos(x,y);
    }

    public Bounds getBounds(){
        return getBounds(circle);
    }
}
