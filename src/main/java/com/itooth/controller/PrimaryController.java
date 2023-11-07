package com.itooth.controller;

import java.io.IOException;

import com.itooth.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
