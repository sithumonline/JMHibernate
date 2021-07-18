package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.entity.Users;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SQLViewerHandler implements Initializable {
    @FXML
    public TextField txt_userid;
    @FXML
    public Button but_go_main_plane;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_email;
    @FXML
    private Label lab_info;
    @FXML
    private TableView<Users> tab_user;
    @FXML
    private TableColumn<Users, Integer> tab_userid;
    @FXML
    private TableColumn<Users, String> tab_username;
    @FXML
    private TableColumn<Users, String> tab_password;
    @FXML
    private TableColumn<Users, String> tab_fullname;
    @FXML
    private TableColumn<Users, String> tab_email;

    public void pressInsert() throws Exception {
        if (!(txt_username.getText().isEmpty() && txt_password.getText().isEmpty() && txt_fullname.getText().isEmpty() && txt_email.getText().isEmpty())) {
            Users user = new Users(txt_username.getText(), txt_password.getText(), txt_fullname.getText(), txt_email.getText());
            UserController.addUser(user);
            lab_info.setText("TextField added");
            showUser();
        } else {
            lab_info.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txt_userid.getText().isEmpty()) {
            UserController.deleteUser(txt_userid.getText());
            lab_info.setText("TextField deleted");
            showUser();
        } else {
            lab_info.setText("username is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txt_username.getText().isEmpty() || txt_password.getText().isEmpty() || txt_fullname.getText().isEmpty() || txt_email.getText().isEmpty())) {
            Users user = new Users(txt_userid.getText(), txt_username.getText(), txt_password.getText(), txt_fullname.getText(), txt_email.getText());
            UserController.updateUser(user);
            lab_info.setText("TextField updated");
            showUser();
        } else {
            lab_info.setText("TextField is empty");
        }
    }

    public void pressClear() {
        txt_username.setText("");
        txt_fullname.setText("");
        txt_password.setText("");
        txt_email.setText("");
        txt_userid.setText("");
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
        ObservableList<Users> list = UserController.getUserList();

        tab_userid.setCellValueFactory(new PropertyValueFactory<>("userId"));
        tab_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        tab_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tab_fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tab_user.setItems(list);
    }

    public void goMainPlane() throws Exception {
        App.setRoot("main-plane");
    }
}
