package com.itooth.cls.abstractcls;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.itooth.cls.Ball;
import com.itooth.cls.Sys;
import com.itooth.App;

import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

public abstract class Controller extends Thread implements Initializable{

    protected static List<Object> sprites = new ArrayList<Object>();
    private static double[] initial_pos = new double[2];

    // 스프라이트 업데이트
    public void run(){
        while (Sys.getInstance().isFlag()){
            
            try {Thread.sleep(10L);}
            catch (InterruptedException e){e.printStackTrace();}

            for (Object obj : sprites){
                obj.update();
            }
        }
        
        sprites.clear();
        Sys.getInstance().setFlag(true);

        this.interrupt();

        try {Thread.sleep(1L);}
        catch (InterruptedException e){e.printStackTrace();}

        String nextMap = Sys.getInstance().nextMap;
        System.out.println(nextMap);
        if (nextMap != ""){
            try {App.setRoot(nextMap);}
            catch (IOException e){e.printStackTrace();}
        }

        return;
    }
    
    // 공 오브젝트 가져오기
    public static Ball getBall(){
        return (Ball) sprites.get(0);
    }

    // 공 초기 위치 세팅 & 넘기기
    protected void setInitial(Circle circle) {
        initial_pos = new double[]{
            circle.getCenterX(),
            circle.getCenterY()
        };
    }
    
    public static double[] getInitial() {
        return initial_pos;
    }
}
