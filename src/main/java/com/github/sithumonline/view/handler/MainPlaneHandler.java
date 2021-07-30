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

    public void switchToCropView() throws IOException {
        App.setRoot("crop-view");
    }

    public void switchToShopView() throws IOException {
        App.setRoot("shops-view");
    }

    public void switchToFamilyView() throws IOException {
        App.setRoot("family-view");
    }

    public void switchToPersonView() throws IOException {
        App.setRoot("person-view");
    }

    public void switchToHomeView() throws IOException {
        App.setRoot("home-view");
    }
}
