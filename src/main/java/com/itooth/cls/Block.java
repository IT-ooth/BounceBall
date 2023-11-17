package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    //충돌 감지
    protected boolean isCrashto(Bounds bound){
        return bound.intersects(Sys.getInstance().getBallbound());
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

    // 블럭이 충돌했을 때 실행되는 코드
    protected void runBlock(Bounds bound){

        if (isCrashto(bound)){
            switch (whereCrashto(getPos(bound), getPos(Sys.getInstance().getBallbound()))) {
                case RIGHT:
                    rightCrash();
                    break;
                case TOP:
                    topCrash();
                    break;
                case LEFT:
                    leftCrash();
                    break;
                case BOTTOM:
                    bottomCrash();
                    break;
                case OBLIQUE:
                    diagonalCrash();
                    break;
                default:
                    break;
            }
        }
    }

    // 기본적인 충돌 시 실행 코드
    protected void topCrash(){
        Sys.getInstance().runcrash(Direction.TOP);
    }
    
    protected void bottomCrash(){
        Sys.getInstance().runcrash(Direction.BOTTOM);
    }

    protected void leftCrash(){
        Sys.getInstance().runcrash(Direction.LEFT);
    }
    
    protected void rightCrash(){
        Sys.getInstance().runcrash(Direction.RIGHT);
    }

    protected void diagonalCrash(){}
}