package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.PersonController;
import com.github.sithumonline.entity.Person;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.ShopController;
import com.github.sithumonline.entity.Shops;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    public TextField txtSearchBox;
    private ObservableList<Shops> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!validateName() | !validateType() | !validateRegNo() | !validateOwnerName() | !validateAddress()) {
            txtName.setOnMouseClicked(event -> {
                txtName.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtName.setText("");
            });
            txtRegistrationNumber.setOnMouseClicked(event -> {
                txtRegistrationNumber.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtRegistrationNumber.setText("");
            });
            txtOwnersName.setOnMouseClicked(event -> {
                txtOwnersName.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtOwnersName.setText("");
            });
            txtAddress.setOnMouseClicked(event -> {
                txtAddress.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtAddress.setText("");
            });
            txtType.setOnMouseClicked(event -> {
                txtType.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtType.setText("");
            });
            return;
        } else {
            //labInfo.setText("TextField is empty");
            Shops shop = new Shops(txtName.getText(), txtRegistrationNumber.getText(), txtOwnersName.getText(), txtAddress.getText(), txtType.getText());
            ShopController.addShop(shop);
            labInfo.setText("Shop added");
            showShop();
        }
    }

    private Boolean validateName(){
        String val = txtName.getText();
        String pattern = "^[a-zA-Z.]+$";

        if(val.isEmpty()) {
            txtName.setText("Cannot be empty");
            txtName.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtName.setText("Must have only letters");
            txtName.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateRegNo(){
        String val = txtRegistrationNumber.getText();
        String pattern = "^[a-zA-Z0-9]+$";

        if(val.isEmpty()) {
            txtRegistrationNumber.setText("Cannot be empty");
            txtRegistrationNumber.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtRegistrationNumber.setText("Must have only letters");
            txtRegistrationNumber.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateType(){
        String val = txtType.getText();
        String pattern = "^[a-zA-Z]+$";

        if(val.isEmpty()) {
            txtType.setText("Cannot be empty");
            txtType.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtType.setText("Must have only letters");
            txtType.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateOwnerName(){
        String val = txtOwnersName.getText();
        String pattern = "^[a-zA-Z.]+$";

        if(val.isEmpty()) {
            txtOwnersName.setText("Cannot be empty");
            txtOwnersName.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtOwnersName.setText("Must have only letters");
            txtOwnersName.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateAddress(){
        String val = txtAddress.getText();
        String pattern = "^[a-zA-Z0-9,/]+$";

        if(val.isEmpty()) {
            txtAddress.setText("Cannot be empty");
            txtAddress.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtAddress.setText("Must have only letters");
            txtAddress.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() || txtName.getText().isEmpty() || txtType.getText().isEmpty() || txtRegistrationNumber.getText().isEmpty() || txtOwnersName.getText().isEmpty() || txtAddress.getText().isEmpty())) {
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

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = ShopController.getAllShopsById(txtSearchBox.getText());
            showShop();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Shops shop : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(shop.getId()),
                            shop.getName(),
                            shop.getRegistrationNumber(),
                            shop.getOwnersName(),
                            shop.getAddress(),
                            shop.getType()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (Shops shop : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(shop.getId()),
                            shop.getName(),
                            shop.getRegistrationNumber(),
                            shop.getOwnersName(),
                            shop.getAddress(),
                            shop.getType()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showShop() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = ShopController.getShopList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colShopName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        colOwnersName.setCellValueFactory(new PropertyValueFactory<>("ownersName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        tabShop.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
