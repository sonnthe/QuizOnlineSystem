/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.subject;

/**
 *
 * @author ADMIN
 */
public class subjectDAO extends DBcontext{
     public ArrayList<subject> getSubject() {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<subject> list=new ArrayList<>();
        try {
            String strSelect = "select * from Subject ";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                subject subject= new subject();
                subject.setSid(rs.getInt("sid"));
                subject.setSname(rs.getString("subject_name"));
                subject.setScode(rs.getString("scode"));
                subject.setDescription(rs.getString("description"));
                list.add(subject);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     
     public int getSidByScode(String scode) {
        PreparedStatement stm;
        ResultSet rs;
        int result=0;
        try {
            String strSelect = "select sid from Subject where scode like ? ";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, scode);
            rs = stm.executeQuery();
            while (rs.next()) {
               result=rs.getInt("sid");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
     public static void main(String[] args) {
        subjectDAO a=new subjectDAO();
         System.out.println(a.getSidByScode("lit"));
    }
     
}
