package com.itooth.cls;

import com.itooth.cls.abstractcls.Object;

import javafx.scene.Node;

public class Block extends Object{

    /* 
     * 모든 shape 내의 함수가 Node를 상속 받고 있어 Block을 생성할 때 circle, rectangle등 shape 내에 존재하는 클래스면 전부 
     * Node로 up캐스팅 되서 들어감
     * up캐스팅된 node를 굳이 down캐스팅 안해도 getboundInParent를 할 수 있음
    */

    private Node node;
    private static Block instance = new Block();

    /*
     * runblock함수에서 4분기로 나누어서 함수를 동작하는 것이 Sys, ball에서 이미 분기를 나누는데 비효율적이라고 생각했음
     * 그래서 Direction에 jump라는 함수를 연결해 분기를 나누지 않고도 동작 할 수 있게 만듬
     * 그러면 Direction은 Block의 내부 함수가 필요하기 때문에 객체를 생성하지 않고 만들 수 있도록 getInstance 제공
     */
    private Block(){};
    public static Block getInstance(){
        return instance;
    }

    public Block(Node node){
        this.node = node;
    }
        
    @Override
    public void update() {
        if (isCrashto(getBounds(node))){
            whereCrashto(getPos(getBounds(node)), getPos(Sys.getInstance().getBallbound())).jump();
        }
    }

    // 충돌 방향 판정
    private Direction whereCrashto(double[] mainPos, double[] subPos){
        double degree = getDegree(mainPos, subPos);

        if (degree > 45 && degree < 135){
            return Direction.TOP;
        }
        else if ((degree > 0 && degree < 45) || (degree < 0 && degree > -45)){
            return Direction.LEFT;
        }
        else if (degree > 135 || degree < -135){
            return Direction.RIGHT;
        }
        else if (degree > -135 && degree < -45){
            return Direction.BOTTOM;
        }
        else{
            return Direction.OBLIQUE;
        }
    }

    // 정점의 각 계산
    private double getDegree(double[] mainPos, double[] subPos){
        double dx = mainPos[0] - subPos[0];
        double dy = mainPos[1] - subPos[1];
        return Math.atan2(dy, dx) * 180 / Math.PI;
    }

    // 기본적인 충돌 시 실행 코드
    public void topCrash(){
        Sys.getInstance().runcrash(Direction.TOP);
    }
    
    public void bottomCrash(){
        Sys.getInstance().runcrash(Direction.BOTTOM);
    }

    public void leftCrash(){
        Sys.getInstance().runcrash(Direction.LEFT);
    }
    
    public void rightCrash(){
        Sys.getInstance().runcrash(Direction.RIGHT);
    }

    public void diagonalCrash(){}
}
