/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class user_answer {

    int id;
    String question;
    String right_an;
    String f_wrong;
    String s_wrong;
    String t_wrong;
    String check;
    String user_answer;

    public user_answer() {
    }

    public user_answer(int id, String question, String right_an, String f_wrong, String s_wrong, String t_wrong, String check, String user_answer) {
        this.id = id;
        this.question = question;
        this.right_an = right_an;
        this.f_wrong = f_wrong;
        this.s_wrong = s_wrong;
        this.t_wrong = t_wrong;
        this.check = check;
        this.user_answer = user_answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRight_an() {
        return right_an;
    }

    public void setRight_an(String right_an) {
        this.right_an = right_an;
    }

    public String getF_wrong() {
        return f_wrong;
    }

    public void setF_wrong(String f_wrong) {
        this.f_wrong = f_wrong;
    }

    public String getS_wrong() {
        return s_wrong;
    }

    public void setS_wrong(String s_wrong) {
        this.s_wrong = s_wrong;
    }

    public String getT_wrong() {
        return t_wrong;
    }

    public void setT_wrong(String t_wrong) {
        this.t_wrong = t_wrong;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

}
