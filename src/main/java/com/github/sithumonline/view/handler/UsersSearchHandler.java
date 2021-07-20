package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserQueryController;
import com.github.sithumonline.entity.UsersQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UsersSearchHandler {
    @FXML
    public TextField txtQueryLogic;
    @FXML
    public TextField txtQueryName;
    @FXML
    public TextField txtQueryId;
    @FXML
    public Label labInfo;

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

    public void pressSave() throws Exception {
        if(!(txtQueryName.getText().isEmpty() && txtQueryName.getText().isEmpty())) {
            UsersQuery usersQuery = new UsersQuery(txtQueryName.getText(), txtQueryLogic.getText());
            UserQueryController.addUser(usersQuery);
        } else {
            labInfo.setText("Name or Logic is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if(!(txtQueryId.getText().isEmpty() && txtQueryName.getText().isEmpty() && txtQueryName.getText().isEmpty())) {
            UsersQuery usersQuery = new UsersQuery(txtQueryId.getText(), txtQueryName.getText(), txtQueryLogic.getText());
            UserQueryController.updateUser(usersQuery);
        } else {
            labInfo.setText("Query ID, Name or Logic is empty");
        }
    }

    public void pressDelete() throws Exception {
        if(!(txtQueryId.getText().isEmpty())) {
            UserQueryController.deleteUser(txtQueryId.getText());
        } else {
            labInfo.setText("Query ID is empty");
        }
    }
}
