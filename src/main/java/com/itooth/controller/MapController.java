package com.itooth.controller;

import java.util.ResourceBundle;

import java.net.URL;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.fxml.FXML;


import com.itooth.cls.Obstacle;
import com.itooth.cls.Ball;
import com.itooth.cls.Block;
import com.itooth.cls.abstractcls.Controller;

public class MapController extends Controller{

    @FXML private Circle ball;
    @FXML private Group stars;
    @FXML private Group blocks;
    @FXML private Group obstacles;

    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        setInitial(ball);

        //ball 객체는 sprites에서 무조건 0번째 인덱스여야 함.
        sprites.add(new Ball(ball));

        for (Node block: blocks.getChildren()){
            sprites.add(new Block((Rectangle)block));
        }

        for (Node obs: obstacles.getChildren()){
            sprites.add(new Obstacle((Rectangle)obs));
        }

        this.start();
    }

}
