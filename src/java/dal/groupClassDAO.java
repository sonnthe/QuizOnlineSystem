/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.groupClass;

/**
 *
 * @author ADMIN
 */
public class groupClassDAO extends DBcontext{
     public ArrayList<groupClass> getGroupclass() {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<groupClass> list=new ArrayList<>();
        try {
            String strSelect = "select * from Class  ";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                groupClass group_class=new groupClass();
                group_class.setId(rs.getInt("id"));
                group_class.setClass_name(rs.getString("class"));
                group_class.setAccuracy(rs.getInt("accuracy"));
                group_class.setNumberofStudent(rs.getInt("numberofStudent"));
                list.add(group_class);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     
         public int getClassAmount() {
        PreparedStatement stm;
        ResultSet rs;
        int amount = 0;
        try {
            String strSelect = "Select COUNT(*) as amount from Class ";
            stm = connection.prepareStatement(strSelect);
            //stm.setString(1, subject);
            rs = stm.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return amount;
    }
     public static void main(String[] args) {
      groupClassDAO a= new groupClassDAO();
         System.out.println(a.getClassAmount());
    }
}
