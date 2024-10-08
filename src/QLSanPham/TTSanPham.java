/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSanPham;

/**
 *
 * @author AnnKiz
 */
public class TTSanPham {
       private String maSP;          // Mã sản phẩm
    private String tenSP;         // Tên sản phẩm
    private double giaTien;       // Giá tiền của sản phẩm
    private String moTa;          // Mô tả sản phẩm
    private String donViTinh;     // Đơn vị tính của sản phẩm
    private String xuatXu;        // Xuất xứ của sản phẩm
    private int soLuongTonKho;    // Số lượng tồn kho của sản phẩm
    
    // Constructor không tham số
    public TTSanPham() {}

    // Constructor với tham số
    public TTSanPham(String maSP, String tenSP, double giaTien, String moTa, String donViTinh, String xuatXu, int soLuongTonKho) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.donViTinh = donViTinh;
        this.xuatXu = xuatXu;
        this.soLuongTonKho = soLuongTonKho;
    }

    // Getter và Setter cho các thuộc tính
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    // Phương thức để hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return "Mã SP: " + maSP + ", Tên SP: " + tenSP + ", Giá: " + giaTien + 
               ", Mô tả: " + moTa + ", Đơn vị tính: " + donViTinh + 
               ", Xuất xứ: " + xuatXu + ", Số lượng tồn kho: " + soLuongTonKho;
    }
}
