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
    // TODO 충돌 실행코든지 충돌 감지 후 충돌실행코드까지 연결해 주는 함수인지 구분 필요할듯
    public void crash(){
        getBall().crashed();
    }

    // 공 bounds값 가져오기
    public Bounds getBallbound(){
        return getBall().getBounds();
    }
    
    // TODO 이 자체에서 flag를 false로 바꿔주면 될 것 같음
    // 스레드 종료
    public void closeThread(){
        MapController.close();
    }

    // 공 가져오기
    private Ball getBall(){
        return MapController.getBall();
    }
}
