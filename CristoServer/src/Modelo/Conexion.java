/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cuvil
 */
public class Conexion {
    
    protected String modo;
    protected String contrasena;
    protected String puerto;
    protected Connection con;
    protected String driver;
    protected String url;
    
    public Conexion(){
        
        this.modo = "clasedam2";
        this.contrasena = "root";
        this.url = "jdbc:mysql://clasedam2.ddns.net:3306/cristomessenger";
        this.driver = "com.mysql.jdbc.Driver";
 
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
    public void conectar(){
            try{
           
            this.con =  (Connection) DriverManager.getConnection(this.url,this.modo,this.contrasena);
           
            if(this.con != null){
          
            }
        }catch (SQLException e){

           System.out.println(e.getMessage());
        }
    }
    public void desconectarBD(){

        con = null;
        if(con == null)
            System.out.println("Conexion cerrada");
    }

}
