package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserQueryController;
import com.github.sithumonline.entity.UsersQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersSearchHandler implements Initializable {
    @FXML
    public TextField txtQueryLogic;
    @FXML
    public TextField txtQueryName;
    @FXML
    public TextField txtQueryId;
    @FXML
    public Label labInfo;
    @FXML
    public ComboBox comQueryName;
    @FXML
    public TextField txtLogic;

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

    public void pressSave() throws Exception {
        if (!(txtQueryName.getText().isEmpty() && txtQueryName.getText().isEmpty())) {
            UsersQuery usersQuery = new UsersQuery(txtQueryName.getText(), txtQueryLogic.getText());
            UserQueryController.addUser(usersQuery);
        } else {
            labInfo.setText("Name or Logic is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtQueryId.getText().isEmpty() && txtQueryName.getText().isEmpty() && txtQueryName.getText().isEmpty())) {
            UsersQuery usersQuery = new UsersQuery(txtQueryId.getText(), txtQueryName.getText(), txtQueryLogic.getText());
            UserQueryController.updateUser(usersQuery);
        } else {
            labInfo.setText("Query ID, Name or Logic is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!(txtQueryId.getText().isEmpty())) {
            UserQueryController.deleteUser(txtQueryId.getText());
        } else {
            labInfo.setText("Query ID is empty");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showUser() throws Exception {
        ObservableList<UsersQuery> list = UserQueryController.getUserList();

        for (UsersQuery user : list
        ) {
            comQueryName.getItems().add(user.getName());
        }
    }

    public void pressApply() throws Exception {
        if (!(comQueryName.getSelectionModel().isEmpty())) {
            txtLogic.setText(UserQueryController.getLogicByName(comQueryName.getValue().toString()));
        } else {
            labInfo.setText("Query Name not selected");
        }
    }
}
