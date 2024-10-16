/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLGiaoHang;

import ConnectingNeo4j.ConnectDB;
import QLGiaoHang.TTGiaoHang;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;
/**
 *
 * @author Le Van
 */
public class GiaoHang {
    private ConnectDB connectDB;
    
    public GiaoHang(){
    connectDB = new ConnectDB();
    }
    public List<TTGiaoHang> getPhieuGiao() {
    List<TTGiaoHang> danhSachPhieuGiao = new ArrayList<>();
    try (Session session = connectDB.getDriver().session()) {
        String query = "MATCH (g:Delivery ) RETURN g.MaGH AS maGH, g.DiaChiGiaoHang AS diaChiGiaoHang, g.NgayGiaoHang AS ngayGiaoHang, g.PhuongThucGiaoHang AS phuongThucGiaoHang, g.TrangThai AS trangThai";
        Result result = session.run(query);
        while (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            TTGiaoHang phieuGiao = new TTGiaoHang(
                record.get("maGH").asString(),
                record.get("diaChiGiaoHang").asString(),
                record.get("ngayGiaoHang").asString(),
                record.get("phuongThucGiaoHang").asString(),
                record.get("trangThai").asString()
            );
            danhSachPhieuGiao.add(phieuGiao);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return danhSachPhieuGiao;
}

    public boolean themGiaoHang(TTGiaoHang giaoHang) {
        if (giaoHang == null || giaoHang.getMaGH() == null || giaoHang.getDiaChiGiaoHang() == null) {
            throw new IllegalArgumentException("Thông tin giao hàng không hợp lệ");
        }

        String query = "CREATE (g:Delivery {MaGH: $maGH, DiaChiGiaoHang: $diaChiGiaoHang, NgayGiaoHang: $ngayGiaoHang, PhuongThucGiaoHang: $phuongThucGiaoHang, TrangThai: $trangThai})";
        try (Session session = connectDB.getDriver().session()) {
            session.run(query, 
                Values.parameters(
                    "maGH", giaoHang.getMaGH(),
                    "diaChiGiaoHang", giaoHang.getDiaChiGiaoHang(),
                    "ngayGiaoHang", giaoHang.getNgayGiaoHang(),
                    "phuongThucGiaoHang", giaoHang.getPhuongThucGiaoHang(),
                    "trangThai", giaoHang.getTrangThai()
                )
            );
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }
    public boolean suaGiaoHang(TTGiaoHang giaoHang) {
        if (giaoHang == null || giaoHang.getMaGH() == null) {
            throw new IllegalArgumentException("Thông tin giao hàng không hợp lệ");
        }

        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (g:Delivery {MaGH: $maGH}) " +
                           "SET g.DiaChiGiaoHang = $diaChiGiaoHang, g.NgayGiaoHang = $ngayGiaoHang, g.PhuongThucGiaoHang = $phuongThucGiaoHang, g.TrangThai = $trangThai";
            session.run(query, 
                Values.parameters(
                    "maGH", giaoHang.getMaGH(),
                    "diaChiGiaoHang", giaoHang.getDiaChiGiaoHang(),
                    "ngayGiaoHang", giaoHang.getNgayGiaoHang(),
                    "phuongThucGiaoHang", giaoHang.getPhuongThucGiaoHang(),
                    "trangThai", giaoHang.getTrangThai()
                ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return success;
    }
    public boolean xoaGiaoHang(String maGH) {
        if (maGH == null || maGH.isEmpty()) {
            throw new IllegalArgumentException("Mã giao hàng không hợp lệ");
        }

        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (g:Delivery {MaGH: $maGH}) DETACH DELETE g";
            session.run(query, Values.parameters("maGH", maGH));
            success = true;
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return success;
    }
     public List<TTGiaoHang> timPhieuGiao(String tuKhoa) {
        List<TTGiaoHang> danhSachPhieuGiao = new ArrayList<>();

        // Kiểm tra tham số đầu vào
        if (tuKhoa == null || tuKhoa.trim().isEmpty()) {
            return danhSachPhieuGiao; // Trả về danh sách rỗng nếu từ khóa không hợp lệ
        }

        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (g:Delivery) WHERE g.MaGH CONTAINS $tuKhoa OR g.DiaChiGiaoHang CONTAINS $tuKhoa " +
                           "RETURN g.MaGH AS maGH, g.DiaChiGiaoHang AS diaChiGiaoHang, g.NgayGiaoHang AS ngayGiaoHang, " +
                           "g.PhuongThucGiaoHang AS phuongThucGiaoHang, g.TrangThai AS trangThai";
            Result result = session.run(query, org.neo4j.driver.Values.parameters("tuKhoa", tuKhoa));

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTGiaoHang phieuGiao = new TTGiaoHang(
                    record.get("maGH").asString(),
                    record.get("diaChiGiaoHang").asString(),
                    record.get("ngayGiaoHang").asString(),
                    record.get("phuongThucGiaoHang").asString(),
                    record.get("trangThai").asString()
                );
                danhSachPhieuGiao.add(phieuGiao);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return danhSachPhieuGiao;
    }
    public void closeConnection() {
        connectDB.close();
    }
}
