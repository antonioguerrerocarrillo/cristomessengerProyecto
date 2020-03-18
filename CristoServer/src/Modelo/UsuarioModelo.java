/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cuvil
 */
public class UsuarioModelo extends Conexion{

    public boolean comprobarUsuario(String login, String passwd) throws SQLException {
        boolean encontrado = false;
        Statement stmt = null;
        String id_user = null;
        String password = null;
        
        String query = "select id_user,name,password,surname1,surname2,photo,state from cristomessenger.user";
      
        try {
            this.conectar();
            System.out.println("Que vale con : "+ con );
            stmt =  (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
          
            while (rs.next()) {
                id_user = rs.getString("id_user");
                password = rs.getString("password");
                if(id_user.equals(login)){
                    if (password.equals(passwd)) {
                        encontrado = true;
                    } else {
                    }
                }
            } 
        } catch (SQLException e ) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
        //Cerramos la conexion..
            if (stmt != null) { stmt.close(); }
        }
        this.con.close();
        return encontrado;
    }
    
}
