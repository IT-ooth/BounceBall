package com.itooth.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import com.itooth.cls.Ball;
import com.itooth.cls.Normalblock;
import com.itooth.cls.Object;
import com.itooth.cls.Sys;

public class MapController extends Thread implements Initializable {

    @FXML private Circle ball;
    @FXML private Rectangle ground;

    private static List<Object> sprites = new ArrayList<Object>();

    @Override
    public void initialize(URL location, ResourceBundle resources){

        // 각 스프라이트를 모아서

        sprites.add(new Ball(ball));
        sprites.add(new Normalblock(ground));
        this.start();
    }

    public void run(){
        
        while (Sys.flag) {
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 전체를 틱마다 업데이트 하기
            for (Object obj : sprites){
                obj.update();
            } 
        }

        this.interrupt();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Ball getBall(){
        return (Ball) sprites.get(0);
    }

    public static void close(){
        Sys.flag = false;
    }
    
}
