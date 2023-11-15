package com.itooth.cls;

import javafx.geometry.Bounds;

public abstract class Block extends Object{

    //충돌 감지
    private boolean isCrashto(Bounds bound){
        return bound.intersects(Sys.getInstance().getBallbound());
    }

    // 충돌 방향 판정
    private Direction whereCrashto(double[] mainPos, double[] subPos){
        double degree = getDegree(mainPos, subPos);

        if (degree > 45 && degree < 135){
            return Direction.TOP;
        }
        else if (degree < 45 || degree > -45){
            return Direction.RIGHT;
        }
        else if (degree > 135 || degree < -135){
            return Direction.LEFT;
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
    // 추가적인 처리가 필요하다면 개별 클래스에서 필요한 부분만 오버라이딩해서 진행
    // 아직 점프만 구현되고 좌우위 충돌은 감지는 했지만 처리를 못함
    // TODO 좌우위사선 충돌 처리 필요
    protected void topCrash(){
        Sys.getInstance().crash();
    }
    
    protected void bottomCrash(){
        System.out.println(2);
    }

    protected void leftCrash(){
        System.out.println(1);
    }
    
    protected void rightCrash(){
        System.out.println(3);
    }

    protected void diagonalCrash(){}
}
