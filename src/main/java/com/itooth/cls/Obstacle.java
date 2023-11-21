package com.itooth.cls;

import javafx.scene.Node;

public class Obstacle extends Block{
    // node로 변경
    public Obstacle(Node block){
        super(block);
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
 