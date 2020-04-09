/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.InterfazCliente;
import Vista.UsuarioCorrecto;
import Vista.usuarioIncorrecto;
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
    String cadenaIn;
    UsuarioCorrecto uC;
    usuarioIncorrecto incorrecto;
    JFrame f;
    int totalAmigos;
    
    public ClienteThread(String usuario, String contrasena, String mandamosServer, int puerto, String ip, JFrame userInicio) {
        this.name = usuario;
        this.contrasena = contrasena;
        this.mandamosServer = mandamosServer;
        this.ip = ip;
        this.puerto = puerto;
        uC = new UsuarioCorrecto();
        f = userInicio;
        incorrecto = new usuarioIncorrecto();
        this.totalAmigos = 0;
        
        
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
                cadenaIn = in.readLine();
                System.out.println("Que me devuelve el server  = " + cadenaIn);

                if(cadenaIn.contains("PROTOCOLCRISTOMESSENGER1.0#SERVER#LOGIN_CORRECT#")){
                    f.setVisible(false);
                    uC.setVisible(true);
                    String[] arrayCadena = cadenaIn.split("#");
                    totalAmigos = Integer.parseInt(arrayCadena[5]);
                    System.out.println("total " + totalAmigos);
                    String[] amigoLista = new String[totalAmigos];
                    int cont = 0;
                    for(int i = 0; i < totalAmigos*2;i++ ){
                        if(i%2==0){
                            amigoLista[cont] = arrayCadena[i+6];  
                            amigoLista[cont] += " " + arrayCadena[i+6+1];
                            i++;
                        }else{
                            amigoLista[cont] = arrayCadena[i+5];  
                            amigoLista[cont] += " " + arrayCadena[i+6];
                        }
                      
                        cont++;
                    }
                    uC.setLista_usuario_conectados(amigoLista);
                    
                }  else{
                    f.setVisible(false);
                    incorrecto.setVisible(true);
                    System.out.println("entra aqui");
                }
              
                
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

