package com.developersstack.medex.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PatientManagementFormController {
    public TextField txtSearch;
    public AnchorPane patientContext;
    public TableView tblPatients;
    public TableColumn colNic;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }
}
