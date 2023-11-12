package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Normalblock extends Block{

    private Rectangle rectangle;

    public Normalblock(Rectangle block){
        rectangle = block;   
    }
    
    @Override
    public void update() {
        // 충돌 시 코드
        if (isCrash()){
            Sys.getInstance().crash();
        }
    }

    @Override
    protected boolean isCrash() {

        if (getDistance(Sys.getInstance().getBallpos(), findClosepos()) <= Sys.getInstance().getBallradius()){
            return true;
        }

        return false;
    }

    private double[] findClosepos(){

        double[] mainpos = new double[] {rectangle.getLayoutX(), rectangle.getLayoutY()};
        double[] ballpos = Sys.getInstance().getBallpos();

        double[] newPos = new double[] {
            mainpos[0] - Math.sqrt(
                Math.pow(getDistance(mainpos, ballpos), 2) - 
                Math.pow(rectangle.getHeight() / 2, 2)
            ),
            mainpos[1] + rectangle.getHeight() / 2
        };
        
        return newPos;
    }

    private double getDistance(double[] mainPos, double[] subPos){
        return Math.sqrt(
            Math.pow(mainPos[0] - subPos[0], 2) +
            Math.pow(mainPos[1] - subPos[1], 2)
        );
    }


}
