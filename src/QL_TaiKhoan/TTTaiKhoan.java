package QL_TaiKhoan;

public class TTTaiKhoan {
    private String maTK;        // Mã tài khoản
    private String tenDangNhap; // Tên đăng nhập
    private String matKhau;     // Mật khẩu
    private String quyenHan;    // Quyền hạn

    // Constructor
    public TTTaiKhoan(String maTK, String tenDangNhap, String matKhau, String quyenHan) {
        this.maTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau; // Nên mã hóa mật khẩu trước khi lưu
        this.quyenHan = quyenHan;
    }

    // Getter methods
    public String getMaTK() {
        return maTK;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau; // Nên hạn chế việc truy cập trực tiếp mật khẩu
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    // Setter methods
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau; // Nên mã hóa mật khẩu trước khi lưu
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    // Phương thức toString để dễ dàng in thông tin tài khoản
    @Override
    public String toString() {
        return "TTTaiKhoan{" +
                "maTK='" + maTK + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", quyenHan='" + quyenHan + '\'' +
                '}';
    }
}
