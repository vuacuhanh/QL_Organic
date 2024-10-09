package QL_CuaHang;

public class TTCuaHang {
    private String maCH;
    private String tenCH;
    private String diaChi;
    private String email;
    private String sdt;
    private String maKhuVuc;

    // Constructor
    public TTCuaHang(String maCH, String tenCH, String diaChi, String email, String sdt, String maKhuVuc) {
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.maKhuVuc = maKhuVuc;
    }

    // Getters
    public String getMaCH() {
        return maCH;
    }

    public String getTenCH() {
        return tenCH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getSDT() {
        return sdt;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    // Setters
    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    @Override
    public String toString() {
        return String.format("Mã CH: %s, Tên CH: %s, Địa Chỉ: %s, Email: %s, Số Điện Thoại: %s, Mã Khu Vực: %s",
                             maCH, tenCH, diaChi, email, sdt, maKhuVuc);
    }

    // Phương thức để kiểm tra tính hợp lệ
    public boolean isValid() {
        return maCH != null && !maCH.isEmpty() &&
               tenCH != null && !tenCH.isEmpty() &&
               email != null && !email.isEmpty() && isValidEmail(email) &&
               sdt != null && !sdt.isEmpty() && isValidPhoneNumber(sdt);
    }

    // Phương thức kiểm tra tính hợp lệ của email
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$"); // Một mẫu đơn giản cho email
    }
    
    // Phương thức kiểm tra tính hợp lệ của số điện thoại
    private boolean isValidPhoneNumber(String sdt) {
        return sdt.matches("^(\\+\\d{1,3}[- ]?)?\\d{10}$"); // Mẫu đơn giản cho số điện thoại
    }
}
