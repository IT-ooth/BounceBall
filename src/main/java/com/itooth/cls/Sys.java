package com.itooth.cls;

import com.itooth.controller.MapController;

import javafx.geometry.Bounds;

public class Sys {
    
    private static Sys instance = new Sys();
    public static boolean flag = true;

    private Sys(){}

    public static Sys getInstance(){
        return instance;
    }

    public void crash(){
        getBall().crash();
    }

    public Bounds getBallbound(){
        return MapController.getBall().getBounds();
    }
    private Ball getBall(){
        return MapController.getBall();
    }

    public void closeThread(){
        MapController.close();
    }
}
