/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class account {

    int id;
    String user_name;
    String pass;
    int role;
    String display_name;
    String email;
    String school;
    String phone_number;
    int class_id;
    ArrayList<accuracy> accuracy_id;

    public account() {
    }

    public account(int id, String user_name, String pass, int role, String display_name, String email, String school, String phone_number, int class_id, ArrayList<accuracy> accuracy_id) {
        this.id = id;
        this.user_name = user_name;
        this.pass = pass;
        this.role = role;
        this.display_name = display_name;
        this.email = email;
        this.school = school;
        this.phone_number = phone_number;
        this.class_id = class_id;
        this.accuracy_id = accuracy_id;
    }

    public ArrayList<accuracy> getAccuracy_id() {
        return accuracy_id;
    }

    public void setAccuracy_id(ArrayList<accuracy> accuracy_id) {
        this.accuracy_id = accuracy_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
