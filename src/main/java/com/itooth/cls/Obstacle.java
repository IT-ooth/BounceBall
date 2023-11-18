package com.itooth.cls;

import javafx.scene.shape.Rectangle;

public class Obstacle extends Block{
    
    private Rectangle rectangle;

    public Obstacle(Rectangle block){
        rectangle = block;   
    }

    @Override
    public void update() {
        if (isCrashto(getBounds(rectangle))) {
            gameover();
        }
    }

    private void gameover() {
        Sys.getInstance().resetBall();
    }
}
