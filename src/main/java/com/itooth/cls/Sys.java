package com.itooth.cls;

import com.itooth.controller.MapController;

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

    public double[] getBallpos(){
        return getBall().getPos();
    }

    public double getBallradius(){
        return getBall().getRadius();
    }

    private Ball getBall(){
        return MapController.getBall();
    }

    public void closeThread(){
        MapController.close();
    }
}
