package model;

import MainController.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVienDao {
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
    
    
    
    
    public int add(SinhVien sv) {
    
        String sSQL = "INSERT INTO SinhVien(Masv, Tensv, Ngaysinh, GioiTinh, Lop, Khoa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtils.getDBConnect(); 
             PreparedStatement sttm = conn.prepareStatement(sSQL)) {
            sttm.setString(1, sv.getMasv());
            sttm.setString(2, sv.getTensv());
            sttm.setString(3, format_date.format(sv.getNgaysinh()));
            sttm.setBoolean(4, sv.isGioitinh());
            sttm.setString(5, sv.getLop());
            sttm.setString(6, sv.getKhoa());
            if (sttm.executeUpdate() > 0) {
                System.out.println("add thành công");
                return 1;
            }
        } catch (Exception e) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, "Error inserting data: ", e);
        }
        return -1;
    }

    public int updateSinhVienByID(SinhVien sv) {
        String sSQL = "UPDATE SinhVien SET Tensv = ?, NgaySinh = ?, GioiTinh = ?, Lop = ?, Khoa = ? WHERE Masv = ?";
        try (Connection conn = DatabaseUtils.getDBConnect(); 
             PreparedStatement sttm = conn.prepareStatement(sSQL)) {
            sttm.setString(1, sv.getTensv());
            sttm.setString(2, format_date.format(sv.getNgaysinh()));
            sttm.setBoolean(3, sv.isGioitinh());
            sttm.setString(4, sv.getLop());
            sttm.setString(5, sv.getKhoa());
            sttm.setString(6, sv.getMasv());
            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, "Error updating data: ", e);
        }
        return -1;
    }

    public int delSinhVienByID(String maSV) {
        String sSQL = "DELETE FROM SinhVien WHERE Masv = ?";
        try (Connection conn = DatabaseUtils.getDBConnect(); 
             PreparedStatement sttm = conn.prepareStatement(sSQL)) {
            sttm.setString(1, maSV);
            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, "Error deleting data: ", e);
        }
        return -1;
    }

    public List<SinhVien> getAllSinhViens() {
        List<SinhVien> ls = new ArrayList<>();
        String sSQL = "SELECT * FROM SinhVien";
        try (Connection conn = DatabaseUtils.getDBConnect(); 
             PreparedStatement sttm = conn.prepareStatement(sSQL); 
             ResultSet rs = sttm.executeQuery()) {
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMasv(rs.getString("Masv"));
                sv.setTensv(rs.getString("Tensv"));
                sv.setNgaysinh(rs.getDate("Ngaysinh"));
                sv.setGioitinh(rs.getBoolean("Gioitinh"));
                sv.setLop(rs.getString("Lop"));
                sv.setKhoa(rs.getString("Khoa"));
                ls.add(sv);
            }
        } catch (SQLException e) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, "Error getting data: ", e);
        }
        return ls;
    }

    public SinhVien getSinhVienByID(String maSV) {
        String sSQL = "SELECT * FROM SinhVien WHERE Masv = ?";
        try (Connection conn = DatabaseUtils.getDBConnect(); 
             PreparedStatement sttm = conn.prepareStatement(sSQL)) {
            sttm.setString(1, maSV);
            try (ResultSet rs = sttm.executeQuery()) {
                if (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString("Masv"));
                    sv.setTensv(rs.getString("Tensv"));
                    sv.setNgaysinh(rs.getDate("Ngaysinh"));
                    sv.setGioitinh(rs.getBoolean("Gioitinh"));
                    sv.setLop(rs.getString("Lop"));
                    sv.setKhoa(rs.getString("Khoa"));
                    return sv;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(SinhVienDao.class.getName()).log(Level.SEVERE, "Error getting data by ID: ", e);
        }
        return null;
    }
    
}
