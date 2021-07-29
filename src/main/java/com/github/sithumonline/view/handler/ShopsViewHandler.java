package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.ShopController;
import com.github.sithumonline.entity.Shops;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopsViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtType;
    public TextField txtRegistrationNumber;
    public TextField txtOwnersName;
    public TextField txtAddress;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Shops> tabShop;
    public TableColumn<Shops, Integer> colId;
    public TableColumn<Shops, Integer> colShopName;
    public TableColumn<Shops, Integer> colType;
    public TableColumn<Shops, Integer> colRegistrationNumber;
    public TableColumn<Shops, Integer> colOwnersName;
    public TableColumn<Shops, Integer> colAddress;
    public Button butClear;

    public void pressInsert() throws Exception {
        if (!(txtName.getText().isEmpty() && txtType.getText().isEmpty() && txtRegistrationNumber.getText().isEmpty() && txtOwnersName.getText().isEmpty() && txtAddress.getText().isEmpty())) {
            Shops shop = new Shops(txtName.getText(), txtRegistrationNumber.getText(), txtOwnersName.getText(), txtAddress.getText(), txtType.getText());
            ShopController.addShop(shop);
            labInfo.setText("Shop added");
            showShop();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() && txtName.getText().isEmpty() && txtType.getText().isEmpty() && txtRegistrationNumber.getText().isEmpty() && txtOwnersName.getText().isEmpty() && txtAddress.getText().isEmpty())) {
            Shops shop = new Shops(Integer.parseInt(txtID.getText()), txtName.getText(), txtRegistrationNumber.getText(), txtOwnersName.getText(), txtAddress.getText(), txtType.getText());
            ShopController.updateShop(shop);
            labInfo.setText("Shop updated");
            showShop();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            ShopController.deleteShop(txtID.getText());
            labInfo.setText("Shop deleted");
            showShop();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtName.setText("");
        txtType.setText("");
        txtRegistrationNumber.setText("");
        txtOwnersName.setText("");
        txtAddress.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showShop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) {
    }

    public void pressXLXS(ActionEvent actionEvent) {
    }

    public void pressCSV(ActionEvent actionEvent) {
    }

    public void showShop() throws Exception {
        ObservableList<Shops> list = ShopController.getShopList();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colShopName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        colOwnersName.setCellValueFactory(new PropertyValueFactory<>("ownersName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        tabShop.setItems(list);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
