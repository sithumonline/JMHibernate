package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.WriterCsvXlxs;
import com.github.sithumonline.controller.CropCultivationController;
import com.github.sithumonline.entity.CropCultivation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CropViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtCropType;
    public TextField txtNumberOfAcres;
    public TextField txtNumberOfCultivators;
    public TextField txtEstimatedFertilizer;
    public TextField txtReceivedFertilize;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<CropCultivation> tabCropCultivation;
    public TableColumn<CropCultivation, Integer> colId;
    public TableColumn<CropCultivation, Integer> colCropType;
    public TableColumn<CropCultivation, Integer> colNumberOfAcres;
    public TableColumn<CropCultivation, Integer> colNumberOfCultivators;
    public TableColumn<CropCultivation, Integer> colEstimatedFertilizer;
    public TableColumn<CropCultivation, Integer> colReceivedFertilize;
    public Button butClear;
    public TextField txtSearchBox;
    private ObservableList<CropCultivation> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!(txtCropType.getText().isEmpty() && txtNumberOfAcres.getText().isEmpty() && txtNumberOfCultivators.getText().isEmpty() && txtEstimatedFertilizer.getText().isEmpty() && txtReceivedFertilize.getText().isEmpty())) {
            CropCultivation cropCultivation = new CropCultivation(txtCropType.getText(), Integer.parseInt(txtNumberOfAcres.getText()), Integer.parseInt(txtNumberOfCultivators.getText()), Integer.parseInt(txtEstimatedFertilizer.getText()), Integer.parseInt(txtReceivedFertilize.getText()));
            CropCultivationController.addCropCultivation(cropCultivation);
            labInfo.setText("CropCultivation added");
            showCropCultivation();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() && txtCropType.getText().isEmpty() && txtNumberOfAcres.getText().isEmpty() && txtNumberOfCultivators.getText().isEmpty() && txtEstimatedFertilizer.getText().isEmpty() && txtReceivedFertilize.getText().isEmpty())) {
            CropCultivation cropCultivation = new CropCultivation(Integer.parseInt(txtID.getText()), txtCropType.getText(), Integer.parseInt(txtNumberOfAcres.getText()), Integer.parseInt(txtNumberOfCultivators.getText()), Integer.parseInt(txtEstimatedFertilizer.getText()), Integer.parseInt(txtReceivedFertilize.getText()));
            CropCultivationController.updateCropCultivation(cropCultivation);
            labInfo.setText("CropCultivation updated");
            showCropCultivation();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            CropCultivationController.deleteCropCultivation(txtID.getText());
            labInfo.setText("CropCultivation deleted");
            showCropCultivation();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtCropType.setText("");
        txtNumberOfAcres.setText("");
        txtNumberOfCultivators.setText("");
        txtEstimatedFertilizer.setText("");
        txtReceivedFertilize.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showCropCultivation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = CropCultivationController.getAllCropCultivationsById(txtSearchBox.getText());
            showCropCultivation();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) {
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (CropCultivation cropCultivation : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(cropCultivation.getId()),
                            cropCultivation.getCropType(),
                            String.valueOf(cropCultivation.getNumberOfAcres()),
                            String.valueOf(cropCultivation.getNumberOfCultivators()),
                            String.valueOf(cropCultivation.getEstimatedFertilizer()),
                            String.valueOf(cropCultivation.getReceivedFertilize())

                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showCropCultivation() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = CropCultivationController.getCropCultivationList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCropType.setCellValueFactory(new PropertyValueFactory<>("cropType"));
        colNumberOfAcres.setCellValueFactory(new PropertyValueFactory<>("numberOfAcres"));
        colNumberOfCultivators.setCellValueFactory(new PropertyValueFactory<>("numberOfCultivators"));
        colEstimatedFertilizer.setCellValueFactory(new PropertyValueFactory<>("estimatedFertilizer"));
        colReceivedFertilize.setCellValueFactory(new PropertyValueFactory<>("receivedFertilize"));

        tabCropCultivation.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
