package com.developersstack.medex.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAppointmentForm {
    public AnchorPane newAppointmentContext;
    public JFXComboBox cmbDoctors;
    public JFXDatePicker txtDate;
    public JFXTimePicker txtTime;
    public JFXTextField txtAmount;
    public JFXTextArea txtMessage;

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
