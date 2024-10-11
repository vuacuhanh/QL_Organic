/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLHoaDon;

/**
 *
 * @author AVITA
 */
public class TTChiTietHoaDon {
    protected String maCTHD;    // Mã chi tiết hóa đơn
    protected int soLuong;      // Số lượng sản phẩm
    protected double giaTien;   // Giá tiền mỗi sản phẩm

    // Constructor không tham số
    public TTChiTietHoaDon() {}

    // Constructor có tham số
    public TTChiTietHoaDon(String maCTHD, int soLuong, double giaTien) {
        this.maCTHD = maCTHD;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    // Getter và Setter cho các thuộc tính
    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    // Phương thức hiển thị thông tin chi tiết hóa đơn
    @Override
    public String toString() {
        return "Mã CTHD: " + maCTHD + ", Số lượng: " + soLuong + ", Giá tiền: " + giaTien;
    }
}