/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKhachHang;

import java.util.Date;

/**
 *
 * @author User
 */
public class TTKhachHang {
   protected String MaKH, TenKH, GioiTinh, SDT, DiaChi, SoThich;
   protected int SoLuongMua;
   protected boolean  VIP_Status;
   protected Date NgayDangKy;

    public TTKhachHang() {
    }

    public TTKhachHang(String MaKH, String TenKH, String GioiTinh, String SDT, String DiaChi, String SoThich, int SoLuongMua, boolean VIP_Status, Date NgayDangKy) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.SoThich = SoThich;
        this.SoLuongMua = SoLuongMua;
        this.VIP_Status = VIP_Status;
        this.NgayDangKy = NgayDangKy;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoThich() {
        return SoThich;
    }

    public void setSoThich(String SoThich) {
        this.SoThich = SoThich;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int SoLuongMua) {
        this.SoLuongMua = SoLuongMua;
    }

    public boolean isVIP_Status() {
        return VIP_Status;
    }

    public void setVIP_Status(boolean VIP_Status) {
        this.VIP_Status = VIP_Status;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }
   
   
}
