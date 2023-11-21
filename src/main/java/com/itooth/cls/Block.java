package com.itooth.cls;

import com.itooth.cls.abstractcls.Object;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Block extends Object{

    /* 
     * 모든 shape 내의 함수가 Node를 상속 받고 있어 Block을 생성할 때 circle, rectangle등 shape 내에 존재하는 클래스면 전부 
     * Node로 up캐스팅 되서 들어감
     * up캐스팅된 node를 굳이 down캐스팅 안해도 getboundInParent를 할 수 있음
    */
    public Rectangle rectangle;
    
    /*
     * runblock함수에서 4분기로 나누어서 함수를 동작하는 것이 Sys, ball에서 이미 분기를 나누는데 비효율적이라고 생각했음
     * 그래서 Direction에 jump라는 함수를 연결해 분기를 나누지 않고도 동작 할 수 있게 만듬
     */

    //Mapcontroller를 위한 생성자
    public Block(Node node){
        this.rectangle = (Rectangle)node;
    }

    public Block(Rectangle rectangle){
        this.rectangle = rectangle;
    }
    
    // runblock 함수를 update에 통합
    @Override
    public void update() {
        if (isCrashto(getBounds(rectangle))){
            whereCrashto(getPos(getBounds(rectangle)), getPos(Sys.getInstance().getBallBounds()));
        }
    }

    // 충돌 방향 판정
    protected void whereCrashto(double[] mainPos, double[] subPos){
        double degree = getDegree(mainPos, subPos);

        if (degree > 45 && degree < 135)
            bottomCrash();
        else if ((degree > 0 && degree < 45) || (degree < 0 && degree > -45))
            leftCrash();
        else if (degree > 135 || degree < -135)
            rightCrash();
        else if (degree > -135 && degree < -45)
            topCrash();
        else
            diagonalCrash();
    }

    // 정점의 각 계산
    private double getDegree(double[] mainPos, double[] subPos){
        double dx = mainPos[0] - subPos[0];
        double dy = mainPos[1] - subPos[1];
        return Math.atan2(dy, dx) * 180 / Math.PI;
    }

    // 기본적인 충돌 시 실행 코드
    public void topCrash(){
        Sys.getInstance().runCrash(Direction.TOP);
    }
    
    public void bottomCrash(){
        Sys.getInstance().runCrash(Direction.BOTTOM);
    }

    public void leftCrash(){
        Sys.getInstance().runCrash(Direction.LEFT);
    }
    
    public void rightCrash(){
        Sys.getInstance().runCrash(Direction.RIGHT);
    }

    public void diagonalCrash(){}
}
