package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserLoginViewHandler {

    public TextField txtUsername;
    public TextField txtPassword;
    public Button butLogin;
    public Button butCreateAccount;
    public Button butForgetPassword;
    public Label labInfo;

    public void pressLogin(ActionEvent actionEvent) throws Exception {
        if (!(txtUsername.getText().isEmpty() && txtPassword.getText().isEmpty())) {
            if (UserController.checkUserPassword(txtUsername.getText(), txtPassword.getText())) {
                labInfo.setText("Password matched");
                App.setRoot("main-plane");
            }
            labInfo.setText("Wrong Username or Password");
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressCreateAccount(ActionEvent actionEvent) throws IOException {
        App.setRoot("users-view");
    }

    public void pressForgetPassword(ActionEvent actionEvent) throws IOException {
        App.setRoot("main-plane");
    }

}
