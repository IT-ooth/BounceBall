package com.itooth.controller;

import java.io.IOException;

import com.itooth.App;

import javafx.fxml.FXML;

public class LastmapController {

    @FXML
    private void restart() throws IOException {
        App.setRoot("map");
    }

    @FXML
    private void exit() throws IOException {
        System.exit(1);
    }
}
