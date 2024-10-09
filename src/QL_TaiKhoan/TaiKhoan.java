package QL_TaiKhoan;

import ConnectingNeo4j.ConnectDB;
import org.neo4j.driver.Session;
import org.neo4j.driver.TransactionWork;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoan {
    private ConnectDB connectDB; // Đối tượng kết nối CSDL
    private List<TTTaiKhoan> danhSachTaiKhoan;

    // Constructor
    public TaiKhoan() {
        connectDB = new ConnectDB(); // Khởi tạo kết nối CSDL
        danhSachTaiKhoan = new ArrayList<>();
        loadTaiKhoan(); // Tải tài khoản từ CSDL
    }

    // Tải tài khoản từ CSDL
    private void loadTaiKhoan() {
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (tk:TaiKhoan) RETURN tk.maTK AS maTK, tk.tenDangNhap AS tenDangNhap, tk.matKhau AS matKhau, tk.quyenHan AS quyenHan";
            session.run(query).forEachRemaining(record -> {
                String maTK = record.get("maTK").asString();
                String tenDangNhap = record.get("tenDangNhap").asString();
                String matKhau = record.get("matKhau").asString();
                String quyenHan = record.get("quyenHan").asString();
                danhSachTaiKhoan.add(new TTTaiKhoan(maTK, tenDangNhap, matKhau, quyenHan));
                // Log thông tin tài khoản đã tải
                System.out.println("Tài khoản được tải: " + tenDangNhap);
            });
        } catch (Exception e) {
            System.err.println("Lỗi khi tải tài khoản: " + e.getMessage());
        }
    }
    
    // In danh sách tài khoản
    public void inDanhSachTaiKhoan() {
        if (danhSachTaiKhoan.isEmpty()) {
            System.out.println("Danh sách tài khoản rỗng");
        } else {
            System.out.println("Số lượng tài khoản: " + danhSachTaiKhoan.size());
            for (TTTaiKhoan tk : danhSachTaiKhoan) {
                System.out.println("Tài khoản: " + tk.getTenDangNhap());
            }
        }
    }

    // Phương thức lấy danh sách tài khoản
    public List<TTTaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    // Phương thức thêm tài khoản
    public void themTaiKhoan(TTTaiKhoan taiKhoan) {
        try (Session session = connectDB.getDriver().session()) {
            String query = "CREATE (tk:TaiKhoan {maTK: $maTK, tenDangNhap: $tenDangNhap, matKhau: $matKhau, quyenHan: $quyenHan})";
            session.run(query, 
                org.neo4j.driver.Values.parameters("maTK", taiKhoan.getMaTK(),
                                                     "tenDangNhap", taiKhoan.getTenDangNhap(),
                                                     "matKhau", taiKhoan.getMatKhau(),
                                                     "quyenHan", taiKhoan.getQuyenHan()));
            danhSachTaiKhoan.add(taiKhoan); // Cập nhật danh sách tài khoản trong bộ nhớ
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm tài khoản: " + e.getMessage());
        }
    }

    // Phương thức sửa tài khoản
    public void suaTaiKhoan(String maTK, String tenDangNhap, String matKhau, String quyenHan) {
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (tk:TaiKhoan {maTK: $maTK}) SET tk.tenDangNhap = $tenDangNhap, tk.matKhau = $matKhau, tk.quyenHan = $quyenHan";
            session.run(query, 
                org.neo4j.driver.Values.parameters("maTK", maTK,
                                                     "tenDangNhap", tenDangNhap,
                                                     "matKhau", matKhau,
                                                     "quyenHan", quyenHan));
            // Cập nhật danh sách tài khoản trong bộ nhớ
            for (TTTaiKhoan taiKhoan : danhSachTaiKhoan) {
                if (taiKhoan.getMaTK().equals(maTK)) {
                    taiKhoan.setTenDangNhap(tenDangNhap);
                    taiKhoan.setMatKhau(matKhau);
                    taiKhoan.setQuyenHan(quyenHan);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi sửa tài khoản: " + e.getMessage());
        }
    }

    // Phương thức xóa tài khoản
    public boolean xoaTaiKhoan(String maTK) {
        for (TTTaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getMaTK().equals(maTK)) {
                danhSachTaiKhoan.remove(tk);
                return true; // Return true if deletion is successful
            }
        }
        return false; // Return false if the account is not found
    }

    
    // Kiểm tra mã tài khoản đã tồn tại
    public boolean kiemTraMaTK(String maTK) {
        for (TTTaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getMaTK().equals(maTK)) {
                return true; // Trả về true nếu tài khoản đã tồn tại
            }
        }
        return false; // Trả về false nếu tài khoản không tồn tại
    }

    // Phương thức trả về danh sách tài khoản
    public List<TTTaiKhoan> getList() {
        return danhSachTaiKhoan; // Trả về danh sách tài khoản
    }

    // Phương thức đóng kết nối CSDL
    public void closeConnection() {
        connectDB.close();
    }
}
