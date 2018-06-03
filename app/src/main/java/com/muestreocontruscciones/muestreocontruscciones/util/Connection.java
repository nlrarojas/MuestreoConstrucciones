package com.muestreocontruscciones.muestreocontruscciones.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    private static final String DB_URL = "jdbc:mysql://163.178.173.144/DB_REQUERIMIENTOS";
    private static final String USER = "multi-paraiso";
    private static final String PASS = "multimedios.rp.2017";

    public Connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            if(conn == null){
                throw new Exception("Incomplete Connection");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
