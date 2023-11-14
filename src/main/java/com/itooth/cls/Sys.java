package com.itooth.cls;

import com.itooth.controller.MapController;

import javafx.geometry.Bounds;

public class Sys{
    
    private static Sys instance = new Sys();
    public static boolean flag = true;

    private Sys(){}

    // 생성자
    public static Sys getInstance(){
        return instance;
    }

    // 충돌 실행 코드
    public void crash(){
        getBall().crashed();
    }

    // 공 bounds값 가져오기
    public Bounds getBallbound(){
        return getBall().getBounds();
    }
    
    // 스레드 종료
    public void closeThread(){
        MapController.close();
    }

    // 공 가져오기
    private Ball getBall(){
        return MapController.getBall();
    }
}
