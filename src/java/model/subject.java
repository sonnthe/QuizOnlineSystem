/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class subject {
    int sid;
    String sname;
    String scode;
    String description;

    public subject() {
    }

    public subject(int sid, String sname, String scode, String description) {
        this.sid = sid;
        this.sname = sname;
        this.scode = scode;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

   

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    
}
