/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Friend;
import Clases.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
class ProtocoloServer {

    String login;
    String passwd;
    UserControler userC;
    int amigosUserConectado;
    ArrayList<User> usuarioSistema;
    ArrayList<Friend> amigoSistema;
    FriendControler friendControler;
    
    public ProtocoloServer(){
    
        userC = new UserControler();
        usuarioSistema = new ArrayList();
        amigoSistema = new ArrayList();
        
    
    }
     public String cadenaAlmacenaje(){
        
         String cadenaAlmacenaje = "";
          amigosUserConectado = 0; 
          
            for(int i = 0; i < amigoSistema.size();i++ ){
                if(amigoSistema.get(i).getId_user_orig().equals(login)){
                //    System.out.println("@DEBUF :: Imprimimos..++++" +amigosSistema.get(i).getId_user_orig());
                    amigosUserConectado++;
                     for(int u = 0; u < usuarioSistema.size();u++ ){

                         if(amigoSistema.get(i).getId_user_dest().equals(usuarioSistema.get(u).getId_user())){
                            //   System.out.println("@ DEBUG : Amigos que tiene"+usuariosSistema.get(u).getId_user());
                             cadenaAlmacenaje +=  "#" + usuarioSistema.get(u).getId_user();
                            if(usuarioSistema.get(u).getState() == 1){
                                cadenaAlmacenaje +="#CONNECTED";
                            }else
                                  cadenaAlmacenaje +="#NOT_CONNECTED";
                         }

                     }
                  }
            }
         return cadenaAlmacenaje;
     }
    public String processInput(String inputLine) throws SQLException {
        String devolverCadenaHebra = null;
        String[] arrayCadena = inputLine.split("#");
        
       if(inputLine.contains("PROTOCOLCRISTOMESSENGER1.0#") && inputLine.contains("#CLIENT#LOGIN")){
           login = arrayCadena[4];
           passwd = arrayCadena[5];
           boolean encontrado = userC.comprobarUsuario(login, passwd);
           
           if(encontrado){
              friendControler.getAmigos(amigoSistema,login);
              userC.traerAmigosLogin(login);
              devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#";
              
           }else{
               devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#ERROR#BAD_LOGIN";
           }
       }
       
       return devolverCadenaHebra;
    }
    
}
