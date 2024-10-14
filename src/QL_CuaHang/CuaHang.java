package QL_CuaHang;

import QL_CuaHang.TTCuaHang;
import ConnectingNeo4j.ConnectDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

@SuppressWarnings("unused")
public class CuaHang {

    private String maCH;
    private String tenCH;
    private String diaChi;
    private String email;
    private String sdt;
    private String maKhuVuc;

    // Constructor
    public CuaHang(String maCH, String tenCH, String diaChi, String email, String sdt, String maKhuVuc) {
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.maKhuVuc = maKhuVuc;
    }

    // Getter methods
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

    // Setter methods (if needed)
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

    private ConnectDB connectDB;

    // Constructor to initialize Neo4j connection
    public CuaHang() {
        connectDB = new ConnectDB();
    }

    // Method to retrieve the list of stores from Neo4j
    public List<TTCuaHang> getDanhSachCuaHang() {
        List<TTCuaHang> danhSachCuaHang = new ArrayList<>();
        Set<String> maCuaHangSet = new HashSet<>(); // Use a Set to avoid duplicates
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                String maCH = record.get("maCH").asString();

                // Check for duplicates before adding
                if (maCuaHangSet.add(maCH)) { // If maCH was not already in the Set, add it
                    TTCuaHang ch = new TTCuaHang(
                        maCH,
                        record.get("tenCH").asString(),
                        record.get("diaChi").asString(),
                        record.get("email").asString(),
                        record.get("sdt").asString(),
                        record.get("maKhuVuc").asString()
                    );
                    danhSachCuaHang.add(ch);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger
        }
        return danhSachCuaHang;
    }

    // Sample enhanced method for adding a new store
    public boolean themCuaHangMoi(TTCuaHang ch) {
        if (!ch.isValid()) {
            System.out.println("Invalid store data"); // Consider logging instead
            return false; 
        }

        // Kiểm tra xem cửa hàng đã tồn tại hay chưa
        String checkQuery = "MATCH (c:Store {MaCH: $maCH}) RETURN c";
        try (Session session = connectDB.getDriver().session()) {
            var result = session.run(checkQuery, org.neo4j.driver.Values.parameters("maCH", ch.getMaCH()));
            if (result.hasNext()) {
                System.out.println("Store with this ID already exists.");
                return false; // Cửa hàng đã tồn tại
            }

            String query = "CREATE (c:Store {MaCH: $maCH, TenCH: $tenCH, DiaChi: $diaChi, Email: $email, SDT: $sdt, MaKhuVuc: $maKhuVuc})";
            session.run(query, org.neo4j.driver.Values.parameters(
                "maCH", ch.getMaCH(),
                "tenCH", ch.getTenCH(),
                "diaChi", ch.getDiaChi(),
                "email", ch.getEmail(),
                "sdt", ch.getSDT(),
                "maKhuVuc", ch.getMaKhuVuc()
            ));
            return true; // Store added successfully
        } catch (Exception e) {
            // Use a logging framework instead of e.printStackTrace()
            System.err.println("Error adding store: " + e.getMessage());
            return false; // Error occurred while adding store
        }
    }

    // Method to delete a store from Neo4j
    public boolean xoaCuaHang(String maCH) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaCH: $maCH}) DELETE c";
            session.run(query, org.neo4j.driver.Values.parameters("maCH", maCH));
            success = true;
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger
        }
        return success;
    }

    // Method to update store information
    public boolean suaCuaHang(String maCH2, TTCuaHang ch) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaCH: $maCH}) " +
                           "SET c.TenCH = $tenCH, c.DiaChi = $diaChi, c.Email = $email, c.SDT = $sdt, c.MaKhuVuc = $maKhuVuc"; // Update to include additional fields
            session.run(query,
                        org.neo4j.driver.Values.parameters(
                            "maCH", ch.getMaCH(),
                            "tenCH", ch.getTenCH(),
                            "diaChi", ch.getDiaChi(),
                            "email", ch.getEmail(),
                            "sdt", ch.getSDT(),
                            "maKhuVuc", ch.getMaKhuVuc() // Include area code
                        ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger
        }
        return success;
    }

    // Method to search for stores
    public List<TTCuaHang> timKiemCuaHang(String tuKhoa) {
        List<TTCuaHang> danhSachCuaHang = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) WHERE c.MaCH CONTAINS $tuKhoa OR c.TenCH CONTAINS $tuKhoa " +
                           "RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc"; // Update to include additional fields
            Result result = session.run(query, org.neo4j.driver.Values.parameters("tuKhoa", tuKhoa));

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTCuaHang ch = new TTCuaHang(
                    record.get("maCH").asString(),
                    record.get("tenCH").asString(),
                    record.get("diaChi").asString(),
                    record.get("email").asString(),
                    record.get("sdt").asString(),
                    record.get("maKhuVuc").asString() // Include area code
                );
                danhSachCuaHang.add(ch);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger
        }
        return danhSachCuaHang;
    }
    
    public Map<String, Integer> thongKeSoLuongCuaHangTheoKhuVuc() {
        Map<String, Integer> storeCountByArea = new HashMap<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) RETURN c.MaKhuVuc AS maKhuVuc, COUNT(c) AS count";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                String maKhuVuc = record.get("maKhuVuc").asString();
                int count = record.get("count").asInt();
                storeCountByArea.put(maKhuVuc, count); // Lưu trữ số lượng cửa hàng theo khu vực
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xem xét sử dụng logger
        }
        return storeCountByArea;
    }


    // Method to close connection
    public void closeConnection() {
        connectDB.close();
    }
}
