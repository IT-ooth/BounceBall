package com.itooth.cls;

import javafx.scene.shape.Rectangle;

//나무위키.바운스볼->단칸 이동기 구현
public class Moveblock extends Block{

    private Rectangle moveBlock;
    private Movevector vector;

    //생성자
    public Moveblock(Rectangle block, Movevector vector){
        moveBlock = block;   
        this.vector = vector;
    } 

    //공이 블럭의 윗면에 충돌했을 때만 블럭이 이동하도록 bottomcrash() 오버로딩
    @Override
    protected void topCrash(){
        Sys.getInstance().runcrash(Direction.TOP);
        move();
    }
    
    //블럭 업데이트 함수
    @Override
    public void update() {
        runBlock(getBounds(moveBlock));
    }

    //블럭 움직임 구현
    private void move() {
        moveBlock.setX(moveBlock.getX() + vector.dx * moveBlock.getWidth());
        moveBlock.setY(moveBlock.getY() + vector.dy * moveBlock.getWidth());
    }
}