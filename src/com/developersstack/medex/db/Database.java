package com.developersstack.medex.db;

import com.developersstack.medex.dto.DoctorDto;
import com.developersstack.medex.dto.UserDto;
import com.developersstack.medex.enums.AccountType;
import com.developersstack.medex.enums.GenderType;

import java.util.ArrayList;

public class Database {
    //------------
    public static ArrayList<UserDto> userTable =
            new ArrayList();
    public static ArrayList<DoctorDto> doctorTable =
            new ArrayList<>();
    //------------


    static {
        //----------------
        userTable.add(new UserDto("Hasika","Sandaruwan",
                "hasika@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new UserDto("shashika","nirmal",
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
        //----------------

    }


}
