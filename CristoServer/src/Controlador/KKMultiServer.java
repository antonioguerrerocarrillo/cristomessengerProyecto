/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class KKMultiServer extends Thread{
    
    int port;
    ArrayList<KKHebraServer> arrayHebras;
    
    public KKMultiServer(int port){
            super();
                this.port = port;
                arrayHebras = new ArrayList();

        System.out.println("LLEga");
   }
     @Override
    public void run() {
 
        System.out.println("LLEga2");
        boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) { 
            while (listening) {
                KKHebraServer k = new KKHebraServer(this,serverSocket.accept());
                arrayHebras.add(k);
                arrayHebras.get(arrayHebras.size()-1).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }
    
}
