package com.developersstack.medex.db;

import com.developersstack.medex.dto.DoctorDto;
import com.developersstack.medex.dto.PatientDto;
import com.developersstack.medex.dto.User;
import com.developersstack.medex.enums.AccountType;
import com.developersstack.medex.enums.GenderType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database {
    //------------
    public static ArrayList<User> userTable =
            new ArrayList();
    public static ArrayList<DoctorDto> doctorTable =
            new ArrayList<>();
    public static ArrayList<PatientDto> patientTable =
            new ArrayList<>();
    //------------


    static {
        //----------------
        userTable.add(new User("Hasika","Sandaruwan",
                "hasika@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new User("shashika","nirmal",
                "shashika@gmail.com","1234", AccountType.DOCTOR));
        //----------------
        doctorTable.add(
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
        );
        try{
            patientTable.add(
                    new PatientDto("95","Hasika","Sandaruwan",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                            ,GenderType.MALE,"Galle","hasika@gmail.com"));
            patientTable.add(
                    new PatientDto("124","Samantha","Bandara",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                            ,GenderType.MALE,"Aluthgama","samantha@gmail.com"));
            patientTable.add(
                    new PatientDto("452","Namal","Chandana",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                            ,GenderType.MALE,"Kalutara","namal@gmail.com"));
            patientTable.add(
                    new PatientDto("457","Wasantha","nihal",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                            ,GenderType.MALE,"Wadduwa","wasantha@gmail.com"));
            patientTable.add(
                    new PatientDto("8745","Banda","samanmal",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                            ,GenderType.MALE,"Panadura","banda@gmail.com"));
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println(e);
            //System.out.println(e.getMessage());
        }

        //----------------

    }


}
