package com.itooth.cls;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//소멸블럭 - 위에서 밟을 경우 소멸되는 블럭
public class Deleteblock extends Normalblock{

    private boolean exist = true;

    public Deleteblock(Rectangle rectangle) {
        super(rectangle);
    }

    //블럭 업데이트 함수
    @Override
    public void update() {
        if(exist == true) 
            runBlock(getBounds(rectangle));
    }
    
    //공이 블럭의 윗면에 충돌했을 때만 블럭이 삭제되도록 topcrash() 오버로딩
    @Override
    protected void topCrash(){
        Sys.getInstance().runcrash(Direction.TOP);
        exist = false;
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.WHITE);
    }
}
