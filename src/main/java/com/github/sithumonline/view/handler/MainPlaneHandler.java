package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainPlaneHandler {
    @FXML
    private void switchToViewUsers() throws IOException {
        App.setRoot("users-view");
    }
    @FXML
    private void switchToSearchUsers() throws IOException {
        App.setRoot("users-search");
    }
}
