/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author cuvil
 */
public class Message {
   String id_user_orig = "null";
   String id_user_dest = "null";
   String date = "null";
   String hour = "null";
   int read = 0;
   int sent = 0; 
   String text = "null";

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
      public void printmessage(Message a){
         System.out.println("\t" + a.getId_user_orig() + a.getId_user_dest() + "\t" + a.getDate() + "  " + a.getHour() + " :read: " + a.getRead()+ " :sent: " + a.getSent() + "  " + a.getText());
    }
}
