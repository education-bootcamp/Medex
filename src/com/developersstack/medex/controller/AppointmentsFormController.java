package com.developersstack.medex.controller;

import com.developersstack.medex.util.Cookie;
import com.developersstack.medex.util.CrudUtil;
import com.developersstack.medex.view.tm.AllAppointmentTm;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentsFormController {
    public AnchorPane appointmentContext;
    public JFXDatePicker txtDateFrom;
    public JFXDatePicker txtDateTo;
    public JFXRadioButton rBtnPending;
    public JFXRadioButton rBtnCompleted;
    public TableView<AllAppointmentTm> tblAppointment;
    public TableColumn colId;
    public TableColumn colPatient;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAmount;
    public TableColumn colState;
    public TableColumn colManage;
    String selectedDoctorId = "";

    public void initialize() {
        loadDoctorData(); // js ******/*, promises,observables, callback,await, async, arrow Functions */
        loadAppointments(); // ****

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colManage.setCellValueFactory(new PropertyValueFactory<>("btn"));
        colState.setCellValueFactory(new PropertyValueFactory<>("checkState"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

    }

    private void loadAppointments() {
        ObservableList<AllAppointmentTm> tmList = FXCollections.observableArrayList();
        // check from date & to date Select ?
        // all, completed, pending
        String sql = "SELECT a.*, p.first_name,p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? && p.patient_id=a.patient_id";
        if (rBtnPending.isSelected()) {
            sql = "SELECT a.*, p.first_name,p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND a.check_state=0 && p.patient_id=a.patient_id";
        } else if (rBtnCompleted.isSelected()) {
            sql = "SELECT a.*, p.first_name,p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND a.check_state=1 && p.patient_id=a.patient_id";
        }
        try {
            ResultSet set = CrudUtil.execute(sql, selectedDoctorId);
            while (set.next()){
                Button btn = new Button("manage");
                AllAppointmentTm tm = new AllAppointmentTm(
                        set.getString(1),
                        set.getString("first_name")+" "+set.getString("last_name"),
                        set.getString(2),
                        set.getString(3),
                        set.getDouble(4),
                        set.getInt(5)==0?"Pending":"Completed",
                        btn
                );
                tmList.add(tm);
            }
           tblAppointment.setItems(tmList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private void loadDoctorData() {
        try {
            ResultSet set = CrudUtil.execute("SELECT doctor_id FROM doctor WHERE email=?",
                    Cookie.selectedUser.getEmail());
            if (set.next()) {
                selectedDoctorId = set.getString(1);
            } else {
                // => redirect patient registration
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }

    public void searchData(ActionEvent actionEvent) throws IOException {
        setUi("DoctorDashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) appointmentContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.
                load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
