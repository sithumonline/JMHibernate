package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.entity.Users;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class UsersViewHandler implements Initializable {
    @FXML
    public TextField txtUserId;
    @FXML
    public Button butGoMainPlane;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtFullname;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label labInfo;
    @FXML
    private TableView<Users> tabUser;
    @FXML
    private TableColumn<Users, Integer> tabUserId;
    @FXML
    private TableColumn<Users, String> tabUsername;
    @FXML
    private TableColumn<Users, String> tabPassword;
    @FXML
    private TableColumn<Users, String> tabFullname;
    @FXML
    private TableColumn<Users, String> tabEmail;
    private ObservableList<Users> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!(txtUsername.getText().isEmpty() && txtPassword.getText().isEmpty() && txtFullname.getText().isEmpty() && txtEmail.getText().isEmpty())) {
            Users user = new Users(txtUsername.getText(), txtPassword.getText(), txtFullname.getText(), txtEmail.getText());
            UserController.addUser(user);
            labInfo.setText("TextField added");
            goLoginView();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtUserId.getText().isEmpty()) {
            UserController.deleteUser(txtUserId.getText());
            labInfo.setText("TextField deleted");
            App.setRoot("login-view");
        } else {
            labInfo.setText("username is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtUserId.getText().isEmpty() && txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtFullname.getText().isEmpty() || txtEmail.getText().isEmpty())) {
            Users user = new Users(txtUserId.getText(), txtUsername.getText(), txtPassword.getText(), txtFullname.getText(), txtEmail.getText());
            UserController.updateUser(user);
            labInfo.setText("TextField updated");
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressClear() {
        txtUsername.setText("");
        txtFullname.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
        txtUserId.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showUserInit(App.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showUserInit(Users user) {
        txtUsername.setText(user.getUsername());
        txtFullname.setText(user.getFullname());
        txtPassword.setText(user.getPassword());
        txtEmail.setText(user.getEmail());
        txtUserId.setText(user.getUserId());
    }

    public void showUser() throws Exception {
        ObservableList<Users> list = UserController.getUserList();

        tabUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        tabUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tabPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tabFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabUser.setItems(list);
    }

    public void goMainPlane() throws Exception {
        App.setRoot("main-plane");
    }

    public void goLoginView() throws Exception {
        App.setRoot("login-view");
    }

    public void pressXLXS() throws Exception {
        if (out == null) {
            out = UserController.getUserList();
        }
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Users user : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            user.getUserId(),
                            user.getUsername(),
                            user.getPassword(),
                            user.getFullname(),
                            user.getEmail()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV() throws Exception {
        if (out == null) {
            out = UserController.getUserList();
        }
        List<String[]> csvData = new ArrayList<>();
        for (Users user : out
        ) {
            csvData.add(
                    new String[]{
                            user.getUserId(),
                            user.getUsername(),
                            user.getPassword(),
                            user.getFullname(),
                            user.getEmail()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

}
