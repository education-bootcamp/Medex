package com.developersstack.medex.util;

import com.developersstack.medex.db.Database;
import com.developersstack.medex.dto.User;

public class Cookie {
    public static User selectedUser= Database.userTable.get(1); // default value?
}
