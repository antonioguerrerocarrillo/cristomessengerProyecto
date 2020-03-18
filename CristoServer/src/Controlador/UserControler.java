/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioModelo;
import java.sql.SQLException;

/**
 *
 * @author cuvil
 */
public class UserControler {
    
    UsuarioModelo userM;

    public UserControler() {
        
        userM = new UsuarioModelo();
    }
    
    
    
    
    public boolean comprobarUsuario(String login,String passwd) throws SQLException{
    
        boolean encontrado = false;
        
        encontrado = userM.comprobarUsuario(login,passwd);
        
        return encontrado;
    }
}
