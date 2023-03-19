package com.developersstack.medex.util;

import com.developersstack.medex.db.DBConnection;

import java.sql.*;

public class IdGenerator {
    public int generateId(){
        try{
            String sql = "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1";
            PreparedStatement pstm =  DBConnection.getInstance().getConnection().prepareStatement(sql);
            // CRUD ==> Get (Read) => executeQuery()==> Data set
            // CUD ==> save,delete,update => executeUpdate
            ResultSet rst = pstm.executeQuery();
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
