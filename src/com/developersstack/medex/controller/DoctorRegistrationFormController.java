package com.developersstack.medex.controller;

import com.developersstack.medex.db.Database;
import com.developersstack.medex.dto.DoctorDto;
import com.developersstack.medex.dto.UserDto;
import com.developersstack.medex.enums.GenderType;
import com.developersstack.medex.util.Cookie;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

public class DoctorRegistrationFormController {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtNic;
    public TextField txtContact;
    public TextField txtEmail;
    public TextField txtSpecializations;
    public TextArea txtAddress;
    public JFXRadioButton rBtnMale;
    public AnchorPane doctorRegistrationContext;
    public JFXButton btnSubmit;

    public void initialize() {
        loadUserData();


        //-----------------------------
        txtNic.textProperty().addListener((observable, oldValue, newValue) -> {
            if (true){
                new Alert(Alert.AlertType.WARNING, "NIC Conflict!").show();
                btnSubmit.setDisable(true);
                txtNic.setStyle("-fx-border-color: red");
                return;
            }
            //if (btnSubmit.isDisable())btnSubmit.setDisable(false);
            btnSubmit.setDisable(false);
        });
        //-----------------------------

    }

    private void loadUserData() {
        UserDto selectedUser = Cookie.selectedUser;
        txtFirstName.setText(selectedUser.getFirstName());
        txtLastName.setText(selectedUser.getLastName());
        txtEmail.setText(selectedUser.getEmail());
    }

    public void submitDataOnAction(ActionEvent actionEvent) {

        if (Database.doctorTable.stream().filter(e->e.getNic().equals(txtNic.getText().trim())).findFirst().isPresent()){
            new Alert(Alert.AlertType.WARNING, "NIC Conflict!").show();
            btnSubmit.setDisable(true);
            return;
        }

        DoctorDto doctorDto = new DoctorDto(
                txtFirstName.getText().trim(),
                txtLastName.getText().trim(),
                txtNic.getText(),
                txtContact.getText(),
                txtEmail.getText(),
                txtSpecializations.getText(),
                txtAddress.getText(),
                rBtnMale.isSelected() ? GenderType.MALE : GenderType.FE_MALE
        );
        Database.doctorTable.add(doctorDto);
        Stage stage = (Stage) doctorRegistrationContext.getScene().getWindow();
        stage.close();
    }
}
