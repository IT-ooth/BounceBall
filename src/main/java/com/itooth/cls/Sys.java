package com.itooth.cls;

import com.itooth.controller.MapController;

public class Sys {
    
    private static Sys instance = new Sys();

    private Sys(){}

    public static Sys getInstance(){
        return instance;
    }

    public void crash(){
        MapController.crash();
    }
}
