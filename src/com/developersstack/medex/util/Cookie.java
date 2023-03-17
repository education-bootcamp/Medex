package com.developersstack.medex.util;

import com.developersstack.medex.db.Database;
import com.developersstack.medex.dto.UserDto;

public class Cookie {
    public static UserDto selectedUser= Database.userTable.get(1); // default value?
}
