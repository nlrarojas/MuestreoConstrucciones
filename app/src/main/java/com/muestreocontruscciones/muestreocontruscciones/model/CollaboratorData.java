package com.muestreocontruscciones.muestreocontruscciones.model;

import com.muestreocontruscciones.muestreocontruscciones.core.Collaborator;
import com.muestreocontruscciones.muestreocontruscciones.util.Connection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CollaboratorData {
    private ArrayList<Collaborator>  collaborators;
    private java.sql.Connection conn;

    public CollaboratorData() {
        conn = new Connection().connect();
    }

    public ArrayList<Collaborator> getCollaborators() {

        String query = "{CALL sp_obtener_colaboradores()}";
        try {
            CallableStatement stmt = conn.prepareCall(query);
            //CUANDO RECIBE PARAMETROS
            //stmt.setInt(1, candidateId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s - %s",
                        rs.getString("first_name") + " "
                                + rs.getString("last_name"),
                        rs.getString("skill")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborators;
    }
}
