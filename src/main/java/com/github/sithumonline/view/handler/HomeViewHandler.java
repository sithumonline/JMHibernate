package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.HomeController;
import com.github.sithumonline.entity.Home;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HomeViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtHousingNumber;
    public TextField txtConstructionsStatus;
    public TextField txtAreaOfTheHouse;
    public TextField txtAddress;
    public TextField txtElectricityAndWaterSupply;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Home> tabHome;
    public TableColumn<Home, Integer> colId;
    public TableColumn<Home, Integer> colHousingNumber;
    public TableColumn<Home, Integer> colConstructionsStatus;
    public TableColumn<Home, Integer> colAreaOfTheHouse;
    public TableColumn<Home, Integer> colAddress;
    public TableColumn<Home, Integer> colElectricityAndWaterSupply;
    public Button butClear;
    public TextField txtSearchBox;
    private ObservableList<Home> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!(txtHousingNumber.getText().isEmpty() && txtConstructionsStatus.getText().isEmpty() && txtAreaOfTheHouse.getText().isEmpty() && txtAddress.getText().isEmpty() && txtElectricityAndWaterSupply.getText().isEmpty())) {
            Home home = new Home(Integer.parseInt(txtHousingNumber.getText()), txtConstructionsStatus.getText(), Integer.parseInt(txtAreaOfTheHouse.getText()), txtAddress.getText(), txtElectricityAndWaterSupply.getText());
            HomeController.addHome(home);
            labInfo.setText("Home added");
            showHome();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtHousingNumber.getText().isEmpty() && txtConstructionsStatus.getText().isEmpty() && txtAreaOfTheHouse.getText().isEmpty() && txtAddress.getText().isEmpty() && txtElectricityAndWaterSupply.getText().isEmpty())) {
            Home home = new Home(Integer.parseInt(txtID.getText()), Integer.parseInt(txtHousingNumber.getText()), txtConstructionsStatus.getText(), Integer.parseInt(txtAreaOfTheHouse.getText()), txtAddress.getText(), txtElectricityAndWaterSupply.getText());
            HomeController.updateHome(home);
            labInfo.setText("Home updated");
            showHome();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            HomeController.deleteHome(txtID.getText());
            labInfo.setText("Home deleted");
            showHome();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtHousingNumber.setText("");
        txtConstructionsStatus.setText("");
        txtAreaOfTheHouse.setText("");
        txtAddress.setText("");
        txtElectricityAndWaterSupply.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showHome();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = HomeController.getAllHomesById(txtSearchBox.getText());
            showHome();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Home home : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(home.getId()),
                            String.valueOf(home.getNumber()),
                            home.getConstructionsStatus(),
                            String.valueOf(home.getAreaOfTheHouse()),
                            home.getAddress(),
                            home.getElectricityAndWaterSupply()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (Home home : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(home.getId()),
                            String.valueOf(home.getNumber()),
                            home.getConstructionsStatus(),
                            String.valueOf(home.getAreaOfTheHouse()),
                            home.getAddress(),
                            home.getElectricityAndWaterSupply()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showHome() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = HomeController.getHomeList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colHousingNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colConstructionsStatus.setCellValueFactory(new PropertyValueFactory<>("constructionsStatus"));
        colAreaOfTheHouse.setCellValueFactory(new PropertyValueFactory<>("areaOfTheHouse"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colElectricityAndWaterSupply.setCellValueFactory(new PropertyValueFactory<>("electricityAndWaterSupply"));

        tabHome.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
