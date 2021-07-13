package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class UsersFormHandler {
    @FXML
    private void switchToViewUsers() throws IOException {
        App.setRoot("secondary");
    }
}
