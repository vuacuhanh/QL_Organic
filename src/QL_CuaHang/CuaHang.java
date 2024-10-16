package QL_CuaHang;

import ConnectingNeo4j.ConnectDB;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CuaHang {
    private ConnectDB connectDB;

    // Constructor to initialize Neo4j connection
    public CuaHang() {
        connectDB = new ConnectDB();
    }

    // Method to retrieve the list of stores from Neo4j
    public List<TTCuaHang> getDanhSachCuaHang() {
        List<TTCuaHang> danhSachCuaHang = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc";
            Result result = session.run(query);

            while (result.hasNext()) {
                var record = result.next();
                TTCuaHang ch = new TTCuaHang(
                    record.get("maCH").asString(),
                    record.get("tenCH").asString(),
                    record.get("diaChi").asString(),
                    record.get("email").asString(),
                    record.get("sdt").asString(),
                    record.get("maKhuVuc").asString()
                );
                danhSachCuaHang.add(ch);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving store list: " + e.getMessage());
        }
        return danhSachCuaHang;
    }

    // Method to add a new store
    public boolean themCuaHangMoi(TTCuaHang ch) {
        if (getCuaHangByMa(ch.getMaCH()) != null) {
            return false; // Store already exists
        }

        String query = "CREATE (c:Store {MaCH: $maCH, TenCH: $tenCH, DiaChi: $diaChi, Email: $email, SDT: $sdt, MaKhuVuc: $maKhuVuc})";
        try (Session session = connectDB.getDriver().session()) {
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
            System.err.println("Error adding store: " + e.getMessage());
            return false;
        }
    }

    // Method to get a store by its ID
    public TTCuaHang getCuaHangByMa(String maCH) {
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaCH: $maCH}) RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc";
            Result result = session.run(query, org.neo4j.driver.Values.parameters("maCH", maCH));
            if (result.hasNext()) {
                var record = result.next();
                return new TTCuaHang(
                    record.get("maCH").asString(),
                    record.get("tenCH").asString(),
                    record.get("diaChi").asString(),
                    record.get("email").asString(),
                    record.get("sdt").asString(),
                    record.get("maKhuVuc").asString()
                );
            }
        } catch (Exception e) {
            System.err.println("Error retrieving store by ID: " + e.getMessage());
        }
        return null; // Return null if the store is not found
    }

    // Method to delete a store from Neo4j
    public boolean xoaCuaHang(String maCH) {
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaCH: $maCH}) DELETE c";
            session.run(query, org.neo4j.driver.Values.parameters("maCH", maCH));
            return true; // Successfully deleted
        } catch (Exception e) {
            System.err.println("Error deleting store: " + e.getMessage());
            return false;
        }
    }

    // Method to update store information
    public boolean suaCuaHang(String maCH2, TTCuaHang ch) {
        if (!ch.isValid()) {
            System.out.println("Invalid store data");
            return false;
        }

        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaCH: $maCH2}) " +
                           "SET c.TenCH = $tenCH, c.DiaChi = $diaChi, c.Email = $email, c.SDT = $sdt, c.MaKhuVuc = $maKhuVuc";
            session.run(query,
                org.neo4j.driver.Values.parameters(
                    "maCH2", maCH2,
                    "tenCH", ch.getTenCH(),
                    "diaChi", ch.getDiaChi(),
                    "email", ch.getEmail(),
                    "sdt", ch.getSDT(),
                    "maKhuVuc", ch.getMaKhuVuc()
                ));
            return true; // Successfully updated
        } catch (Exception e) {
            System.err.println("Error updating store: " + e.getMessage());
            return false;
        }
    }

    // Method to search for stores
    public List<TTCuaHang> timKiemCuaHang(String tuKhoa) {
        List<TTCuaHang> danhSachCuaHang = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) WHERE c.MaCH CONTAINS $tuKhoa OR c.TenCH CONTAINS $tuKhoa " +
                           "RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc";
            Result result = session.run(query, org.neo4j.driver.Values.parameters("tuKhoa", tuKhoa));

            while (result.hasNext()) {
                var record = result.next();
                TTCuaHang ch = new TTCuaHang(
                    record.get("maCH").asString(),
                    record.get("tenCH").asString(),
                    record.get("diaChi").asString(),
                    record.get("email").asString(),
                    record.get("sdt").asString(),
                    record.get("maKhuVuc").asString()
                );
                danhSachCuaHang.add(ch);
            }
        } catch (Exception e) {
            System.err.println("Error searching for stores: " + e.getMessage());
        }
        return danhSachCuaHang;
    }
 // Method to retrieve stores by area code
    public List<TTCuaHang> getCuaHangByKhuVuc(String maKhuVuc) {
        List<TTCuaHang> danhSachCuaHang = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store {MaKhuVuc: $maKhuVuc}) RETURN c.MaCH AS maCH, c.TenCH AS tenCH, c.DiaChi AS diaChi, c.Email AS email, c.SDT AS sdt, c.MaKhuVuc AS maKhuVuc";
            Result result = session.run(query, org.neo4j.driver.Values.parameters("maKhuVuc", maKhuVuc));

            while (result.hasNext()) {
                var record = result.next();
                TTCuaHang ch = new TTCuaHang(
                    record.get("maCH").asString(),
                    record.get("tenCH").asString(),
                    record.get("diaChi").asString(),
                    record.get("email").asString(),
                    record.get("sdt").asString(),
                    record.get("maKhuVuc").asString()
                );
                danhSachCuaHang.add(ch);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving stores by area: " + e.getMessage());
        }
        return danhSachCuaHang;
    }

    // Method to count total number of stores
    public int countCuaHang() {
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (c:Store) RETURN count(c) AS total";
            Result result = session.run(query);
            if (result.hasNext()) {
                return result.next().get("total").asInt();
            }
        } catch (Exception e) {
            System.err.println("Error counting stores: " + e.getMessage());
        }
        return 0;
    }

    
}
