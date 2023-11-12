package com.itooth.cls;

public abstract class Object {

    private double[] center_pos = new double[2];

    public abstract void update();

    protected void setPos(double x, double y){
        center_pos[0] = x;
        center_pos[1] = y;
    }

    public double[] getPos(){
        return center_pos;
    }

}
