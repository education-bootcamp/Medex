package com.developersstack.medex.controller;

import com.developersstack.medex.util.Cookie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorDashboardFormController {

    public AnchorPane doctorDashboardContext;
    public Label lblDate;
    public Label lblTime;

    public void initialize() throws IOException {
        //checkUser();
        initializeData();
    }

    private void initializeData() {
        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);
        lblDate.setText(today);*/
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
