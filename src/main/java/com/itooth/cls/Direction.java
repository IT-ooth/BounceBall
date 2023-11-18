package com.itooth.cls;

public enum Direction {
    TOP{
        @Override
        void jump(){
            Block.topCrash();
        }
    },
    BOTTOM{
        @Override
        void jump(){
            Block.bottomCrash();
        }
    },
    LEFT{
        @Override
        void jump(){
            Block.leftCrash();
        }
    },
    RIGHT{
        @Override
        void jump(){
            Block.rightCrash();
        }
    },
    OBLIQUE{
        @Override
        void jump(){
            Block.diagonalCrash();
        }
    };

    abstract void jump();
}
