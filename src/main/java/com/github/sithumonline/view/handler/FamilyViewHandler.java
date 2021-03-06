package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.ShopController;
import com.github.sithumonline.entity.Shops;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.FamilyController;
import com.github.sithumonline.entity.Family;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FamilyViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtSurname;
    public TextField txtNumberOfMembers;
    public TextField txtTotalIncome;
    public TextField txtReligion;
    public TextField txtHeadOfTheFamily;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Family> tabFamily;
    public TableColumn<Family, Integer> colId;
    public TableColumn<Family, Integer> colSurname;
    public TableColumn<Family, Integer> colNumberOfMembers;
    public TableColumn<Family, Integer> colTotalIncome;
    public TableColumn<Family, Integer> colReligion;
    public TableColumn<Family, Integer> colHeadOfTheFamily;
    public Button butClear;
    public TextField txtSearchBox;
    private ObservableList<Family> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!validateSurname() | !validateNumMembers() | !validateIncome() | !validateReligion() | !validateFamilyHead()) {
            txtSurname.setOnMouseClicked(event -> {
                txtSurname.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtSurname.setText("");
            });
            txtNumberOfMembers.setOnMouseClicked(event -> {
                txtNumberOfMembers.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtNumberOfMembers.setText("");
            });
            txtTotalIncome.setOnMouseClicked(event -> {
                txtTotalIncome.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtTotalIncome.setText("");
            });
            txtReligion.setOnMouseClicked(event -> {
                txtReligion.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtReligion.setText("");
            });
            txtHeadOfTheFamily.setOnMouseClicked(event -> {
                txtHeadOfTheFamily.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtHeadOfTheFamily.setText("");
            });
            return;
        } else {
            //labInfo.setText("TextField is empty");
            Family family = new Family(txtSurname.getText(), Integer.parseInt(txtNumberOfMembers.getText()), Integer.parseInt(txtTotalIncome.getText()), txtReligion.getText(), txtHeadOfTheFamily.getText());
            FamilyController.addFamily(family);
            labInfo.setText("Family added");
            showFamily();
        }
    }

    private Boolean validateSurname(){
        String val = txtSurname.getText();
        String pattern = "^[a-zA-Z]+$";

        if(val.isEmpty()) {
            txtSurname.setText("Cannot be empty");
            txtSurname.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtSurname.setText("Must have only letters");
            txtSurname.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateNumMembers(){
        String val = txtNumberOfMembers.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtNumberOfMembers.setText("Cannot be empty");
            txtNumberOfMembers.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtNumberOfMembers.setText("Must have only Numbers");
            txtNumberOfMembers.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateIncome(){
        String val = txtTotalIncome.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtTotalIncome.setText("Cannot be empty");
            txtTotalIncome.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtTotalIncome.setText("Must have only Numbers");
            txtTotalIncome.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateReligion(){
        String val = txtReligion.getText();
        String pattern = "^[a-zA-Z]+$";

        if(val.isEmpty()) {
            txtReligion.setText("Cannot be empty");
            txtReligion.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtReligion.setText("Must have only letters");
            txtReligion.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateFamilyHead(){
        String val = txtHeadOfTheFamily.getText();
        String pattern = "^[a-zA-Z.]+$";

        if(val.isEmpty()) {
            txtHeadOfTheFamily.setText("Cannot be empty");
            txtHeadOfTheFamily.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtHeadOfTheFamily.setText("Must have only letters");
            txtHeadOfTheFamily.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() || txtSurname.getText().isEmpty() || txtNumberOfMembers.getText().isEmpty() || txtTotalIncome.getText().isEmpty() || txtReligion.getText().isEmpty() || txtHeadOfTheFamily.getText().isEmpty())) {
            Family family = new Family(Integer.parseInt(txtID.getText()), txtSurname.getText(), Integer.parseInt(txtNumberOfMembers.getText()), Integer.parseInt(txtTotalIncome.getText()), txtReligion.getText(), txtHeadOfTheFamily.getText());
            FamilyController.updateFamily(family);
            labInfo.setText("Family updated");
            showFamily();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            FamilyController.deleteFamily(txtID.getText());
            labInfo.setText("Family deleted");
            showFamily();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtSurname.setText("");
        txtNumberOfMembers.setText("");
        txtTotalIncome.setText("");
        txtReligion.setText("");
        txtHeadOfTheFamily.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showFamily();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = FamilyController.getAllFamiliesById(txtSearchBox.getText());
            showFamily();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Family family : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(family.getId()),
                            family.getSurname(),
                            String.valueOf(family.getNumberOfMembers()),
                            String.valueOf(family.getTotalIncome()),
                            family.getReligion(),
                            family.getHeadOfFamily()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (Family family : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(family.getId()),
                            family.getSurname(),
                            String.valueOf(family.getNumberOfMembers()),
                            String.valueOf(family.getTotalIncome()),
                            family.getReligion(),
                            family.getHeadOfFamily()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showFamily() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = FamilyController.getFamilyList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colNumberOfMembers.setCellValueFactory(new PropertyValueFactory<>("numberOfMembers"));
        colTotalIncome.setCellValueFactory(new PropertyValueFactory<>("totalIncome"));
        colReligion.setCellValueFactory(new PropertyValueFactory<>("religion"));
        colHeadOfTheFamily.setCellValueFactory(new PropertyValueFactory<>("headOfFamily"));

        tabFamily.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
