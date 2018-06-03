package com.muestreocontruscciones.muestreocontruscciones.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    private static final String DB_URL = "jdbc:mysql://163.178.173.144/DB_REQUERIMIENTOS";
    private static final String USER = "multi-paraiso";
    private static final String PASS = "multimedios.rp.2017";
    private java.sql.Connection conn;

    public Connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            if(conn == null){
                throw new Exception("Incomplete Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public java.sql.Connection connect() {
        return conn;
    }

    public String Iniciar_Sesion(String user, String password) {

        //Si existe conexion
        if (conn != null) {
            PreparedStatement stmt;
            ResultSet rs;
            String query;
            try {
                query = "SELECT * FROM Usuario WHERE Usuario = ? and Contrasena = ?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, user);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                if (rs != null) {
                    rs.beforeFirst();
                    rs.last();
                    if (rs.getRow() == 1) {
                        return "Logged";
                    }
                    return "ERROR";
                }
                return "ERROR";

            } catch (Exception e) {
                return "ERROR";
            }
        }
        return "Sin conexion";
    }
}
