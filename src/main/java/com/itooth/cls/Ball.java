package com.itooth.cls;

import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static Circle circle;
    
    private static final double acceleration = -10, initial_speed = 10;
    private static Ball instance = new Ball();

    private Ball(){}

    public static Ball getInstance(Circle circle){
        connectSprite(circle);
        return instance;
    }

    public static Ball getInstance(){
        return instance;
    }

    private static void connectSprite(Circle c){
        circle = c;
    }

    @Override
    public void update(){
        
        time += 0.1;

        setPos(calPos()[0], calPos()[1]);
         
        circle.setCenterX(getPos()[0]);
        circle.setCenterY(getPos()[1]);
    }

    public void crash(){
        time = 0;
    }

    private double[] calPos(){
        return new double[] {0, initial_speed * time + 0.5 * acceleration * time * time};
    }


}
