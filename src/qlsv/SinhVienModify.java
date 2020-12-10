/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SinhVienModifily {

    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/student";
    private String user = "root";
    private String pass = "";
    private String className = "com.mysql.jdbc.Driver";

    public SinhVienModifily() {
        try {
            Class.forName(className);
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect succsesfully !");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVienModifily.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModifily.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SinhVien> getAllSV() {
        List<SinhVien> sinhvienList = new ArrayList<>();
        Statement st; // cau len hho tro thuc thao tac voi csdl
        ResultSet rs;
        try {
            String sql = "select *from tbstudent";
            st = conn.createStatement(); //
            rs = st.executeQuery(sql);
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString("ID"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getInt("Age"),
                        rs.getString("Email"),
                        rs.getString("Phone"));
                sinhvienList.add(sv);

            }

        } catch (Exception e) {
        }
        return sinhvienList;

    }

    public boolean addSV(SinhVien s) {
        try {
            String sql = "insert into tbstudent(ID, Name, Gender, Age, Email, Phone) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, s.getID());
            ps.setString(2, s.getName());
            ps.setString(3, s.getGender());
            ps.setInt(4, s.getAge());
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getPhone());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;

    }

    public boolean editSV(SinhVien s) {
        try {
            String sql = "update tbstudent set Name=?,Gender=?,Age=?,Email=?,Phone=? where ID = ?";
            PreparedStatement ps = conn.prepareCall(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getGender());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getID());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(" " + e);
            

        }
        return false;

    }
    public List<SinhVien> findSV(String ID) {
        List<SinhVien> sinhvienSearh = new ArrayList<>();
        Statement st;
        ResultSet rs;
        try {
            String sql = "select *from tbstudent where ID like '%"+ID+"' OR Name like '%"+ID+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString("ID"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getInt("Age"),
                        rs.getString("Email"),
                        rs.getString("Phone"));
                sinhvienSearh.add(sv);

            }

        } catch (Exception e) {
        }
        return sinhvienSearh;

    }
    public boolean Delete(String ID)
    {
        try {
            String sql = "delete from tbstudent where ID=?";
            PreparedStatement ps = conn.prepareCall(sql);
             ps.setString(1, ID);
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public static void main(String[] args) {
      new SinhVienModifily();

    }

}
