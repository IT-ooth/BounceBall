package com.itooth.cls;

//이동 블럭을 위한 열거체. 이때 생성자를 통해 각 인스턴스 멤버에 속성 부여
public enum Movevector{
    UP(0, -1), 
    DOWN(0, 1), 
    LEFT(-1, 0), 
    RIGHT(1, 0);

    int dx, dy;

    private Movevector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
