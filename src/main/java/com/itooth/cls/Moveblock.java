package com.itooth.cls;

import javafx.scene.shape.Rectangle;

//나무위키.바운스볼->단칸 이동기 구현
public class Moveblock extends Block{

    private Movevector vector;

    //생성자
    public Moveblock(Rectangle block, Movevector vector){
        super(block);
        this.vector = vector;
    } 

    //공이 블럭의 윗면에 충돌했을 때만 블럭이 이동하도록 topcrash() 오버로딩
    @Override
    public void topCrash(){
        if (isCrashto(getBounds(rectangle))){
            whereCrashto(getPos(getBounds(rectangle)), getPos(Sys.getInstance().getBallBounds()));
        }
        move();
    }
    
    //블럭 업데이트 함수
    @Override
    public void update() {
        if (isCrashto(getBounds(rectangle))){
            whereCrashto(getPos(getBounds(rectangle)), getPos(Sys.getInstance().getBallBounds()));
        }
    }

    //블럭 움직임 구현
    private void move() {
        rectangle.setX(rectangle.getX() + vector.dx * rectangle.getWidth());
        rectangle.setY(rectangle.getY() + vector.dy * rectangle.getWidth());
    }
}