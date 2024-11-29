/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class groupClass {
    int id;
    String class_name;
    int numberofStudent;
    int accuracy;

    public groupClass() {
    }

    public groupClass(int id, String class_name, int numberofStudent, int accuracy) {
        this.id = id;
        this.class_name = class_name;
        this.numberofStudent = numberofStudent;
        this.accuracy = accuracy;
    }

    public int getNumberofStudent() {
        return numberofStudent;
    }

    public void setNumberofStudent(int numberofStudent) {
        this.numberofStudent = numberofStudent;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    
}
