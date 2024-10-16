/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLThongKe;

import ConnectingNeo4j.ConnectDB;
import QLSanPham.TTSanPham;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;

/**
 *
 * @author AnnKiz
 */
public class ThongKe {
    private ConnectDB connectDB;

    // Constructor để khởi tạo kết nối Neo4j
    public ThongKe() {
        connectDB = new ConnectDB();
    }

    // Hàm lấy tổng số lượng sản phẩm
    public int getTongSoSanPham() {
        int tongSanPham = 0;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (p:Product) RETURN count(p) AS tongSanPham";
            Result result = session.run(query);

            if (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                tongSanPham = record.get("tongSanPham").asInt();
            }
        }
        return tongSanPham;
    }

    // Hàm lấy tổng số lượng danh mục
    public int getTongSoDanhMuc() {
        int tongDanhMuc = 0;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (d:Category) RETURN count(d) AS tongDanhMuc";
            Result result = session.run(query);

            if (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                tongDanhMuc = record.get("tongDanhMuc").asInt();
            }
        }
        return tongDanhMuc;
    }

    // Hàm lấy tổng số lượng khách hàng
    public int getTongSoKhachHang() {
        int tongKhachHang = 0;
        try (Session session = connectDB.getDriver().session()) {
            String query = "MATCH (k:Customer) RETURN count(k) AS tongKhachHang";
            Result result = session.run(query);

            if (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                tongKhachHang = record.get("tongKhachHang").asInt();
            }
        }
        return tongKhachHang;
    }
 // Hàm tính tổng doanh thu theo tháng và năm
  public double getDoanhThuTheoThangNam(int thang, int nam) {
        double doanhThu = 0.0;

        try (Session session = connectDB.getDriver().session()) {
            // Truy vấn tổng doanh thu theo tháng và năm
            String query = "MATCH (inv:Invoice) " +
                           "WHERE inv.NgayLap CONTAINS $thang AND inv.NgayLap CONTAINS $nam " +
                           "RETURN SUM(inv.TongTien) AS doanhThu";
            Result result = session.run(query, Values.parameters("thang", String.format("-%02d-", thang), "nam", String.valueOf(nam)));

            // Lấy doanh thu
            if (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                doanhThu = record.get("doanhThu").asDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doanhThu;
    }
  
public double getDoanhThuTheoNam(int nam) {
    double doanhThu = 0.0;

    try (Session session = connectDB.getDriver().session()) {
        // Truy vấn tổng doanh thu theo năm
        String query = "MATCH (inv:Invoice) " +
                       "WHERE date(inv.NgayLap).year = $nam " +  // Sử dụng date() để lấy năm từ ngày
                       "RETURN SUM(inv.TongTien) AS doanhThu";   // Tính tổng doanh thu

        Result result = session.run(query, Values.parameters("nam", nam));  // Truyền tham số năm

        // Lấy doanh thu
        if (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            doanhThu = record.get("doanhThu").asDouble();  // Lấy tổng doanh thu
        }
    } catch (Exception e) {
        e.printStackTrace();  // In ra lỗi nếu có
    }

    return doanhThu;  // Trả về tổng doanh thu
}

    // Đóng kết nối
    public void closeConnection() {
        connectDB.close();
    }
}

