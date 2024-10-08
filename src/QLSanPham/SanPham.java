/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSanPham;

import ConnectingNeo4j.ConnectDB;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 *
 * @author AnnKiz
 */
public class SanPham {
        private ConnectDB connectDB;

        // Constructor để khởi tạo kết nối Neo4j
    public SanPham() {
        connectDB = new ConnectDB();
    }

    // Hàm lấy danh sách sản phẩm từ Neo4j
    public List<TTSanPham> getDanhSachSanPham() {
        List<TTSanPham> danhSachSanPham = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (p:Product) RETURN p.MaSP AS maSP, p.TenSP AS tenSP, p.GiaTien AS giaTien, p.MoTa AS moTa, p.DonViTinh AS donViTinh, p.XuatXu AS xuatXu, p.SoLuongTonKho AS soLuongTonKho";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTSanPham sp = new TTSanPham(
                    record.get("maSP").asString(),
                    record.get("tenSP").asString(),
                    record.get("giaTien").asDouble(),
                    record.get("moTa").asString(),
                    record.get("donViTinh").asString(),
                    record.get("xuatXu").asString(),
                    record.get("soLuongTonKho").asInt()
                );
                danhSachSanPham.add(sp);
            }
        }
        return danhSachSanPham;
    }
    
// Hàm để thêm sản phẩm mới vào cơ sở dữ liệu Neo4j
    public boolean themSanPhamMoi(TTSanPham sp) {
        String query = "CREATE (p:Product {MaSP: $maSP, TenSP: $tenSP, GiaTien: $giaTien, MoTa: $moTa, DonViTinh: $donViTinh, XuatXu: $xuatXu, SoLuongTonKho: $soLuongTonKho})";
        try (Session session = connectDB.getDriver().session()) {
            session.run(query, 
                org.neo4j.driver.Values.parameters(
                    "maSP", sp.getMaSP(),
                    "tenSP", sp.getTenSP(),
                    "giaTien", sp.getGiaTien(),
                    "moTa", sp.getMoTa(),
                    "donViTinh", sp.getDonViTinh(),
                    "xuatXu", sp.getXuatXu(),
                    "soLuongTonKho", sp.getSoLuongTonKho()
                )
            );
            return true; // Thêm sản phẩm thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Gặp lỗi khi thêm sản phẩm
        }
    }
    
     // Hàm để xóa sản phẩm từ Neo4j
    public boolean xoaSanPham(String maSP) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (p:Product {MaSP: $maSP}) DELETE p";
            session.run(query, org.neo4j.driver.Values.parameters("maSP", maSP));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    
      // Hàm sửa thông tin sản phẩm
    public boolean suaSanPham(TTSanPham sp) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (p:Product {MaSP: $maSP}) " +
                           "SET p.TenSP = $tenSP, p.GiaTien = $giaTien, p.MoTa = $moTa, p.DonViTinh = $donViTinh, p.XuatXu = $xuatXu, p.SoLuongTonKho = $soLuongTonKho";
            session.run(query, 
                        org.neo4j.driver.Values.parameters(
                            "maSP", sp.getMaSP(),
                            "tenSP", sp.getTenSP(),
                            "giaTien", sp.getGiaTien(),
                            "moTa", sp.getMoTa(),
                            "donViTinh", sp.getDonViTinh(),
                            "xuatXu", sp.getXuatXu(),
                            "soLuongTonKho", sp.getSoLuongTonKho()
                        ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    
    // Hàm tìm kiếm sản phẩm trong class SanPham
public List<TTSanPham> timKiemSanPham(String tuKhoa) {
    List<TTSanPham> danhSachSanPham = new ArrayList<>();
    try (Session session = connectDB.getDriver().session()) {
        String query = "MATCH (p:Product) WHERE p.MaSP CONTAINS $tuKhoa OR p.TenSP CONTAINS $tuKhoa " +
                       "RETURN p.MaSP AS maSP, p.TenSP AS tenSP, p.GiaTien AS giaTien, " +
                       "p.MoTa AS moTa, p.DonViTinh AS donViTinh, p.XuatXu AS xuatXu, p.SoLuongTonKho AS soLuongTonKho";
        Result result = session.run(query, org.neo4j.driver.Values.parameters("tuKhoa", tuKhoa));

        while (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            TTSanPham sp = new TTSanPham(
                record.get("maSP").asString(),
                record.get("tenSP").asString(),
                record.get("giaTien").asDouble(),
                record.get("moTa").asString(),
                record.get("donViTinh").asString(),
                record.get("xuatXu").asString(),
                record.get("soLuongTonKho").asInt()
            );
            danhSachSanPham.add(sp);
        }
    }
    return danhSachSanPham;
}

    
    // Hàm để đóng kết nối sau khi lấy dữ liệu
    public void closeConnection() {
        connectDB.close();
    }
}
