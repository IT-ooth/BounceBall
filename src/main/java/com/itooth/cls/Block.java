package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    //충돌 감지
    private boolean isCrashto(Bounds bound){
        return bound.intersects(Sys.getInstance().getBallbound());
    }

    // 충돌 방향 판정
    // 1 : 오른쪽 사이드
    // 2 : 위
    // 3 : 왼쪽 사이드
    // 4 : 아래
    // 5 : 각 꼭짓점
    private int whereCrashto(double[] mainPos, double[] subPos){
        double radian = getradian(mainPos, subPos);
        
        return (isBetween(radian, -45, 0) && isBetween(radian, 0, 45)) ? 1 :
                (isBetween(radian, 45, 135)) ? 2 :
                (isBetween(radian, 135, 180) && isBetween(radian, -180, -135)) ? 3 : 
                (isBetween(radian, -135, -45)) ? 4 : 5;
    }

    // 정점의 각 계산
    private double getradian(double[] mainPos, double[] subPos){
        return -Math.toDegrees(Math.atan2(subPos[1] - mainPos[1], subPos[0] - mainPos[0]));
    }

    private boolean isBetween(double num, int small, int big){
        return num > small && num < big;
    }

    // 블럭이 충돌했을 때 실행되는 코드
    protected void runBlock(Bounds bound){
        if (isCrashto(bound)){
            switch (whereCrashto(getPos(bound), getPos(Sys.getInstance().getBallbound()))) {
                case 1:
                    rightCrash();
                    break;
                case 2:
                    topCrash();
                    break;
                case 3:
                    leftCrash();
                    break;
                case 4:
                    bottomCrash();
                    break;
                case 5:
                    diagonalCrash();
                    break;
                default:
                    break;
            }
        }
    }

    protected abstract void topCrash();
    
    protected abstract void bottomCrash();
    
    protected abstract void leftCrash();
    
    protected abstract void rightCrash();

    protected abstract void diagonalCrash();
}
