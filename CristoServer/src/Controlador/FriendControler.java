/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Friend;
import Modelo.FriendModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class FriendControler {
    FriendModel fModelo;

    public FriendControler(FriendModel fModelo) {
        this.fModelo = fModelo;
    }
    
    
    void getAmigos(ArrayList<Friend> amigoSistema, String login) throws SQLException {
       fModelo.getAmigos(amigoSistema,login);
    }
    
}
