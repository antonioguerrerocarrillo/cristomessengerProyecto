/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;

/**
 *
 * @author cuvil
 */
class ProtocoloServer {

    String login;
    String passwd;
    UserControler userC;
    
    public ProtocoloServer(){
    
        userC = new UserControler();
    
    }
    public String processInput(String inputLine) throws SQLException {
       String devolverCadenaHebra = null;
        String[] arrayCadena = inputLine.split("#");
        
       if(inputLine.contains("PROTOCOLCRISTOMESSENGER1.0#") && inputLine.contains("#CLIENT#LOGIN")){
           login = arrayCadena[4];
           passwd = arrayCadena[5];
           boolean encontrado = userC.comprobarUsuario(login, passwd);
           
           if(encontrado){
              devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#";
           }else{
               devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#ERROR#BAD_LOGIN";
           }
       }
       
       return devolverCadenaHebra;
    }
    
}
