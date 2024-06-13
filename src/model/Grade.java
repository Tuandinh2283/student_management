/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuandinh
 */
public class Grade {
    private int id;
    private SinhVien sv;
    private  double diemQT, diemTP, diemTB;

    public Grade() {
    }

    public Grade(int id, SinhVien sv, double diemQT, double diemTP, double diemTB) {
        this.id = id;
        this.sv = sv;
        this.diemQT = diemQT;
        this.diemTP = diemTP;
        this.diemTB = diemTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public double getDiemQT() {
        return diemQT;
    }

    public void setDiemQT(double diemQT) {
        this.diemQT = diemQT;
    }

    public double getDiemTP() {
        return diemTP;
    }

    public void setDiemTP(double diemTP) {
        this.diemTP = diemTP;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
    public double getTBC(){
        return (getDiemQT() + getDiemTP() )/2;
    }
    public String getXeploai(){
        String xl = "";
        double tbc = getTBC();
        if(tbc > 4){
            xl = "Do";
        }else {
            xl = "truot";
        }
        return xl;
    }
}
