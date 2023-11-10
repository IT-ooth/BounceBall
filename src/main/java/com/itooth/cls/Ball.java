package com.itooth.cls;

import javafx.scene.shape.Circle;

public class Ball extends Object{

    private static double time = 0;
    private static Circle circle;
    
    private static final double acceleration = -10, initial_speed = 10;

    public Ball(Circle c){
        circle = c;
    }

    @Override
    public void update(){
        
        time += 0.01;
        
        if (time >= 2){
            time = 0;
        }

        setPos(calPos()[0], circle.getLayoutY() - calPos()[1] * 10);
        
        circle.setCenterX(getPos()[0]);
        circle.setCenterY(getPos()[1]);

        System.out.println(getPos()[1]);
    }

    public void crash(){
        time = 0;
    }

    private double[] calPos(){
        // 공 낙하 로직
        return new double[] {0, initial_speed * time + 0.5 * acceleration * time * time};
    }


}
