package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.entity.Users;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPlaneHandler implements Initializable {
    public ComboBox comProfileList;
    public Label labInfo;
    private ObservableList<Users> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            list = UserController.getUserList();

            for (Users user : list
            ) {
                comProfileList.getItems().add(user.getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public void switchToLoginView() throws IOException {
        App.setRoot("login-view");
    }

    public void pressProfile() throws IOException {
        if (!(comProfileList.getSelectionModel().isEmpty())) {
            for (Users user : list
            ) {
                if (comProfileList.getValue().toString().equals(user.getUsername())) {
                    App.setUser(user);
                    App.setRoot("users-view");
                }
            }
        } else {
            labInfo.setText("User Name not selected");
        }
    }

}
