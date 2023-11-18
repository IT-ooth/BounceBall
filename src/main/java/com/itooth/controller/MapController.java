package com.itooth.controller;

import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

import javafx.scene.shape.Rectangle;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;

import com.itooth.cls.Normalblock;
import com.itooth.cls.Object;
import com.itooth.cls.Obstacle;
import com.itooth.cls.Ball;
import com.itooth.cls.Sys;

public class MapController extends Thread implements Initializable{

    @FXML private Circle ball;
    @FXML private Rectangle ground;
    @FXML private Rectangle ground1;
    @FXML private Rectangle ground3;
    @FXML private Rectangle ob;

    private static List<Object> sprites = new ArrayList<Object>();
    private static double initial_x;
    private static double initial_y;


    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        setInitial();

        sprites.add(new Ball(ball));
        sprites.add(new Normalblock(ground));
        sprites.add(new Normalblock(ground1));
        sprites.add(new Normalblock(ground3));
        sprites.add(new Obstacle(ob));

        this.start();
    }

    // 스프라이트 업데이트
    public void run(){
        while (Sys.getInstance().isFlag()){
            
            try {Thread.sleep(10L);}
            catch (InterruptedException e){e.printStackTrace();}

            for (Object obj : sprites){
                obj.update();
            }
        }

        this.interrupt();

        try {Thread.sleep(1L);}
        catch (InterruptedException e){e.printStackTrace();}
    }

    // 공 초기 위치 세팅 & 넘기기
    private void setInitial() {
        initial_x = ball.getCenterX();
        initial_y = ball.getCenterY();
    }
    public static double[] getInitial() {
        return new double[] {initial_x, initial_y};
    }

    // 공 오브젝트 가져오기
    public static Ball getBall(){
        return (Ball) sprites.get(0);
    }
}
