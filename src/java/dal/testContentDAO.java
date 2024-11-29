/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.testContent;

/**
 *
 * @author ADMIN
 */
public class testContentDAO extends DBcontext {

    public ArrayList<testContent> getTest(int test_id) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<testContent> list = new ArrayList<>();
        try {
            String strSelect = "select * from test where testId=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, test_id);
            rs = stm.executeQuery();
            while (rs.next()) {
                testContent test = new testContent();
                test.setId(rs.getInt("id"));
                test.setQuestion(rs.getString("question"));
                test.setRight_an(rs.getString("correct_answer"));
                test.setF_wrong(rs.getString("incorrect_answer_1"));
                test.setS_wrong(rs.getString("incorrect_answer_2"));
                test.setT_wrong(rs.getString("incorrect_answer_3"));
                test.setTestId(test_id);
                list.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList getTestid(int testId) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList list = new ArrayList<>();
        try {
            String strSelect2 = "select id from test where testId=?";
            stm = connection.prepareStatement(strSelect2);
            stm.setInt(1, testId);
            rs = stm.executeQuery();
            while (rs.next()) {
                int a = rs.getInt("id");
                list.add(a);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public int getTestlength( int testId) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect2 = "select COUNT(*)as id from test where testId=?";
            stm = connection.prepareStatement(strSelect2);
            stm.setInt(1, testId);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }

    public static void main(String[] args) {
        testContentDAO a = new testContentDAO();
        ArrayList<testContent> list = a.getTest(1);
        System.out.println(list.get(0).getQuestion());
    }

}
