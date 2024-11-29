/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class accuracyDAO extends DBcontext {

    public int getAccuracy(int id, String subject) {
        PreparedStatement stm;
        ResultSet rs;
        int result = 0;
        try {
            String strSelect = "select * from accuracy where id=? ";
            stm = connection.prepareStatement(strSelect);
            //stm.setString(1, "subject");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                result = rs.getInt(subject);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int getTestnum(int id, String subject) {
        PreparedStatement stm;
        ResultSet rs;
        int result = 0;
        try {
            String strSelect = "select * from numberOftestTaken where id=? ";
            stm = connection.prepareStatement(strSelect);
            //stm.setString(1, "subject");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                result = rs.getInt(subject);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public void updateAccuracy(int id, String subject,int accuracy) {
        PreparedStatement stm;
        try {
            String strSelect = "update accuracy"
                    + " set "+subject+" = ?"
                    + " where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, accuracy);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        public void updateTestnum(int id, String subject,int num) {
        PreparedStatement stm;
        try {
            String strSelect = "update numberOftestTaken"
                    + " set "+subject+" = ?"
                    + " where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, num);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        accuracyDAO a = new accuracyDAO();
       a.updateTestnum(2, "math_number", 3);
        System.out.println(a.getTestnum(2, "math_number"));
    }
}
