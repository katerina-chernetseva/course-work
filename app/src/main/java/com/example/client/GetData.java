package com.example.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    Connection connection;
    String ConnectionResult;
    Boolean isSuccess=false;

    public List<Map<String,String>> getdata(){
        List<Map<String,String>> data=null;
        data=new ArrayList<Map<String,String>>();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection=connectionHelper.connection();
            if (connection==null){
                ConnectionResult="Check your internet access!";
            }
            else{
                String query = "select * from";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()){
                    Map<String,String> datanum = new HashMap<String, String>();
                    datanum.put("ID", rs.getString(""));
                    data.add(datanum);
                }
                ConnectionResult="Successful";
                isSuccess=true;
                connection.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            isSuccess=false;
            ConnectionResult=e.getMessage();
        }
        return data;
    }
}
