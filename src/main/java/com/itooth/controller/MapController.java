package com.itooth.controller;

import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

import javafx.scene.shape.Rectangle;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.fxml.FXML;

import com.itooth.cls.Movevector;
import com.itooth.cls.Moveblock;
import com.itooth.cls.Normalblock;
import com.itooth.cls.Object;
import com.itooth.cls.Ball;
import com.itooth.cls.Sys;

public class MapController extends Thread implements Initializable{

    @FXML private Circle ball;
    @FXML private Rectangle ground;
    @FXML private Rectangle ground1;
    @FXML private Rectangle ground3;
    @FXML private Rectangle ground4;
    @FXML private Polygon star;
    private static List<Object> sprites = new ArrayList<Object>();

    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        sprites.add(new Ball(ball));
        sprites.add(new Normalblock(ground));
        sprites.add(new Normalblock(ground1));
        sprites.add(new Normalblock(ground3));
        sprites.add(new Moveblock(ground4, Movevector.RIGHT));
        this.start();
    }

    // 스프라이트 업데이트
    public void run(){
        while (Sys.getInstance().isflag()){
            
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

}