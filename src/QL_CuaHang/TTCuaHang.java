package QL_CuaHang;

public class TTCuaHang {
    private String maCH;       // Store ID
    private String tenCH;      // Store Name
    private String diaChi;     // Address
    private String email;      // Email
    private String sdt;        // Phone Number
    private String maKhuVuc;   // Area Code

    // Constructor
    public TTCuaHang(String maCH, String tenCH, String diaChi, String email, String sdt, String maKhuVuc) {
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.maKhuVuc = maKhuVuc;
    }

    // Getters and Setters
    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCH() {
        return tenCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    // Method to validate store data (example)
    public boolean isValid() {
        return maCH != null && !maCH.isEmpty() && tenCH != null && !tenCH.isEmpty();
    }
}
