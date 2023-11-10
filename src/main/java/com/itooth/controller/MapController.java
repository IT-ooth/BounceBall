package com.itooth.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import com.itooth.cls.Ball;
import com.itooth.cls.Object;

public class MapController extends Thread implements Initializable {

    @FXML private Circle ball;
    
    private List<Object> sprites = new ArrayList<Object>();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        

        sprites.add(Ball.getInstance(ball));
        this.start();
    }

    public void run(){
        
        while (!Thread.currentThread().isInterrupted()) {
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Object obj : this.sprites){
                obj.update();
            } 
        }
    }
}
