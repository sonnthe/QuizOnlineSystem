/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.account;
import model.accuracy;

/**
 *
 * @author ADMIN
 */
public class accountDAO extends DBcontext {
    
    
    public ArrayList<account> getAll() {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<account> list = new ArrayList<>();
        try {
            String strSelect = "select * from account a, accuracy b,numberOftestTaken c  where a.aid=b.id and a.nid=c.id  ";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                account account = new account();
                ArrayList<accuracy> accuracy_list = new ArrayList<>();
                accuracy accuracy1 = new accuracy();
                accuracy1.setAccuracy(rs.getInt("math_accuracy"));
                accuracy1.setSubject("Math");
                accuracy1.setNumberTest(rs.getInt("math_number"));
                accuracy accuracy2 = new accuracy();
                accuracy2.setAccuracy(rs.getInt("lit_accuracy"));
                accuracy2.setSubject("Literature");
                accuracy2.setNumberTest(rs.getInt("lit_number"));
                accuracy accuracy3 = new accuracy();
                accuracy3.setAccuracy(rs.getInt("eng_accuracy"));
                accuracy3.setSubject("English");
                accuracy3.setNumberTest(rs.getInt("eng_number"));
                accuracy_list.add(accuracy1);
                accuracy_list.add(accuracy2);
                accuracy_list.add(accuracy3);
                account.setId(rs.getInt("id"));
                account.setUser_name(rs.getString("user_name"));
                account.setPass(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                account.setDisplay_name(rs.getString("display_name"));
                account.setEmail(rs.getString("email"));
                account.setSchool(rs.getString("school"));
                account.setPhone_number(rs.getString("phone_number"));
                account.setClass_id(rs.getInt("classid"));
                account.setAccuracy_id(accuracy_list);
                list.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<account> getNumberofAccount(int offset, int noOfRecords) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<account> list = new ArrayList<>();
        try {
            String strSelect = "select * from account a, accuracy b,numberOftestTaken c  where a.aid=b.id and a.nid=c.id order by a.id offset ? rows fetch next ? rows only ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(2, offset);
            stm.setInt(3, noOfRecords);
            rs = stm.executeQuery();
            while (rs.next()) {
                account account = new account();
                ArrayList<accuracy> accuracy_list = new ArrayList<>();
                accuracy accuracy1 = new accuracy();
                accuracy1.setAccuracy(rs.getInt("math_accuracy"));
                accuracy1.setSubject("Math");
                accuracy1.setNumberTest(rs.getInt("math_number"));
                accuracy accuracy2 = new accuracy();
                accuracy2.setAccuracy(rs.getInt("lit_accuracy"));
                accuracy2.setSubject("Literature");
                accuracy2.setNumberTest(rs.getInt("lit_number"));
                accuracy accuracy3 = new accuracy();
                accuracy3.setAccuracy(rs.getInt("eng_accuracy"));
                accuracy3.setSubject("English");
                accuracy3.setNumberTest(rs.getInt("eng_number"));
                accuracy_list.add(accuracy1);
                accuracy_list.add(accuracy2);
                accuracy_list.add(accuracy3);
                account.setId(rs.getInt("id"));
                account.setUser_name(rs.getString("user_name"));
                account.setPass(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                account.setDisplay_name(rs.getString("display_name"));
                account.setEmail(rs.getString("email"));
                account.setSchool(rs.getString("school"));
                account.setPhone_number(rs.getString("phone_number"));
                account.setClass_id(rs.getInt("classid"));
                account.setAccuracy_id(accuracy_list);
                list.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<account> getAllUser(int id) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<account> list = new ArrayList<>();
        try {
            String strSelect = "select * from account a, accuracy b, numberOftestTaken c where a.aid=b.id and a.nid=c.id and classid=? ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                account account = new account();
                ArrayList<accuracy> accuracy_list = new ArrayList<>();
                accuracy accuracy1 = new accuracy();
                accuracy1.setAccuracy(rs.getInt("math_accuracy"));
                accuracy1.setSubject("Math");
                accuracy1.setNumberTest(rs.getInt("math_number"));
                accuracy accuracy2 = new accuracy();
                accuracy2.setAccuracy(rs.getInt("lit_accuracy"));
                accuracy2.setSubject("Literature");
                accuracy2.setNumberTest(rs.getInt("lit_number"));
                accuracy accuracy3 = new accuracy();
                accuracy3.setAccuracy(rs.getInt("eng_accuracy"));
                accuracy3.setSubject("English");
                accuracy3.setNumberTest(rs.getInt("eng_number"));
                accuracy_list.add(accuracy1);
                accuracy_list.add(accuracy2);
                accuracy_list.add(accuracy3);
                account.setId(rs.getInt("id"));
                account.setUser_name(rs.getString("user_name"));
                account.setPass(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                account.setDisplay_name(rs.getString("display_name"));
                account.setEmail(rs.getString("email"));
                account.setSchool(rs.getString("school"));
                account.setPhone_number(rs.getString("phone_number"));
                account.setClass_id(rs.getInt("classid"));
                account.setAccuracy_id(accuracy_list);
                list.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public account getAccount(String name, String pass) {
        PreparedStatement stm;
        ResultSet rs;
        account account = new account();
        try {
            String strSelect = "select * from account a, accuracy b, numberOftestTaken c where a.aid=b.id and a.nid=c.id and [user_name]LIKE'" + name + "' and [password]LIKE'" + pass + "' ";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            if (rs.next()) {
                ArrayList<accuracy> accuracy_list = new ArrayList<>();
                accuracy accuracy1 = new accuracy();
                accuracy1.setAccuracy(rs.getInt("math_accuracy"));
                accuracy1.setSubject("Math");
                accuracy1.setNumberTest(rs.getInt("math_number"));
                accuracy accuracy2 = new accuracy();
                accuracy2.setAccuracy(rs.getInt("lit_accuracy"));
                accuracy2.setSubject("Literature");
                accuracy2.setNumberTest(rs.getInt("lit_number"));
                accuracy accuracy3 = new accuracy();
                accuracy3.setAccuracy(rs.getInt("eng_accuracy"));
                accuracy3.setSubject("English");
                accuracy3.setNumberTest(rs.getInt("eng_number"));
                accuracy_list.add(accuracy1);
                accuracy_list.add(accuracy2);
                accuracy_list.add(accuracy3);
                account.setId(rs.getInt("id"));
                account.setUser_name(rs.getString("user_name"));
                account.setPass(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                account.setDisplay_name(rs.getString("display_name"));
                account.setEmail(rs.getString("email"));
                account.setSchool(rs.getString("school"));
                account.setPhone_number(rs.getString("phone_number"));
                account.setClass_id(rs.getInt("classid"));
                account.setAccuracy_id(accuracy_list);
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public account getAccountById(int id) {
        PreparedStatement stm;
        ResultSet rs;
        account account = new account();
        try {
            String strSelect = "select * from account a, accuracy b, numberOftestTaken c where a.aid=b.id and a.nid=c.id and a.id=? ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                ArrayList<accuracy> accuracy_list = new ArrayList<>();
                accuracy accuracy1 = new accuracy();
                accuracy1.setAccuracy(rs.getInt("math_accuracy"));
                accuracy1.setSubject("Math");
                accuracy1.setNumberTest(rs.getInt("math_number"));
                accuracy accuracy2 = new accuracy();
                accuracy2.setAccuracy(rs.getInt("lit_accuracy"));
                accuracy2.setSubject("Literature");
                accuracy2.setNumberTest(rs.getInt("lit_number"));
                accuracy accuracy3 = new accuracy();
                accuracy3.setAccuracy(rs.getInt("eng_accuracy"));
                accuracy3.setSubject("English");
                accuracy3.setNumberTest(rs.getInt("eng_number"));
                accuracy_list.add(accuracy1);
                accuracy_list.add(accuracy2);
                accuracy_list.add(accuracy3);
                account.setId(rs.getInt("id"));
                account.setUser_name(rs.getString("user_name"));
                account.setPass(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                account.setDisplay_name(rs.getString("display_name"));
                account.setEmail(rs.getString("email"));
                account.setSchool(rs.getString("school"));
                account.setPhone_number(rs.getString("phone_number"));
                account.setClass_id(rs.getInt("classid"));
                account.setAccuracy_id(accuracy_list);
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getAccountamount() {
        PreparedStatement stm;
        ResultSet rs;
        int result = 0;
        try {
            String strSelect = "select COUNT(*) as amount from account ";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public void addAccount(String name, String pass, String display, String email, String school, String phone) {
        PreparedStatement stm;
        try {
            String strSelect = "  insert into account(user_name,password,role,display_name,email,school,phone_number) "
                    + "VALUES('" + name + "','" + pass + "',2,'" + display + "','" + email + "','" + school + "','" + phone + "')";
            stm = connection.prepareStatement(strSelect);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteAccount(int id) {
        PreparedStatement stm;
        try {
            String strSelect = "  delete from account where id =?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        accountDAO a = new accountDAO();
        account s = a.getAccountById(2);
        System.out.println(s.getAccuracy_id().get(1).getSubject() + s.getAccuracy_id().get(1).getAccuracy()+s.getAccuracy_id().get(1).getNumberTest());
    }
}
