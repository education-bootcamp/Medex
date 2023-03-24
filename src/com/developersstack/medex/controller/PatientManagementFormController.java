package com.developersstack.medex.controller;

import com.developersstack.medex.db.Database;
import com.developersstack.medex.dto.PatientDto;
import com.developersstack.medex.enums.GenderType;
import com.developersstack.medex.util.CrudUtil;
import com.developersstack.medex.view.tm.PatientTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) -> {
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
        String searchText="%"+s+"%";
        ObservableList<PatientTm> tmList = FXCollections.observableArrayList();
        try {
            ResultSet set = CrudUtil.execute("SELECT * FROM patient WHERE email LIKE ? OR first_name LIKE ? OR last_name LIKE ?",
                    searchText,searchText,searchText);
            while (set.next()){
                tmList.add(new PatientTm(
                        set.getString(6),
                        set.getString(2),
                        set.getString(3),
                        new SimpleDateFormat("yyyy-MM-dd")
                                .format(set.getDate(8)),
                        set.getString(9)=="MALE"? GenderType.MALE:GenderType.FE_MALE,
                        set.getString(7),
                        0,
                        set.getString(4)
                ));
            }
            tblPatients.setItems(tmList);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DoctorDashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) patientContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.
                load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
