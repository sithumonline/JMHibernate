package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.utility.WriterCsvXlxs;
import com.github.sithumonline.controller.PersonController;
import com.github.sithumonline.entity.Person;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PersonViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtGender;
    public TextField txtAddress;
    public TextField txtEmploymentStats;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Person> tabPerson;
    public TableColumn<Person, Integer> colId;
    public TableColumn<Person, Integer> colName;
    public TableColumn<Person, Integer> colNIC;
    public TableColumn<Person, Integer> colGender;
    public TableColumn<Person, Integer> colAddress;
    public TableColumn<Person, Integer> colEmploymentStats;
    public Button butClear;
    public TextField txtSearchBox;
    private ObservableList<Person> out;
    private WriterCsvXlxs writerCsvXlxs = new WriterCsvXlxs();

    public void pressInsert() throws Exception {
        if (!(txtName.getText().isEmpty() && txtNIC.getText().isEmpty() && txtGender.getText().isEmpty() && txtAddress.getText().isEmpty() && txtEmploymentStats.getText().isEmpty())) {
            Person person = new Person(txtName.getText(), txtNIC.getText(), txtGender.getText(), txtAddress.getText(), txtEmploymentStats.getText());
            PersonController.addPerson(person);
            labInfo.setText("Person added");
            showPerson();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if (!(txtID.getText().isEmpty() && txtName.getText().isEmpty() && txtNIC.getText().isEmpty() && txtGender.getText().isEmpty() && txtAddress.getText().isEmpty() && txtEmploymentStats.getText().isEmpty())) {
            Person person = new Person(Integer.parseInt(txtID.getText()), txtName.getText(), txtNIC.getText(), txtGender.getText(), txtAddress.getText(), txtEmploymentStats.getText());
            PersonController.updatePerson(person);
            labInfo.setText("Person updated");
            showPerson();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if (!txtID.getText().isEmpty()) {
            PersonController.deletePerson(txtID.getText());
            labInfo.setText("Person deleted");
            showPerson();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtName.setText("");
        txtNIC.setText("");
        txtGender.setText("");
        txtAddress.setText("");
        txtEmploymentStats.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSearch(ActionEvent actionEvent) throws Exception {
        if (!(txtSearchBox.getText().isEmpty())) {
            out = PersonController.getAllPersonsById(txtSearchBox.getText());
            showPerson();
        } else {
            labInfo.setText("Query Name not selected");
        }
    }

    public void pressXLXS(ActionEvent actionEvent) throws IOException {
        int i = 1;
        Map<String, Object[]> data = new HashMap<>();
        for (Person person : out
        ) {
            data.put(String.valueOf(i),
                    new Object[]{
                            String.valueOf(i),
                            String.valueOf(person.getId()),
                            person.getName(),
                            person.getNic(),
                            person.getGender(),
                            person.getAddress(),
                            person.getEmploymentStats()
                    });
            i++;
        }
        writerCsvXlxs.writeXlxs(data);
    }

    public void pressCSV(ActionEvent actionEvent) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        for (Person person : out
        ) {
            csvData.add(
                    new String[]{
                            String.valueOf(person.getId()),
                            person.getName(),
                            person.getNic(),
                            person.getGender(),
                            person.getAddress(),
                            person.getEmploymentStats()
                    });
        }
        writerCsvXlxs.writeCsv(csvData);
    }

    public void showPerson() throws Exception {
        if (out == null || txtSearchBox.getText().isEmpty()) {
            out = PersonController.getPersonList();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmploymentStats.setCellValueFactory(new PropertyValueFactory<>("employmentStats"));

        tabPerson.setItems(out);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
