package com.itooth.cls;

import com.itooth.controller.MapController;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.utility.Platform;

public class Sys{
    
    private static Sys instance = new Sys();
    private boolean flag = true;
    public static Group starGroup;

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
        double[] ini = MapController.getInitial();
        getBall().resetBall(ini[0], ini[1]);
    }

    // ------- star -------
    // 공과 충돌한 별 지우기
    public static void reduceStar(Polygon polygon){
        if (starGroup.getChildren().isEmpty()){
            System.out.println("Stage Clear");
            // TODO 다음 스테이지로 넘어가는 함수
        }
        else{
            // 원래 javafx에서 작업 스레드는 UI 변경 못해서 Platform.runLater() 함수로 별의 Polygon UI를 삭제함
            Platform.runLater(() -> {starGroup.getChildren().remove(polygon);});
        }
    }
}
