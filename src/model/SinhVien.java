/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author tuandinh
 */
public class SinhVien {
    private String Masv ;
    private String Tensv;
    private Date ngaysinh;
    private String lop;
    private String khoa;
    private boolean gioitinh;

    public SinhVien(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
 public SinhVien(String Masv, String Tensv) {
        this.Masv = Masv;
        this.Tensv = Tensv;
    }
    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

   

    public SinhVien() {
    }

    public SinhVien(String Masv, String Tensv, Date ngaysinh, String lop, String khoa) {
        this.Masv = Masv;
        this.Tensv = Tensv;
        this.ngaysinh = ngaysinh;
        this.lop = lop;
        this.khoa = khoa;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public String getTensv() {
        return Tensv;
    }

    public void setTensv(String Tensv) {
        this.Tensv = Tensv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
