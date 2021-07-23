package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.controller.BeneficiaryListsController;
import com.github.sithumonline.entity.Users;
import com.github.sithumonline.entity.BeneficiaryLists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BeneficiaryListsViewHandler implements Initializable {
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
    @FXML
    public ChoiceBox comKind;

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

    public void pressSave() throws Exception {
        if (!(txtQueryName.getText().isEmpty() && txtQueryLogic.getText().isEmpty() && comKind.getSelectionModel().isEmpty())) {
            BeneficiaryLists usersQuery = new BeneficiaryLists(comKind.getValue().toString(), txtQueryName.getText(), txtQueryLogic.getText());
            BeneficiaryListsController.addUser(usersQuery);
            showQueryNameList();
        } else {
            labInfo.setText("Kind, Name or Logic is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtQueryId.getText().isEmpty() && txtQueryName.getText().isEmpty() && txtQueryLogic.getText().isEmpty())) {
            BeneficiaryLists usersQuery = new BeneficiaryLists(txtQueryId.getText(), txtQueryName.getText(), txtQueryLogic.getText());
            BeneficiaryListsController.updateUser(usersQuery);
        } else {
            labInfo.setText("Query ID, Name or Logic is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!(txtQueryId.getText().isEmpty())) {
            BeneficiaryListsController.deleteUser(txtQueryId.getText());
        } else {
            labInfo.setText("Query ID is empty");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tabUser.setVisible(false);
            comKind.setItems(FXCollections.observableArrayList("User"));
            showQueryNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showQueryNameList() throws Exception {
        ObservableList<BeneficiaryLists> list = BeneficiaryListsController.getUserList();

        for (BeneficiaryLists user : list
        ) {
            comQueryName.getItems().add(user.getQueryId() + "~" + user.getKind() + "~" + user.getName());
        }
    }

    public void pressApply() throws Exception {
        if (!(comQueryName.getSelectionModel().isEmpty())) {
            txtLogic.setText(BeneficiaryListsController.getLogicById(comQueryName.getValue().toString().split("~")[0]));
            switch (comQueryName.getValue().toString().split("~")[1]) {
                case "User":
                    tabUser.setVisible(true);
                    showUser(BeneficiaryListsController.getLogicById(comQueryName.getValue().toString().split("~")[0]));
                    break;
                default:
                    labInfo.setText("Something going to wrong");
            }
        } else {
            labInfo.setText("Query Name or Kind not selected");
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
