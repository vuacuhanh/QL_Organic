/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import ConnectingNeo4j.ConnectDB;
import static io.netty.util.internal.SocketUtils.connect;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 *
 * @author User
 */
public class TKmodify {
    private final ConnectDB connectDB; // Đối tượng kết nối

    public TKmodify(ConnectDB connectDB) {
        this.connectDB = connectDB; // Khởi tạo đối tượng kết nối
    }

    public TaiKhoan login(String tdn, String mk) throws Exception {
        String query = "MATCH (t:Account {TenDangNhap: $tenDangNhap, MatKhau: $matKhau}) RETURN t";
        try (Session session = connectDB.getDriver().session()) {
            Result result = session.run(query, 
                org.neo4j.driver.Values.parameters("tenDangNhap", tdn, "matKhau", mk));
            if (result.hasNext()) {
                // Lấy tài khoản thành công
                var record = result.next().get("t").asNode();
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(record.get("MaTK").asString());
                tk.setTenDangNhap(record.get("TenDangNhap").asString()); // Cập nhật tên thuộc tính
                tk.setMatKhau(record.get("MatKhau").asString());
                return tk;
            }
        }
        return null; // Không tìm thấy tài khoản
    }

    // Phương thức tìm tài khoản theo mã tài khoản
    public TaiKhoan find(String maTK) throws Exception {
        String query = "MATCH (t:Account {MaTK: $maTK}) RETURN t";
        try (Session session = connectDB.getDriver().session()) {
            Result result = session.run(query, org.neo4j.driver.Values.parameters("maTK", maTK));
            if (result.hasNext()) {
                var record = result.next().get("t").asNode();
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(record.get("MaTK").asString());
                tk.setTenDangNhap(record.get("TenDangNhap").asString()); // Cập nhật tên thuộc tính
                tk.setMatKhau(record.get("MatKhau").asString());
                return tk;
            }
        }
        return null;
    }

    // Phương thức xóa tài khoản
    public boolean deleteTK(String maTK) throws Exception {
        String query = "MATCH (t:Account {MaTK: $maTK}) DELETE t";
        try (Session session = connectDB.getDriver().session()) {
            return session.run(query, org.neo4j.driver.Values.parameters("maTK", maTK)).consume().counters().nodesDeleted() > 0;
        }
    }

    // Phương thức chèn tài khoản
    public boolean insertTK(TaiKhoan tk) throws Exception {
        String query = "CREATE (t:Account {MaTK: $maTK, TenDangNhap: $tenDangNhap, MatKhau: $matKhau})";
        try (Session session = connectDB.getDriver().session()) {
            return session.run(query, org.neo4j.driver.Values.parameters(
                "maTK", tk.getMaTK(),
                "tenDangNhap", tk.getTenDangNhap(), // Cập nhật tên thuộc tính
                "matKhau", tk.getMatKhau())).consume().counters().nodesCreated() > 0;
        }
    }
}
