package com.itooth.controller;

import java.util.ResourceBundle;

import java.net.URL;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.fxml.FXML;


import com.itooth.cls.Obstacle;
import com.itooth.cls.Sys;
import com.itooth.cls.Ball;
import com.itooth.cls.Block;
import com.itooth.cls.Star;
import com.itooth.cls.abstractcls.Controller;

public class MapController extends Controller{

    @FXML private Circle ball;
    @FXML private Group stars;
    @FXML private Group blocks;
    @FXML private Group obstacles;
    @FXML private Polygon star1;
    @FXML private Polygon star2;

    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        setInitial(ball);

        //ball 객체는 sprites에서 무조건 0번째 인덱스여야 함.
        sprites.add(new Ball(ball));

        //star 객체 초기화
        Sys.getInstance().setStarGroup(stars);
        for (Node star: stars.getChildren()) {
            sprites.add(new Star(star));
        }

        for (Node block: blocks.getChildren()){
            sprites.add(new Block(block));
        }

        for (Node obs: obstacles.getChildren()){
            sprites.add(new Obstacle(obs));
        }

        this.start();
    }

}
