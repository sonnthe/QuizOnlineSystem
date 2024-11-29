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
import model.testName;

/**
 *
 * @author ADMIN
 */
public class testNameDAO extends DBcontext {

    public ArrayList<testName> getTest(String subject, int offset, int noOfRecords) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<testName> list = new ArrayList<>();
        try {
            String strSelect = "select * from testlist where status_id=1"
                    + " and subject_id in (select sid from Subject where scode like ?) "
                    + " order by id offset " + offset + " rows fetch next " + noOfRecords + " rows only ";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, subject);
            rs = stm.executeQuery();
            while (rs.next()) {
                testName test = new testName();
                test.setId(rs.getInt("id"));
                test.setTest_name(rs.getString("test_name"));
                test.setDescription(rs.getString("description"));
                test.setPublication(rs.getString("publication_time"));
                if (rs.getInt("level") == 1) {
                    test.setLevel("Easy");
                }
                if (rs.getInt("level") == 2) {
                    test.setLevel("Normal");
                }
                if (rs.getInt("level") == 3) {
                    test.setLevel("Hard");
                }
                list.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

     public ArrayList<testName> getWaittingTest(String subject, int offset, int noOfRecords) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<testName> list = new ArrayList<>();
        try {
           String strSelect = "select * from testlist where status_id=2"
                    + " and subject_id in (select sid from Subject where scode like ?) "
                    + " order by id offset " + offset + " rows fetch next " + noOfRecords + " rows only ";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, subject);
            rs = stm.executeQuery();
            while (rs.next()) {
                testName test = new testName();
                test.setId(rs.getInt("id"));
                test.setTest_name(rs.getString("test_name"));
                test.setDescription(rs.getString("description"));
                test.setPublication(rs.getString("publication_time"));
                if (rs.getInt("level") == 1) {
                    test.setLevel("Easy");
                }
                if (rs.getInt("level") == 2) {
                    test.setLevel("Normal");
                }
                if (rs.getInt("level") == 3) {
                    test.setLevel("Hard");
                }
                list.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<testName> getTestBylevel(String subject, int offset, int noOfRecords, String level) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<testName> list = new ArrayList<>();
        try {
            String strSelect = "select * from " + subject + " where level LIKE ? order by id offset " + offset + " rows fetch next " + noOfRecords + " rows only ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, level(level));
            rs = stm.executeQuery();
            while (rs.next()) {
                testName test = new testName();
                test.setId(rs.getInt("id"));
                test.setTest_name(rs.getString("test_name"));
                test.setDescription(rs.getString("description"));
                test.setPublication(rs.getString("publication_time"));
                if (rs.getInt("level") == 1) {
                    test.setLevel("Easy");
                }
                if (rs.getInt("level") == 2) {
                    test.setLevel("Normal");
                }
                if (rs.getInt("level") == 3) {
                    test.setLevel("Hard");
                }
                list.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTestAmount(String subject) {
        PreparedStatement stm;
        ResultSet rs;
        int amount = 0;
        try {
            String strSelect = "Select COUNT(*) as amount from testlist where status_id=1 and subject_id in (select sid from Subject where scode like ?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, subject);
            rs = stm.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return amount;
    }
    
     public int getWaittingTestAmount(String subject) {
        PreparedStatement stm;
        ResultSet rs;
        int amount = 0;
        try {
            String strSelect = "Select COUNT(*) as amount from testlist where status_id=2 and subject_id in (select sid from Subject where scode like ?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, subject);
            rs = stm.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return amount;
    }

    public int getTestAmountWithtime(String subject, int time) {
        PreparedStatement stm;
        ResultSet rs;
        int amount = 0;
        try {
            String strSelect = "Select COUNT(*) as amount from " + subject + " where YEAR(publication_time)=?";
            stm = connection.prepareStatement(strSelect);
            //stm.setString(1, subject);
            stm.setInt(1, time);
            rs = stm.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return amount;
    }

    public int getTestAmountWithlevel(String subject, String level) {
        PreparedStatement stm;
        ResultSet rs;
        int amount = 0;
        try {
            String strSelect = "Select COUNT(*) as amount from " + subject + " where level=?";
            stm = connection.prepareStatement(strSelect);
            //stm.setString(1, subject);
            stm.setInt(1, level(level));
            rs = stm.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return amount;
    }

    public String getTestname( int test_id) {
        PreparedStatement stm;
        ResultSet rs;
        String test_name = "";
        try {
            String strSelect2 = "select test_name from testlist where id=" + test_id + "";
            stm = connection.prepareStatement(strSelect2);
            rs = stm.executeQuery();
            if (rs.next()) {
                test_name = rs.getString("test_name");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return test_name;
    }

    public int getMaxTestid() {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String strSelect2 = "select max([id])as id from testlist";
            stm = connection.prepareStatement(strSelect2);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
    
     public void ApproveTest(int id) {
        PreparedStatement stm;
        
        try {
            String strSelect2 = "Update testlist"
                    + " Set status_id=1"
                    + " where id=?";
            stm = connection.prepareStatement(strSelect2);
            stm.setInt(1, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<testName> getTestByTime(String subject, int offset, int noOfRecords, int date) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<testName> list = new ArrayList<>();
        try {
            String strSelect = "select * from " + subject + " where YEAR(publication_time)=? order by id offset " + offset + " rows fetch next " + noOfRecords + " rows only "
                    + "";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, date);
            rs = stm.executeQuery();
            while (rs.next()) {
                testName test = new testName();
                test.setId(rs.getInt("id"));
                test.setTest_name(rs.getString("test_name"));
                test.setDescription(rs.getString("description"));
                test.setPublication(rs.getString("publication_time"));
                if (rs.getInt("level") == 1) {
                    test.setLevel("Easy");
                }
                if (rs.getInt("level") == 2) {
                    test.setLevel("Normal");
                }
                if (rs.getInt("level") == 3) {
                    test.setLevel("Hard");
                }
                list.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public int level(String a){
        if(a.equalsIgnoreCase("hard")){
            return 3;
        }
        if(a.equalsIgnoreCase("normal")){
            return 2;
        }
        if(a.equalsIgnoreCase("easy")){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        testNameDAO a = new testNameDAO();
        a.ApproveTest(19);
    }
}
