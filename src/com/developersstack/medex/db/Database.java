package com.developersstack.medex.db;

import com.developersstack.medex.dto.DoctorDto;
import com.developersstack.medex.dto.PatientDto;
import com.developersstack.medex.dto.UserDto;
import com.developersstack.medex.enums.AccountType;
import com.developersstack.medex.enums.GenderType;

import java.util.ArrayList;
import java.util.Date;

public class Database {
    //------------
    public static ArrayList<UserDto> userTable =
            new ArrayList();
    public static ArrayList<DoctorDto> doctorTable =
            new ArrayList<>();
    public static ArrayList<PatientDto> patientTable =
            new ArrayList<>();
    //------------


    static {
        //----------------
        userTable.add(new UserDto("Hasika","Sandaruwan",
                "hasika@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new UserDto("shashika","nirmal",
                "shashika@gmail.com","1234", AccountType.DOCTOR));
        //----------------
       /* doctorTable.add(
                new DoctorDto(
                        "Shashika",
                        "Nirmal",
                        "9235",
                        "+1254",
                        "shashika@gmail.com",
                        "Sample 1",
                        "Colombo",
                        GenderType.MALE
                )
        );*/
        patientTable.add(
                new PatientDto("95","Hasika","Sandaruwan",
                        new Date(),GenderType.MALE,"Galle","hasika@gmail.com"));
        patientTable.add(
                new PatientDto("124","Samantha","Bandara",
                        new Date(),GenderType.MALE,"Aluthgama","samantha@gmail.com"));
        patientTable.add(
                new PatientDto("452","Namal","Chandana",
                        new Date(),GenderType.MALE,"Kalutara","namal@gmail.com"));
        patientTable.add(
                new PatientDto("457","Wasantha","nihal",
                        new Date(),GenderType.MALE,"Wadduwa","wasantha@gmail.com"));
        patientTable.add(
                new PatientDto("8745","Banda","samanmal",
                        new Date(),GenderType.MALE,"Panadura","banda@gmail.com"));
        //----------------

    }


}
