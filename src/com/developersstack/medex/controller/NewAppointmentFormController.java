package com.developersstack.medex.controller;

import com.developersstack.medex.util.CrudUtil;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewAppointmentFormController {
    public AnchorPane newAppointmentContext;
    public JFXComboBox<String> cmbDoctors;
    public JFXDatePicker txtDate;
    public JFXTimePicker txtTime;
    public JFXTextField txtAmount;
    public JFXTextArea txtMessage;

    public void initialize() {
        setDoctorIds();
    }

    private void setDoctorIds() {
        try {
            ResultSet set = CrudUtil.execute("SELECT doctor_Id,first_name,last_name FROM doctor");
            ObservableList<String> obList = FXCollections.observableArrayList();
            while (set.next()) {
                obList.add(set.getString(1));
            }
            cmbDoctors.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {

        }

    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PatientDashboardForm");
    }

    public void seeAvailabilityOnAction(ActionEvent actionEvent) {

    }

    public void submitDataOnAction(ActionEvent actionEvent) {
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) newAppointmentContext.getScene().getWindow();
        System.out.println(stage);
        stage.setScene(new Scene(FXMLLoader.
                load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
