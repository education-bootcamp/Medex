package com.developersstack.medex.view.tm;

import javafx.scene.control.Button;

public class AllAppointmentTm {
    private String id;
    private String patient;
    private String date;
    private String time;
    private double amount;
    private String checkState;
    private Button btn;

    public AllAppointmentTm() {
    }

    public AllAppointmentTm(String id, String patient, String date, String time, double amount, String checkState, Button btn) {
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.checkState = checkState;
        this.btn = btn;
        //=========
        btn.setStyle("-fx-background-color: red");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
