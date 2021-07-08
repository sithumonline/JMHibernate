package com.github.sithumonline.view.handler;

import com.github.sithumonline.controller.SQLViewerController;
import com.github.sithumonline.model.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SQLViewerHandler implements Initializable {
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
    private TableView<User> tab_user;
    @FXML
    private TableColumn<User, Integer> tab_userid;
    @FXML
    private TableColumn<User, String> tab_username;
    @FXML
    private TableColumn<User, String> tab_password;
    @FXML
    private TableColumn<User, String> tab_fullname;
    @FXML
    private TableColumn<User, String> tab_email;

    public void pressInsert() throws SQLException {
        if (!(txt_username.getText().isEmpty() && txt_password.getText().isEmpty() && txt_fullname.getText().isEmpty() && txt_email.getText().isEmpty())) {
            User user = new User(txt_username.getText(), txt_password.getText(), txt_fullname.getText(), txt_email.getText());
            SQLViewerController.addUser(user);
            lab_info.setText("TextField added");
            showUser();
        } else {
            lab_info.setText("TextField is empty");
        }
    }

    public void pressDelete() throws SQLException {
        if (!txt_username.getText().isEmpty()) {
            SQLViewerController.deleteUser(txt_username.getText());
            lab_info.setText("TextField deleted");
            showUser();
        } else {
            lab_info.setText("username is empty");
        }
    }

    public void pressUpdate() throws SQLException {
        if (!(txt_username.getText().isEmpty() || txt_password.getText().isEmpty() || txt_fullname.getText().isEmpty() || txt_email.getText().isEmpty())) {
            User user = new User(txt_username.getText(), txt_password.getText(), txt_fullname.getText(), txt_email.getText());
            SQLViewerController.updateUser(user);
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showUser();
    }

    public void showUser() {
        ObservableList<User> list = SQLViewerController.getUserList();

        tab_userid.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        tab_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        tab_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tab_fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tab_user.setItems(list);
    }
}