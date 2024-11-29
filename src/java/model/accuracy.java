/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class accuracy {
    String subject;
    int accuracy;
    int numberTest;

    public accuracy() {
    }

    public accuracy(String subject, int accuracy, int numberTest) {
        this.subject = subject;
        this.accuracy = accuracy;
        this.numberTest = numberTest;
    }

    public int getNumberTest() {
        return numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

  

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    
    
}
