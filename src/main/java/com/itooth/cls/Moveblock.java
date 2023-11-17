package com.itooth.cls;

import javafx.scene.shape.Rectangle;

//나무위키.바운스볼->단칸 이동기 구현
public class Moveblock extends Block{

    private Rectangle moveBlock;
    private int index;
    //moveX : moveBlock의 X좌표 움직임
    //moveY : moveBlock의 y좌표 움직임
    private int[] moveX = new int[]{0, 0, -1, 1};
    private int[] moveY = new int[]{-1, 1, 0, 0};

    //생성자
    public Moveblock(Rectangle block, int index){
        moveBlock = block;   
        this.index = index;
    } 
    
    //블럭 업데이트 함수
    @Override
    public void update() {
        if (isCrashto(getBounds(moveBlock))){
            move();
            Sys.getInstance().crash();
        };
    }

    //블럭 움직임 구현
    private void move() {
        moveBlock.setX(moveBlock.getX() + moveX[index]);
        moveBlock.setY(moveBlock.getY() + moveY[index]);
    }
}
