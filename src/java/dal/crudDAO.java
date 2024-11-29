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
public class crudDAO extends DBcontext {

    public String getCorrectAnswer(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect = "select * from test where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("correct_answer");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getF_wrong(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect = "select * from test where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("incorrect_answer_1");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getS_wrong(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect = "select * from test where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("incorrect_answer_2");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getT_wrong(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect = "select * from test where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("incorrect_answer_3");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getQuestion(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect = "select * from test where id=?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString("question");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteTest(String test, int testId) {
        PreparedStatement stm;
        try {
            String strSelect2 = "delete from " + test + " where id=" + testId + " ";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteQuestion(String subject, int id) {
        PreparedStatement stm;
        try {
            String strSelect2 = "delete from " + subject + " where id=" + id + " ";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addTest( String test_name, int status_id,int subject_id) {
        PreparedStatement stm;
        try {
            String strSelect2 = "insert into  testlist(test_name,status_id,subject_id) values(?,?,?) ";
            stm = connection.prepareStatement(strSelect2);
            stm.setString(1, test_name);
            stm.setInt(2, status_id);
            stm.setInt(3, subject_id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateTest(String test, String test_name) {
        PreparedStatement stm;
        try {
            String strSelect2 = "UPDATE " + test + "\n"
                    + "SET test_name='" + test_name + "'\n"
                    + "WHERE id=(select max([id]) from " + test + ") ";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addQuestion(String subject, int test_id) {
        PreparedStatement stm;
        try {
            String strSelect2 = "insert into test (testId) values(" + test_id + ")";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateQuestion(String test, String question,int id) {
        PreparedStatement stm;
        try {
            String strSelect2 = "UPDATE " + test + "\n"
                    + "SET question='" + question + "'\n"
                    + "WHERE id="+id+" ";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void addAnswer(String subject, int aid) {
        PreparedStatement stm;
        try {
            String strSelect2 = "insert into " + subject + "(aid) values(" + aid+ ")";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }  
    
    public void updateAnswer(String subject,String right_an, String f_wrong, String s_wrong, String t_wrong, int aid) {
        PreparedStatement stm;
        try {
                    String strSelect2 = "UPDATE " + subject + " SET correct_answer='" +right_an+ "'"
                            + ", incorrect_answer_1='" +f_wrong+ "'"
                            +", incorrect_answer_2='" +s_wrong+ "'"
                            +", incorrect_answer_3='" + t_wrong+ "'"
                            + " WHERE aid="+aid+" ";
            stm = connection.prepareStatement(strSelect2);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        crudDAO myCrudDAO=new crudDAO();
       // myCrudDAO.addTest("test_Mathname", "a", 2);
        System.out.println(myCrudDAO.getCorrectAnswer(1));
    }

}
