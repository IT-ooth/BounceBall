package com.itooth.controller;

import java.io.IOException;

import com.itooth.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToMap() throws IOException {
        App.setRoot("map");
    }
}
