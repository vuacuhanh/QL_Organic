/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLDanhMuc;

/**
 *
 * @author AVITA
 */
public class TTDanhMuc {
    private String maDM;   // Mã danh mục
    private String tenDM;  // Tên danh mục

    // Constructor không tham số
    public TTDanhMuc() {}

    // Constructor có tham số
    public TTDanhMuc(String maDM, String tenDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
    }

    // Getter và Setter cho các thuộc tính
    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    // Phương thức để hiển thị thông tin danh mục
    @Override
    public String toString() {
        return "Mã DM: " + maDM + ", Tên DM: " + tenDM;
    }
}
