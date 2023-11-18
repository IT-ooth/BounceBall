package com.itooth.controller;

import java.util.ResourceBundle;

import java.net.URL;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;


import com.itooth.cls.Obstacle;
import com.itooth.cls.Ball;
import com.itooth.cls.Block;
import com.itooth.cls.abstractcls.Controller;

public class MapController extends Controller{

    @FXML private Circle ball;
    @FXML private Rectangle ground;
    @FXML private Rectangle ground1;
    @FXML private Rectangle ground3;
    @FXML private Rectangle ob;

    private static double[] initial_pos = new double[2];


    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        setInitial();

        sprites.add(new Ball(ball));
        sprites.add(new Block(ground));
        sprites.add(new Block(ground1));
        sprites.add(new Block(ground3));

        sprites.add(new Obstacle(ob)); 

        this.start();
    }
    // 공 초기 위치 세팅 & 넘기기
    private void setInitial() {
        initial_pos[0] = ball.getCenterX();
        initial_pos[1] = ball.getCenterY();
    }
    
    public static double[] getInitial() {
        return initial_pos;
    }
}
