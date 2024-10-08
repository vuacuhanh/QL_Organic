/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLHoaDon;

/**
 *
 * @author AVITA
 */
public class TTHoaDon {
    protected String maHD;        // Mã hóa đơn
    protected String ngayLap;     // Ngày lập hóa đơn
    protected double tongTien;    // Tổng tiền của hóa đơn

    // Constructor không tham số
    public TTHoaDon() {}

    // Constructor có tham số
    public TTHoaDon(String maHD, String ngayLap, double tongTien) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    // Getter và Setter cho các thuộc tính
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    // Phương thức hiển thị thông tin hóa đơn
    @Override
    public String toString() {
        return "Mã HD: " + maHD + ", Ngày lập: " + ngayLap + ", Tổng tiền: " + tongTien;
    }
}
