/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public void getUsuariosTotales(ArrayList<User> userSistema) throws SQLException {
       Statement stmt = null;
        String id_user = null;
        String name = null;
        String password = null;
        String surname1 = null;
        String surname2 = null;
        String photo = null;
        String state = null;

        String query = "select id_user,name,password,surname1,surname2,photo,state from cristomessenger.user";
  
        try {
            this.conectar();
            stmt =  (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
          
            while (rs.next()) {
                User u = new User();
                id_user = rs.getString("id_user");
                u.setId_user(id_user);
                
                name = rs.getString("name");
                u.setName(name);
                
                password = rs.getString("password");
                u.setPassword(password);
                
                surname1 = rs.getString("surname1");
                u.setSurname1(surname1);
                
                surname2 = rs.getString("surname2");
                u.setSurname2(surname2);
                
                photo = rs.getString("photo");
                u.setPhoto(photo);
                
                state = rs.getString("state");
                u.setState(state); 
                userSistema.add(u);
                
            }
        } catch (SQLException e ) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        this.con.close();
    }
    
}
