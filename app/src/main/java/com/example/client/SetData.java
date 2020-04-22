package com.example.client;

import com.example.client.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetData {
    private String ConnectionResult;
    private Boolean isSuccess=false;

    public void setRegisterData(Client client){

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            Connection connection = connectionHelper.connection();
            if (connection ==null){
                ConnectionResult="Check your internet access!";
            }
            else{
                String query = "insert into " + Const.CLIENT_TABLE + "("  + Const.CLIENT_FIO + "," + Const.CLIENT_PHONE + "," +
                        Const.CLIENT_ADRESS + "," + Const.CLIENT_BIRTHDATE + "," + Const.CLIENT_EMAIL + "," + Const.CLIENT_PASSWORD +
                        ")" + "VALUES('"  + client.getFIO() + "','" + client.getPhone() + "','" + client.getAdress() + "','" +
                        client.getBirthdate() + "','" + client.getEmail() + "','" + client.getPassword() + "')";
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
                ConnectionResult="Successful";
                isSuccess=true;
                connection.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            isSuccess=false;
            ConnectionResult=e.getMessage();
        }
    }
}
