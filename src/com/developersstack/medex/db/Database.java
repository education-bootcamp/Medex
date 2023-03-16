package com.developersstack.medex.db;

import com.developersstack.medex.dto.UserDto;
import com.developersstack.medex.enums.AccountType;

import java.util.ArrayList;

public class Database {
    //------------
    public static ArrayList<UserDto> userTable =
            new ArrayList();
    //------------


    static {
        //----------------
        userTable.add(new UserDto("Hasika","Sandaruwan",
                "hasika@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new UserDto("shashika","nirmal",
                "shashika@gmail.com","1234", AccountType.DOCTOR));
        //----------------
    }


}
