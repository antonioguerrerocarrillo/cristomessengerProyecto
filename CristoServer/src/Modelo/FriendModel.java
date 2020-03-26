/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Friend;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class FriendModel extends Conexion{

    
    
    public void getAmigos(ArrayList<Friend> amigoSistema, String login) throws SQLException {
       String query = ( "select id_user_orig, id_user_dest, accept_request from cristomessenger.friend where id_user_orig = '" + login+ "' or id_user_dest = '" + login + "'"); 
       this.conectar();
       this.ConsultaAmigos(amigoSistema,query); 
            this.con.close();
    }

    private void ConsultaAmigos(ArrayList<Friend> amigoSistema, String query) throws SQLException {
        Statement stmt = null; 
        String id_user_orig = null;
        String id_user_dest= null;
        String accept_request = null;

            try {
                this.conectar();
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Friend f = new Friend();
                    id_user_orig = rs.getString("id_user_orig");
                    f.setId_user_orig(id_user_orig);

                    id_user_dest = rs.getString("id_user_dest");
                    f.setId_user_dest(id_user_dest); 


                    accept_request = rs.getString("accept_request");
                    f.setAccept_request(accept_request);       
                    amigoSistema.add(f);
                }
            } catch (SQLException e ) { JDBCTutorialUtilities.printSQLException(e);}  
            this.con.close();
        }
}
