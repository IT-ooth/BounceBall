package com.itooth.cls;

import javafx.scene.shape.Circle;

public class Ball extends Object{

    private double time = 0;
    private double[] pos = new double[]{0, 0};
    private Circle circle;

    private final double acceleration = -10, initial_speed = 10;

    public Ball(Circle circle){
        this.circle = circle;
    }

    @Override
    public void update(){
        
        set_pos();
        
        this.circle.setCenterX(pos[0]);
        this.circle.setCenterY(pos[1]);
    }

    private void set_pos(){
        
        time += 0.1;

        this.pos[1] = initial_speed * time + 0.5 * acceleration * time * time;

        if (time >= 2){
            time = 0;
        }
    }
}
