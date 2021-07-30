package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.FamilyController;
import com.github.sithumonline.entity.Family;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    public void pressInsert() throws Exception {
        if (!(txtSurname.getText().isEmpty() && txtNumberOfMembers.getText().isEmpty() && txtTotalIncome.getText().isEmpty() && txtReligion.getText().isEmpty() && txtHeadOfTheFamily.getText().isEmpty())) {
            Family family = new Family(txtSurname.getText(), Integer.parseInt(txtNumberOfMembers.getText()), Integer.parseInt(txtTotalIncome.getText()), txtReligion.getText(), txtHeadOfTheFamily.getText());
            FamilyController.addFamily(family);
            labInfo.setText("Family added");
            showFamily();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() && txtSurname.getText().isEmpty() && txtNumberOfMembers.getText().isEmpty() && txtTotalIncome.getText().isEmpty() && txtReligion.getText().isEmpty() && txtHeadOfTheFamily.getText().isEmpty())) {
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

    public void pressSearch(ActionEvent actionEvent) {
    }

    public void pressXLXS(ActionEvent actionEvent) {
    }

    public void pressCSV(ActionEvent actionEvent) {
    }

    public void showFamily() throws Exception {
        ObservableList<Family> list = FamilyController.getFamilyList();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colNumberOfMembers.setCellValueFactory(new PropertyValueFactory<>("numberOfMembers"));
        colTotalIncome.setCellValueFactory(new PropertyValueFactory<>("totalIncome"));
        colReligion.setCellValueFactory(new PropertyValueFactory<>("religion"));
        colHeadOfTheFamily.setCellValueFactory(new PropertyValueFactory<>("headOfFamily"));

        tabFamily.setItems(list);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
