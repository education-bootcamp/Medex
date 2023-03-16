package com.developersstack.medex.controller;

import com.developersstack.medex.util.Cookie;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        e -> {
                            DateTimeFormatter dtf = DateTimeFormatter
                                    .ofPattern("hh:mm:ss");
                            lblTime.setText(LocalTime.now().format(dtf));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void checkUser() throws IOException {
        if (null == Cookie.selectedUser) {
            Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.
                    load(getClass().getResource("../view/LoginForm.fxml"))));
            stage.centerOnScreen();
        }
    }
}
