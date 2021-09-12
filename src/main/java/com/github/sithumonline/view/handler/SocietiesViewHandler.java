package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.WriterCsvXlxs;
import com.github.sithumonline.controller.SocietyController;
import com.github.sithumonline.entity.Societies;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SocietiesViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtOrientation;
    public TextField txtOfficeBearer;
    public TextField txtMonthlyMembershipFee;
    public TextField txtAgeGroup;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Societies> tabSocieties;
    public TableColumn<Societies, Integer> colId;
    public TableColumn<Societies, Integer> colSocietyName;
    public TableColumn<Societies, Integer> colOrientation;
    public TableColumn<Societies, Integer> colOfficeBearer;
    public TableColumn<Societies, Integer> colMonthlyMembershipFee;
    public TableColumn<Societies, Integer> colAgeGroup;
    public Label labInfo;
    public Button butClear;
    public TextField txtSearchBox;
    private ObservableList<Societies> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!(txtName.getText().isEmpty() && txtOrientation.getText().isEmpty() && txtOfficeBearer.getText().isEmpty() && txtMonthlyMembershipFee.getText().isEmpty() && txtAgeGroup.getText().isEmpty())) {
            Societies society = new Societies(txtName.getText(), txtOrientation.getText(), txtOfficeBearer.getText(), Integer.parseInt(txtMonthlyMembershipFee.getText()), txtAgeGroup.getText());
            SocietyController.addSociety(society);
            labInfo.setText("Society added");
            showSocieties();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() && txtName.getText().isEmpty() && txtOrientation.getText().isEmpty() && txtOfficeBearer.getText().isEmpty() && txtMonthlyMembershipFee.getText().isEmpty() && txtAgeGroup.getText().isEmpty())) {
            Societies society = new Societies(Integer.parseInt(txtID.getText()), txtName.getText(), txtOrientation.getText(), txtOfficeBearer.getText(), Integer.parseInt(txtMonthlyMembershipFee.getText()), txtAgeGroup.getText());
            SocietyController.updateSociety(society);
            labInfo.setText("Society updated");
            showSocieties();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            SocietyController.deleteSociety(txtID.getText());
            labInfo.setText("Society deleted");
            showSocieties();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtName.setText("");
        txtOrientation.setText("");
        txtOfficeBearer.setText("");
        txtMonthlyMembershipFee.setText("");
        txtAgeGroup.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showSocieties();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = SocietyController.getAllSocietysById(txtSearchBox.getText());
            showSocieties();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Societies society : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(society.getId()),
                            society.getName(),
                            society.getOrientation(),
                            society.getOfficeBearer(),
                            String.valueOf(society.getMonthlyMembershipFee()),
                            society.getAgeGroup()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (Societies society : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(society.getId()),
                            society.getName(),
                            society.getOrientation(),
                            society.getOfficeBearer(),
                            String.valueOf(society.getMonthlyMembershipFee()),
                            society.getAgeGroup()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showSocieties() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = SocietyController.getSocietyList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSocietyName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrientation.setCellValueFactory(new PropertyValueFactory<>("orientation"));
        colOfficeBearer.setCellValueFactory(new PropertyValueFactory<>("officeBearer"));
        colMonthlyMembershipFee.setCellValueFactory(new PropertyValueFactory<>("monthlyMembershipFee"));
        colAgeGroup.setCellValueFactory(new PropertyValueFactory<>("ageGroup"));

        tabSocieties.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
