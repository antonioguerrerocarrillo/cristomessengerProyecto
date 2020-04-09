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
    ArrayList<Friend> amigosSistema;
    FriendControler friendControler;
    int totalFriend;
    
    public ProtocoloServer(){
    
        userC = new UserControler();
        usuarioSistema = new ArrayList();
        amigosSistema = new ArrayList();
        friendControler = new FriendControler();
    
    }
     public String cadenaAlmacenaje(){
        
           String cadenaAlmacenaje = "";
          totalFriend = 0; 
            for(int i = 0; i < amigosSistema.size();i++ ){
                if(amigosSistema.get(i).getId_user_orig().equals(login)){
              
                    totalFriend++;
                     for(int u = 0; u < usuarioSistema.size();u++ ){

                         if(amigosSistema.get(i).getId_user_dest().equals(usuarioSistema.get(u).getId_user())){
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
           boolean encontrado = userC.comprobarUsuario(login, passwd,usuarioSistema);
           
           if(encontrado){
              friendControler.getAmigos(amigosSistema,login);
              String devolverCadenaEstado = cadenaAlmacenaje();
              devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#LOGIN_CORRECT#"+login+"#FRIENDS#"+totalFriend+devolverCadenaEstado;
              
           }else{
               System.out.println("entra aki tio");
               devolverCadenaHebra = "PROTOCOLCRISTOMESSENGER1.0#SERVER#ERROR#BAD_LOGIN";
           }
       }
       
       return devolverCadenaHebra;
    }
    
}
