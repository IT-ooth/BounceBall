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

    // 충돌 실행 코드
    public void runcrash(Direction direct){
        getBall().crashed(direct);
    }

    // 공 bounds값 가져오기
    public Bounds getBallbound(){
        return getBall().getBounds();
    }
    
    public void win(){
        closeThread();
    }
    // 스레드 종료
    public void closeThread(){
        flag = false;
    }

    // 공 가져오기
    private Ball getBall(){
        return MapController.getBall();
    }

    public boolean isflag(){
        return flag;
    }
}