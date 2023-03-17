package com.developersstack.medex.controller;

import com.developersstack.medex.db.Database;
import com.developersstack.medex.dto.PatientDto;
import com.developersstack.medex.view.tm.PatientTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;

public class PatientManagementFormController {
    public TextField txtSearch;
    public AnchorPane patientContext;
    public TableView<PatientTm> tblPatients;
    public TableColumn colNic;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;

    public void initialize(){
        loadAllData("");//? search text

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            loadAllData(newValue);
        });

        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("genderType"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void loadAllData(String s) {
        s = s.toLowerCase(); // immutable
        ObservableList<PatientTm> tmList = FXCollections.observableArrayList();
        //==> filter
        for (PatientDto dto: Database.patientTable
             ) {
            if (
                    dto.getFirstName().contains(s) ||
                    dto.getLastName().contains(s) ||
                    dto.getEmail().contains(s)
            ){
                tmList.add(
                        new PatientTm(
                                dto.getNic(),
                                dto.getFirstName(),
                                dto.getLastName(),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .format(dto.getDob()),
                                dto.getGenderType(),
                                dto.getAddress(),
                                10,
                                dto.getEmail()
                        )
                );
            }
        }
        tblPatients.setItems(tmList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }
}
