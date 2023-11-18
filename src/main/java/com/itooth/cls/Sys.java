package com.itooth.cls;

import com.itooth.controller.MapController;

import javafx.geometry.Bounds;

public class Sys{
    
    private static Sys instance = new Sys();
    private boolean flag = true;

    private Sys(){}

    // 생성자
    public static Sys getInstance(){
        return instance;
    }
    
    // ------- THREAD -------
    // 별 다먹었을 때 쓰는 함수
    public void win(){
        closeThread();
    }
    
    // 스레드 종료
    public void closeThread(){
        flag = false;
    }
    // 
    public boolean isFlag(){
        return flag;
    }

    // ------- ball -------
    // 공 bounds값 가져오기
    public Bounds getBallBounds(){
        return getBall().getBounds();
    }
    // 충돌 실행 코드
    public void runCrash(Direction direct){
        getBall().crashed(direct);
    }
    // 공 가져오기
    private Ball getBall(){
        return MapController.getBall();
    }
    // 공 초기화하기
    public void resetBall(){
        getBall().resetBall(MapController.getInitial());
    }
}
