package com.itooth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage; 

import java.io.IOException;

import com.itooth.cls.Sys;

/**
 * JavaFX App   
 */
public class App extends Application{

    private static Scene scene;

    // 화면 송출
    @Override
    public void start(Stage stage) throws IOException{
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();

        // window close event listener
        stage.setOnCloseRequest(e -> Sys.getInstance().closeThread());
    }

    // fxml 연결
    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }

    // fxml 로드
    private static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args){
        launch();
    }
}