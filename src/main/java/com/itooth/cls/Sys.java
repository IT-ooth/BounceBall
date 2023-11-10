package com.itooth.cls;

public class Sys {
    
    private static Sys instance = new Sys();

    private Sys(){}

    public static Sys getInstance(){
        return instance;
    }

    public void crash(){
        Ball.getInstance().crash();
    }
}
