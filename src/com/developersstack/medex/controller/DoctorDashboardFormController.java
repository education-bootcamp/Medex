package com.developersstack.medex.controller;

import com.developersstack.medex.util.Cookie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorDashboardFormController {

    public AnchorPane doctorDashboardContext;

    public void initialize() throws IOException {
        checkUser();
    }

    public void checkUser() throws IOException {
        if (null == Cookie.selectedUser){
            Stage stage =(Stage) doctorDashboardContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.
                    load(getClass().getResource("../view/LoginForm.fxml"))));
            stage.centerOnScreen();
        }
    }
}
