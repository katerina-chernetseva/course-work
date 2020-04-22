package com.example.client;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    String IP, DB, DBUserName, DBPassword;
    @SuppressLint("NewApi")
    public Connection connection() throws ClassNotFoundException {
        //IP="192.168.100.5\\KATE";
        IP="10.0.2.2";
        DB="Кафе";
        DBUserName="Katerina";
        DBPassword="kate_3108";

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection=null;
        String ConnectionURL=null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + IP + ";databaseName=" + DB + ";user=" + DBUserName + ";password=" + DBPassword + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
