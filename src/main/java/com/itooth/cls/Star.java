package com.itooth.cls;

import javafx.scene.shape.Polygon;

public class Star extends Block{

    private Polygon star;
    public Star(Polygon s){
        star = s;
    }

    @Override
    public void update() {
        if (isCrashto(getBounds(star))){
            Sys.getInstance().win();
            System.out.println("Win");
        }
    }
    
}
