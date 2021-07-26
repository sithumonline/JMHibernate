package com.github.sithumonline.view.handler;

import com.github.sithumonline.App;
import com.github.sithumonline.controller.EventController;
import com.github.sithumonline.controller.UserController;
import com.github.sithumonline.entity.Event;
import com.github.sithumonline.entity.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventsViewHandler implements Initializable {
    public TextField txtID;
    public TextField txtName;
    public TextField txtVenue;
    public TextField txtDate;
    public TextField txtOrganizer;
    public TextField txtNumberOfSponsorships;
    public Label labInfo;
    public Button butInsert;
    public Button butUpdate;
    public Button butDelete;
    public Button butSearch;
    public Button butXLXS;
    public Button butCSV;
    public TableView<Event> tabEvent;
    public TableColumn<Event, Integer> colId;
    public TableColumn<Event, Integer> colEventName;
    public TableColumn<Event, Integer> colVenue;
    public TableColumn<Event, Integer> colDate;
    public TableColumn<Event, Integer> colOrganizer;
    public TableColumn<Event, Integer> colNumberOfSponsorships;
    public Button butClear;

    public void pressInsert() throws Exception {
        if(!(txtName.getText().isEmpty() && txtVenue.getText().isEmpty() && txtDate.getText().isEmpty() && txtOrganizer.getText().isEmpty() && txtNumberOfSponsorships.getText().isEmpty())){
            Event event = new Event(txtName.getText(),txtVenue.getText(),txtDate.getText(),txtOrganizer.getText(), Integer.parseInt(txtNumberOfSponsorships.getText()));
            EventController.addEvent(event);
            labInfo.setText("Event added");
            showEvent();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressUpdate() throws Exception {
        if(!(txtID.getText().isEmpty() && txtName.getText().isEmpty() && txtVenue.getText().isEmpty() && txtDate.getText().isEmpty() && txtOrganizer.getText().isEmpty() && txtNumberOfSponsorships.getText().isEmpty())){
            Event event = new Event(txtID.getText(), txtName.getText(),txtVenue.getText(),txtDate.getText(),txtOrganizer.getText(), Integer.parseInt(txtNumberOfSponsorships.getText()));
            EventController.updateEvent(event);
            labInfo.setText("Event updated");
            showEvent();
        } else {
            labInfo.setText("TextField is empty");
        }
    }

    public void pressDelete() throws Exception {
        if(!txtID.getText().isEmpty()){
            EventController.deleteEvent(txtID.getText());
            labInfo.setText("Event deleted");
            showEvent();
        } else {
            labInfo.setText("ID is empty");
        }
    }

    public void pressClear() {
        txtID.setText("");
        txtName.setText("");
        txtVenue.setText("");
        txtDate.setText("");
        txtOrganizer.setText("");
        txtNumberOfSponsorships.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showEvent();
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

    public void showEvent() throws Exception {
        ObservableList<Event> list = EventController.getEventList();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colVenue.setCellValueFactory(new PropertyValueFactory<>("venue"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colOrganizer.setCellValueFactory(new PropertyValueFactory<>("organizer"));
        colNumberOfSponsorships.setCellValueFactory(new PropertyValueFactory<>("numberOfSponsorships"));

        tabEvent.setItems(list);
    }

    public void goMainPlane() throws IOException {
        App.setRoot("main-plane");
    }

}
