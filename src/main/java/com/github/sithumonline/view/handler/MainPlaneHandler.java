package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import javafx.event.ActionEvent;
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
    @FXML
    public void switchToBeneficiaryLists() throws IOException {
        App.setRoot("beneficiary-lists-view");
    }

    public void switchToEventView() throws IOException {
        App.setRoot("events-view");
    }

    public void switchToSocietyView() throws IOException {
        App.setRoot("societies-view");
    }

}
