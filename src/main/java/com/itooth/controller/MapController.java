package com.itooth.controller;

import java.util.ResourceBundle;

import java.net.URL;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.fxml.FXML;

import com.itooth.cls.Ball;
import com.itooth.cls.Block;
import com.itooth.cls.abstractcls.Controller;

public class MapController extends Controller{

    @FXML private Circle ball;
    @FXML private Rectangle ground;
    @FXML private Rectangle ground1;
    @FXML private Rectangle ground3;
    @FXML private Polygon star;

    // 초기화
    @Override
    public void initialize(URL location, ResourceBundle resources){
        sprites.add(new Ball(ball));
        sprites.add(new Block(ground));
        sprites.add(new Block(ground1));
        sprites.add(new Block(ground3));
        this.start();
    }
}
