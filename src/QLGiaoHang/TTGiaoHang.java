/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLGiaoHang;

/**
 *
 * @author Le Van
 */
public class TTGiaoHang {
    protected String maGH;                
    protected String diaChiGiaoHang;      
    protected String ngayGiaoHang;         
    protected String phuongThucGiaoHang;  
    protected String trangThai;            

    public TTGiaoHang(String maGH, String diaChiGiaoHang, String ngayGiaoHang, String phuongThucGiaoHang, String trangThai) {
        this.maGH = maGH;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.phuongThucGiaoHang = phuongThucGiaoHang;
        this.trangThai = trangThai;
    }
    
    public TTGiaoHang() {
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(String ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getPhuongThucGiaoHang() {
        return phuongThucGiaoHang;
    }

    public void setPhuongThucGiaoHang(String phuongThucGiaoHang) {
        this.phuongThucGiaoHang = phuongThucGiaoHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    @Override
    public String toString() {
        return "Mã GH: " + maGH + ", Địa chỉ giao hàng: " + diaChiGiaoHang + ", Ngày giao hàng: " + ngayGiaoHang + ", Phương thức: " + phuongThucGiaoHang + ", Trạng thái: " + trangThai;
    }
}


