/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import MainController.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import  java.sql.ResultSet;
/**
 *
 * @author tuandinh
 */
public class GradeDao {
    List<Grade> ls = new ArrayList<>();
    
public int add(Grade g) {
    Connection conn = null;
    PreparedStatement sttm = null;
    
    try  {
        String sSQL = "INSERT INTO Grade(Masv, diemQT, diemTP, diemTB) VALUES (?, ?, ?, ?)";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL); // Tạo PreparedStatement
        sttm.setString(1, g.getSv().getMasv());
        sttm.setDouble(2, g.getDiemQT());
        sttm.setDouble(3, g.getDiemTP());
        double diemTB = (g.getDiemQT() + g.getDiemTP()) / 2;
        sttm.setDouble(4, diemTB);
        if (sttm.executeUpdate() > 0) {
            System.out.println("add thành công");
            return 1;
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sttm != null) {
                sttm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return -1;
}

     
     
    public List<Grade> getAllGrades(){
        return ls;
    }
    
    public Grade getOneGradeByMaSV(String maSV) {
        Connection conn = null;
         PreparedStatement sttm = null;
        ResultSet rs = null;
        Grade g = null;
    try {
        String sSQL = "SELECT dbo.Grade.Masv, dbo.SinhVien.Tensv, dbo.Grade.DiemQT, "
                   + "dbo.Grade.DiemTP, dbo.Grade.DiemTB "
                   + "FROM dbo.Grade INNER JOIN dbo.SinhVien ON dbo.Grade.Masv = dbo.SinhVien.Masv "
                   + "WHERE Grade.Masv = ?";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL);
        sttm.setString(1, maSV); // Truyền giá trị của maSV vào câu lệnh truy vấn
        rs = sttm.executeQuery();
        if (rs.next()) {
            g = new Grade();
            g.setSv(new SinhVien(rs.getString(1), rs.getString(2)));
            g.setDiemQT(rs.getDouble(3));
            g.setDiemTP(rs.getDouble(4));
            g.setDiemTB(rs.getDouble(5));
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sttm != null) {
                sttm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return g;
}

    
    
    public Grade getOneGrade(String maSV){
        for(Grade d : ls){
            if(d.getSv().getTensv().equalsIgnoreCase(maSV)){
                return d;
            }
        }
        return null;
    }
    public int updateGrade(Grade dNew){
        for (Grade d :ls){
            if(d.getSv().getTensv().equalsIgnoreCase(dNew.getSv().getMasv())){
                d.setDiemQT(dNew.getDiemQT());
                d.setDiemTP(dNew.getDiemTP());
                d.setDiemTB(dNew.getDiemTB());
                return 1;
            }
        }
        return -1;
    }
    

    public int update(Grade g) {
         Connection conn = null;
    PreparedStatement sttm = null;
    
    try {
        String sSQL = "UPDATE Grade SET diemQT = ?, diemTP = ?, diemTB = ? WHERE Masv = ?";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL); // Tạo PreparedStatement
        sttm.setDouble(1, g.getDiemQT());
        sttm.setDouble(2, g.getDiemTP());
        double diemTB = (g.getDiemQT() + g.getDiemTP()) / 2;
        sttm.setDouble(3, diemTB);
        sttm.setString(4, g.getSv().getMasv());
        if (sttm.executeUpdate() > 0) {
            System.out.println("update thành công");
            return 1;
        }
    } catch (Exception e) {
        System.out.println("Error:" + e.toString());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
            if (sttm != null) {
                sttm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return -1;
    }
    public int delGrade(String maSV){
        Grade d = getOneGrade(maSV);
        if (d!= null) {
            ls.remove(d);
            return 1;
        }
        return -1;
    }
}
