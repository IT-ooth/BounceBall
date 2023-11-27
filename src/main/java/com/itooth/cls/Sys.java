package com.itooth.cls;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.application.Platform;

public class Sys{
    
    private static Sys instance = new Sys();
    private boolean flag = true;
    private int numOfstar = 0;
    public Group starGroup;
    public String nextMap = "";
    //public List<Object> sprites = new ArrayList<Object>();
    public Ball ball;

    private Sys(){}

    // 생성자
    public static Sys getInstance(){
        return instance;
    }

    public void setObject(Ball ball, Group stars){
        this.ball = ball;
        starGroup = stars;
    }
    
    // ------- THREAD -------
    // 별 다먹었을 때 쓰는 함수
    public void win(){
        //System.out.println("Stage Clear");

        //resetBall();

        // try {App.setRoot("Map2");}
        // catch (IOException e){e.printStackTrace();}

        //closeThread();
    }
    
    // 스레드 종료
    public void closeThread(){
        flag = false;
    }
    // 
    public boolean isFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
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
        return ball;
        //return MapController.getBall();
    }
    // 공 초기화하기
    public void resetBall(){
        getInstance().nextMap = "map";
        getInstance().closeThread();
        // try {App.setRoot("Map");}
        // catch (IOException e){e.printStackTrace();}
        //getBall().resetBall(MapController.getInitial());
    }

    // ------- star -------
    // 공과 충돌한 별 지우기
    public void reduceStar(Node node){

        // 원래 javafx에서 작업 스레드는 UI 변경 못해서 Platform.runLater() 함수로 별의 Polygon UI를 삭제함
        Platform.runLater(() -> {starGroup.getChildren().remove(node);});
        numOfstar -= 1;

        if (numOfstar <= 0){
            win();
        }
        else{
            
        }
    }
}
