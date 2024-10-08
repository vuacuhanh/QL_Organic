/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLHoaDon;

import ConnectingNeo4j.ConnectDB;
import java.util.ArrayList;
import java.util.List;
import static org.neo4j.driver.GraphDatabase.driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;
/**
 *
 * @author AVITA
 */
public class HoaDon {
    private ConnectDB connectDB;

    // Constructor để khởi tạo kết nối Neo4j
    public HoaDon() {
        connectDB = new ConnectDB();
    }

    // Hàm lấy danh sách hóa đơn từ Neo4j
    public List<TTHoaDon> getDanhSachHoaDon() {
        List<TTHoaDon> danhSachHoaDon = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (inv:Invoice) RETURN inv.MaHD AS maHD, inv.NgayLap AS ngayLap, inv.TongTien AS tongTien";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTHoaDon inv = new TTHoaDon(
                    record.get("maHD").asString(),
                    record.get("ngayLap").asString(),
                    record.get("tongTien").asDouble()
                );
                danhSachHoaDon.add(inv);
            }
        }
        return danhSachHoaDon;
    }

    // Hàm để thêm hóa đơn mới vào cơ sở dữ liệu Neo4j
    public boolean themHoaDonMoi(TTHoaDon inv) {
        String query = "CREATE (inv:Invoice {MaHD: $maHD, NgayLap: $ngayLap, TongTien: $tongTien})";
        try (Session session = connectDB.getDriver().session()) {
            session.run(query, 
                org.neo4j.driver.Values.parameters(
                    "maHD", inv.getMaHD(),
                    "ngayLap", inv.getNgayLap(),
                    "tongTien", inv.getTongTien()
                )
            );
            return true; // Thêm hóa đơn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Gặp lỗi khi thêm hóa đơn
        }
    }

    // Hàm để xóa hóa đơn từ Neo4j
   public boolean xoaHoaDon(String maHD) {
    boolean success = false;
    try (Session session = connectDB.getDriver().session()) {
        // Sử dụng DETACH DELETE để xóa nút cùng với các mối quan hệ của nó
        String query = "MATCH (inv:Invoice {MaHD: $maHD}) DETACH DELETE inv";
        session.run(query, org.neo4j.driver.Values.parameters("maHD", maHD));
        success = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return success;
}
    // Hàm sửa thông tin hóa đơn
    public boolean suaHoaDon(TTHoaDon inv) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (inv:Invoice {MaHD: $maHD}) " +
                           "SET inv.NgayLap = $ngayLap, inv.TongTien = $tongTien";
            session.run(query, 
                        org.neo4j.driver.Values.parameters(
                            "maHD", inv.getMaHD(),
                            "ngayLap", inv.getNgayLap(),
                            "tongTien", inv.getTongTien()
                        ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
   
    public List<TTHoaDon> timKiemHoaDon(String tuKhoa) {
    List<TTHoaDon> danhSachHoaDon = new ArrayList<>();
    try (Session session = connectDB.getDriver().session()) {
        // Truy vấn tìm kiếm hóa đơn dựa trên MaHD
        String query = "MATCH (h:Invoice) " +
                       "WHERE h.MaHD CONTAINS $tuKhoa " + // Tìm kiếm theo mã hóa đơn
                       "RETURN h.MaHD AS maHD, h.NgayLap AS ngayLap, h.TongTien AS tongTien";
        Result result = session.run(query, Values.parameters("tuKhoa", tuKhoa));

        while (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            TTHoaDon hoaDon = new TTHoaDon(
                record.get("maHD").asString(),
                record.get("ngayLap").asString(),
                record.get("tongTien").asDouble()
            );
            danhSachHoaDon.add(hoaDon);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return danhSachHoaDon;
}



    // Hàm để đóng kết nối sau khi lấy dữ liệu
    public void closeConnection() {
        connectDB.close();
    }
}
