package com.developersstack.medex.util;

import com.developersstack.medex.db.DBConnection;

import java.sql.*;

public class IdGenerator {
    public int generateId(){
        try{
            ResultSet rst = CrudUtil.execute(
                    "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1"
            );
            if (rst.next()){
                //return rst.getInt("user_id")+1;
                return rst.getInt(1)+1;
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return 1;
    }
}
