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
public class User {
  String id_user = "null";
  String name = "null";
  String password = "null"; 
  String surname1 = "null"; 
  String surname2 = "null"; 
  String photo = "null";
  int state = 0; 

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public void printuser(User a){
         System.out.println("\t" + a.getId_user() + "\t" + a.getName() + "  " + a.getPassword() + "  " + a.getSurname1()+ "  " + a.getSurname2() + "  " + a.getPhoto() + "  " + a.getState());
    } 
}

