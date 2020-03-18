/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.InterfazCliente;
import Vista.UsuarioCorrecto;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
/**
 *
 * @author cuvil
 */
/**
 *
 * @author cuvil
 */
public class ClienteThread  extends Thread {
    String name, mandamosServer, contrasena, ip;
    int puerto;
    String server;
    UsuarioCorrecto uC;
 
    public ClienteThread(String usuario, String contrasena, String mandamosServer, int puerto, String ip, JFrame aThis) {
        this.name = usuario;
        this.contrasena = contrasena;
        this.mandamosServer = mandamosServer;
        this.ip = ip;
        this.puerto = puerto;
        uC = new UsuarioCorrecto();
        
        
    }
    
    @Override
    public void run(){
        
        try (
            //creo un socket con la ip y el puerto
            Socket kkSocket = new Socket(ip, puerto);
            //escribo en la salida del soket
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            //creo un buffer de entrada
            BufferedReader in = new BufferedReader(
               new InputStreamReader(kkSocket.getInputStream()));
            
            ) { 
                System.out.println("Client encia : " + mandamosServer);

                out.println(mandamosServer);
                server = in.readLine();
                System.out.println("Que me devuelve el server  = " + server);

            } catch (UnknownHostException e) {
                //si no se apodido conectar mando este mensaje
                System.err.println("Don't know about host " + ip);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " +
                    ip);
                System.exit(1);
        }
    }
    
    
    
    
}

