package com.itooth;


public class Ball extends Object{

    double x = 0, y = 0, t = 0;

    private final double acceleration = -10, initial_speed = 10;
    
    @Override
    public double[] run() {
        
        if (t == 2){
            t = 0;
        }
        
        y = initial_speed * t + 0.5 * acceleration * t * t;
        
        t += 0.1;

        return new double[]{x, y};
    }
    
}
