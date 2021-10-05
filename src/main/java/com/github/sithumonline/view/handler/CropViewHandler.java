package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.CropCultivationController;
import com.github.sithumonline.entity.CropCultivation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
        if (!validateCropType() | !validateAcres() | !validateCultivators() | !validateEstFertilizer() | !validateRecFertilizer()) {
            txtCropType.setOnMouseClicked(event -> {
                txtCropType.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtCropType.setText("");
            });
            txtNumberOfAcres.setOnMouseClicked(event -> {
                txtNumberOfAcres.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtNumberOfAcres.setText("");
            });
            txtNumberOfCultivators.setOnMouseClicked(event -> {
                txtNumberOfCultivators.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtNumberOfCultivators.setText("");
            });
            txtEstimatedFertilizer.setOnMouseClicked(event -> {
                txtEstimatedFertilizer.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtEstimatedFertilizer.setText("");
            });
            txtReceivedFertilize.setOnMouseClicked(event -> {
                txtReceivedFertilize.setStyle("-fx-text-fill: #1473e6; -fx-font-size: 16px;");
                txtReceivedFertilize.setText("");
            });
            return;
        } else {
            //labInfo.setText("TextField is empty");
            CropCultivation cropCultivation = new CropCultivation(txtCropType.getText(), Integer.parseInt(txtNumberOfAcres.getText()), Integer.parseInt(txtNumberOfCultivators.getText()), Integer.parseInt(txtEstimatedFertilizer.getText()), Integer.parseInt(txtReceivedFertilize.getText()));
            CropCultivationController.addCropCultivation(cropCultivation);
            labInfo.setText("CropCultivation added");
            showCropCultivation();
        }
    }

    private Boolean validateCropType(){
        String val = txtCropType.getText();
        String pattern = "^[a-zA-Z]+$";

        if(val.isEmpty()) {
            txtCropType.setText("Cannot be empty");
            txtCropType.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtCropType.setText("Must have only letters");
            txtCropType.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateAcres(){
        String val = txtNumberOfAcres.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtNumberOfAcres.setText("Cannot be empty");
            txtNumberOfAcres.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtNumberOfAcres.setText("Must have only Numbers");
            txtNumberOfAcres.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateCultivators(){
        String val = txtNumberOfCultivators.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtNumberOfCultivators.setText("Cannot be empty");
            txtNumberOfCultivators.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtNumberOfCultivators.setText("Must have only Numbers");
            txtNumberOfCultivators.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateEstFertilizer(){
        String val = txtEstimatedFertilizer.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtEstimatedFertilizer.setText("Cannot be empty");
            txtEstimatedFertilizer.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtEstimatedFertilizer.setText("Must have only Numbers");
            txtEstimatedFertilizer.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateRecFertilizer(){
        String val = txtReceivedFertilize.getText();
        String pattern = "^[0-9]+$";

        if(val.isEmpty()) {
            txtReceivedFertilize.setText("Cannot be empty");
            txtReceivedFertilize.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else if (!val.matches(pattern)){
            txtReceivedFertilize.setText("Must have only Numbers");
            txtReceivedFertilize.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
            return false;
        }
        else {
            return true;
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() || txtCropType.getText().isEmpty() || txtNumberOfAcres.getText().isEmpty() || txtNumberOfCultivators.getText().isEmpty() || txtEstimatedFertilizer.getText().isEmpty() || txtReceivedFertilize.getText().isEmpty())) {
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

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (CropCultivation cropCultivation : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(cropCultivation.getId()),
                            cropCultivation.getCropType(),
                            String.valueOf(cropCultivation.getNumberOfAcres()),
                            String.valueOf(cropCultivation.getNumberOfCultivators()),
                            String.valueOf(cropCultivation.getEstimatedFertilizer()),
                            String.valueOf(cropCultivation.getReceivedFertilize())
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
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
