package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.controller.UserQueryController;
import com.github.sithumonline.entity.Users;
import com.github.sithumonline.entity.UsersQuery;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML
    public TableColumn tabUsername;
    @FXML
    public TableColumn tabUserId;
    @FXML
    public TableColumn tabPassword;
    @FXML
    public TableColumn tabFullname;
    @FXML
    public TableColumn tabEmail;
    @FXML
    public TableView tabUser;

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

    public void pressSave() throws Exception {
        if (!(txtQueryName.getText().isEmpty() && txtQueryLogic.getText().isEmpty())) {
            UsersQuery usersQuery = new UsersQuery(txtQueryName.getText(), txtQueryLogic.getText());
            UserQueryController.addUser(usersQuery);
            showQueryNameList();
        } else {
            labInfo.setText("Name or Logic is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtQueryId.getText().isEmpty() && txtQueryName.getText().isEmpty() && txtQueryLogic.getText().isEmpty())) {
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
            showQueryNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showQueryNameList() throws Exception {
        ObservableList<UsersQuery> list = UserQueryController.getUserList();

        for (UsersQuery user : list
        ) {
            comQueryName.getItems().add(user.getQueryId() + "~" + user.getName());
        }
    }

    public void pressApply() throws Exception {
        if (!(comQueryName.getSelectionModel().isEmpty())) {
            txtLogic.setText(UserQueryController.getLogicById(comQueryName.getValue().toString().split("~")[0]));
            showUser(UserQueryController.getLogicById(comQueryName.getValue().toString().split("~")[0]));
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void showUser(String logic) throws Exception {
        ObservableList<Users> list = UserController.getAllUsersById(logic);

        tabUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        tabUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tabPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tabFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabUser.setItems(list);
    }
}
