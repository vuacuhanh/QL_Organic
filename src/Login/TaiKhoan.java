/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author User
 */
public class TaiKhoan {
    private String MaTK;
    private String TenDangNhap;
    private String MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaTK, String TenDangNhap, String MatKhau) {
        this.MaTK = MaTK;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    
}
