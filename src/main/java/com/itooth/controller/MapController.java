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
import com.itooth.cls.Ball;
import com.itooth.cls.Sys;

public class MapController extends Thread implements Initializable{

    @FXML private Circle ball;
    @FXML private Rectangle ground;

    private static List<Object> sprites = new ArrayList<Object>();

    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        sprites.add(new Ball(ball));
        sprites.add(new Normalblock(ground));

        this.start();
    }

    // 스프라이트 업데이트
    public void run(){
        while (Sys.flag){
            
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

    // 공 오브젝트 가져오기
    public static Ball getBall(){
        return (Ball) sprites.get(0);
    }

    // 스레드 종료
    public static void close(){
        Sys.flag = false;
    }
}
