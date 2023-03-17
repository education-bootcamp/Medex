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
import javafx.scene.layout.AnchorPane;

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
                                dto.getDob(),
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
