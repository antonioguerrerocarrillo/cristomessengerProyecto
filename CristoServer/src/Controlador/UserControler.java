/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.User;
import Modelo.UsuarioModelo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class UserControler {
    
    UsuarioModelo userM;

    public UserControler() {
        
        userM = new UsuarioModelo();
    }
    
    
    
    
    public boolean comprobarUsuario(String login,String passwd,ArrayList<User>userSistema ) throws SQLException{
    
        boolean encontrado = false;
        
        encontrado = userM.comprobarUsuario(login,passwd);
        userM.getUsuariosTotales(userSistema);
        return encontrado;
    }

    void traerAmigosLogin(String login) {
        
    }
}
