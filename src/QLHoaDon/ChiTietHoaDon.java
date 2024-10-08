/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLHoaDon;


import ConnectingNeo4j.ConnectDB;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;
/**
 *
 * @author AVITA
 */
public class ChiTietHoaDon {
    private ConnectDB connectDB;

    // Constructor để khởi tạo kết nối Neo4j
    public ChiTietHoaDon() {
        connectDB = new ConnectDB();
    }

    // Hàm lấy danh sách chi tiết hóa đơn từ Neo4j
    public List<TTChiTietHoaDon> getDanhSachChiTietHoaDon() {
        List<TTChiTietHoaDon> danhSachCTHD = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (cthd:InvoiceDetail) RETURN cthd.MaCTHD AS maCTHD, cthd.SoLuong AS soLuong, cthd.GiaTien AS giaTien";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTChiTietHoaDon cthd = new TTChiTietHoaDon(
                    record.get("maCTHD").asString(),
                    record.get("soLuong").asInt(),
                    record.get("giaTien").asDouble()
                );
                danhSachCTHD.add(cthd);
            }
        }
        return danhSachCTHD;
    }

    // Hàm để thêm chi tiết hóa đơn mới vào cơ sở dữ liệu Neo4j
    public boolean themChiTietHoaDonMoi(TTChiTietHoaDon cthd) {
        String query = "CREATE (cthd:InvoiceDetail {MaCTHD: $maCTHD, SoLuong: $soLuong, GiaTien: $giaTien})";
        try (Session session = connectDB.getDriver().session()) {
            session.run(query, 
                org.neo4j.driver.Values.parameters(
                    "maCTHD", cthd.getMaCTHD(),
                    "soLuong", cthd.getSoLuong(),
                    "giaTien", cthd.getGiaTien()
                )
            );
            return true; // Thêm chi tiết hóa đơn thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Gặp lỗi khi thêm chi tiết hóa đơn
        }
    }
    // Hàm để xóa chi tiết hóa đơn từ Neo4j
    public boolean xoaChiTietHoaDon(String maCTHD) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            // Sử dụng DETACH DELETE để xóa nút cùng với các mối quan hệ của nó
            String query = "MATCH (cthd:InvoiceDetail {MaCTHD: $maCTHD}) DETACH DELETE cthd";
            session.run(query, Values.parameters("maCTHD", maCTHD));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    // Hàm để sửa thông tin chi tiết hóa đơn
    public boolean suaChiTietHoaDon(TTChiTietHoaDon cthd) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (cthd:InvoiceDetail {MaCTHD: $maCTHD}) " +
                           "SET cthd.SoLuong = $soLuong, cthd.GiaTien = $giaTien";
            session.run(query, 
                        Values.parameters(
                            "maCTHD", cthd.getMaCTHD(),
                            "soLuong", cthd.getSoLuong(),
                            "giaTien", cthd.getGiaTien()
                        ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    // Hàm để tìm kiếm chi tiết hóa đơn
    public List<TTChiTietHoaDon> timKiemChiTietHoaDon(String tuKhoa) {
        List<TTChiTietHoaDon> danhSachCTHD = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            // Truy vấn tìm kiếm chi tiết hóa đơn dựa trên MaCTHD
            String query = "MATCH (cthd:InvoiceDetail) " +
                           "WHERE cthd.MaCTHD CONTAINS $tuKhoa " + // Tìm kiếm theo mã chi tiết hóa đơn
                           "RETURN cthd.MaCTHD AS maCTHD, cthd.SoLuong AS soLuong, cthd.GiaTien AS giaTien";
            Result result = session.run(query, Values.parameters("tuKhoa", tuKhoa));

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTChiTietHoaDon cthd = new TTChiTietHoaDon(
                    record.get("maCTHD").asString(),
                    record.get("soLuong").asInt(),
                    record.get("giaTien").asDouble()
                );
                danhSachCTHD.add(cthd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachCTHD;
    }
     // Hàm để đóng kết nối sau khi lấy dữ liệu
    public void closeConnection() {
        connectDB.close();
    }
}
