/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLDanhMuc;

import ConnectingNeo4j.ConnectDB;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
/**
 *
 * @author AVITA
 */
public class DanhMuc {
     private ConnectDB connectDB;

    // Constructor để khởi tạo kết nối Neo4j
    public DanhMuc() {
        connectDB = new ConnectDB();
    }

    // Hàm lấy danh sách danh mục từ Neo4j
    public List<TTDanhMuc> getDanhSachDanhMuc() {
        List<TTDanhMuc> danhSachDanhMuc = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (d:Category) RETURN d.MaDM AS maDM, d.TenDM AS tenDM";
            Result result = session.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTDanhMuc dm = new TTDanhMuc(
                    record.get("maDM").asString(),
                    record.get("tenDM").asString()
                );
                danhSachDanhMuc.add(dm);
            }
        }
        return danhSachDanhMuc;
    }

    // Hàm để thêm danh mục mới vào cơ sở dữ liệu Neo4j
    public boolean themDanhMucMoi(TTDanhMuc dm) {
        String query = "CREATE (d:Category {MaDM: $maDM, TenDM: $tenDM})";
        try (Session session = connectDB.getDriver().session()) {
            session.run(query, 
                org.neo4j.driver.Values.parameters(
                    "maDM", dm.getMaDM(),
                    "tenDM", dm.getTenDM()
                )
            );
            return true; // Thêm danh mục thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Gặp lỗi khi thêm danh mục
        }
    }

    // Hàm để xóa danh mục từ Neo4j
    public boolean xoaDanhMuc(String maDM) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (d:Category {MaDM: $maDM}) DELETE d";
            session.run(query, org.neo4j.driver.Values.parameters("maDM", maDM));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // Hàm sửa thông tin danh mục
    public boolean suaDanhMuc(TTDanhMuc dm) {
        boolean success = false;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (d:Category {MaDM: $maDM}) " +
                           "SET d.TenDM = $tenDM";
            session.run(query, 
                        org.neo4j.driver.Values.parameters(
                            "maDM", dm.getMaDM(),
                            "tenDM", dm.getTenDM()
                        ));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    
    // Hàm tìm kiếm danh mục
    public List<TTDanhMuc> timKiemDanhMuc(String tuKhoa) {
        List<TTDanhMuc> danhSachDanhMuc = new ArrayList<>();
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (d:Category) WHERE d.MaDM CONTAINS $tuKhoa OR d.TenDM CONTAINS $tuKhoa " +
                           "RETURN d.MaDM AS maDM, d.TenDM AS tenDM";
            Result result = session.run(query, org.neo4j.driver.Values.parameters("tuKhoa", tuKhoa));

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                TTDanhMuc dm = new TTDanhMuc(
                    record.get("maDM").asString(),
                    record.get("tenDM").asString()
                );
                danhSachDanhMuc.add(dm);
            }
        }
        return danhSachDanhMuc;
    }

    // Hàm để đóng kết nối sau khi lấy dữ liệu
    public void closeConnection() {
        connectDB.close();
    }
}
