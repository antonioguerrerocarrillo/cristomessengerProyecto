/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuvil
 */
class KKHebraServer extends Thread{
 
        KKMultiServer serverSocket;
        String inputLine;
        String outputLine;
        Socket socket;
         
    KKHebraServer(KKMultiServer aThis,Socket s) {
       super("KKHebraServer");
       serverSocket = aThis;
       socket= s;
    }
     @Override
    public void run() {
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            
    
            ProtocoloServer kkp = new ProtocoloServer();
            
           inputLine = in.readLine();
            System.out.println("Recibimos del Cliente : " + inputLine);
           // while ((inputLine = in.readLine()) != null) {
            outputLine = kkp.processInput(inputLine);
           
            if (outputLine.contains("#LOGIN_CORRECT")){
                
                 out.println(outputLine); 
            }
            if(outputLine.contains("#BAD_LOGIN")){
                    System.out.println("bad login " + outputLine);
                    
            }
        } catch (IOException e) {
        }   catch (SQLException ex) {
                Logger.getLogger(KKHebraServer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}