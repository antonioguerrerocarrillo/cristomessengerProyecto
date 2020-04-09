/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *Hola:
Participe en la videollamada haciendo clic en el siguiente vínculo:
https://go.teamviewer.com/v15/m02358428
ID de la reunión: m023-584-28


Saludos,
Antonio cuvi

www.teamviewer.com - Reúnase en línea y comparta pantalla fácilmente
 * @author cuvil
 */
public class Friend {
   String id_user_orig = "null";
   String id_user_dest = "null", accept_request;

    public String getId_user_orig() {
        return id_user_orig;
    }

    public void setId_user_orig(String id_user_orig) {
        this.id_user_orig = id_user_orig;
    }

    public String getId_user_dest() {
        return id_user_dest;
    }

    public void setId_user_dest(String id_user_dest) {
        this.id_user_dest = id_user_dest;
    }

    public String getAccept_request() {
        return accept_request;
    }

   /* public void setAccept_request(int accept_request) {
        this.accept_request = accept_request;
    }*/

    public void printfriend(Friend a){
         System.out.println("\t" + a.getId_user_orig() + a.getId_user_dest() + "\t" + a.getAccept_request());
    }

    public void setAccept_request(String accept_request) {
        this.accept_request = accept_request;
    }
}
