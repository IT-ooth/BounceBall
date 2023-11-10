package com.itooth.cls;


public class Normalblock extends Block{

    @Override
    public void update() {
        // 충돌 시 코드
        if (isCrash()){
            Sys.getInstance().crash();
        }
    }

    @Override
    protected boolean isCrash() {
        
        // 충돌 유무 판정 코드
        return false;
    }
}
