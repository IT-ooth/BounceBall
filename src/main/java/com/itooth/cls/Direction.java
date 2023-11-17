package com.itooth.cls;

public enum Direction {
    TOP{
        @Override
        void jump(){
            Block.getInstance().topCrash();
        }
    },
    BOTTOM{
        @Override
        void jump(){
            Block.getInstance().bottomCrash();
        }
    },
    LEFT{
        @Override
        void jump(){
            Block.getInstance().leftCrash();
        }
    },
    RIGHT{
        @Override
        void jump(){
            Block.getInstance().rightCrash();
        }
    },
    OBLIQUE{
        @Override
        void jump(){
            Block.getInstance().diagonalCrash();
        }
    };

    abstract void jump();
}
