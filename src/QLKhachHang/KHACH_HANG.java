/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKhachHang;

import org.neo4j.driver.Session;
import org.neo4j.driver.internal.spi.Connection;
import QLKhachHang.TTKhachHang;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
/**
 *
 * @author User
 */
public class KHACH_HANG {
     private final Driver driver;

    public KHACH_HANG(Driver driver) {
        this.driver = driver;
    }
    
    public boolean insert(TTKhachHang khachHang) {
        String query = "CREATE (c:Customer {MaKH: $maKH, TenKH: $tenKH, GioiTinh: $gioiTinh, " +
                       "SDT: $sdt, DiaChi: $diaChi, SoThich: $soThich, SoLuongMua: $soLuongMua, " +
                       "VIP_Status: $vipStatus, NgayDangKy: $ngayDangKy})";

        try (Session session = driver.session()) {
            session.writeTransaction(tx -> {
                var result = tx.run(query, org.neo4j.driver.Values.parameters(
                    "maKH", khachHang.getMaKH(),
                    "tenKH", khachHang.getTenKH(),
                    "gioiTinh", khachHang.getGioiTinh(),
                    "sdt", khachHang.getSDT(),
                    "diaChi", khachHang.getDiaChi(),
                    "soThich", khachHang.getSoThich(),
                    "soLuongMua", khachHang.getSoLuongMua(),
                    "vipStatus", khachHang.isVIP_Status(),
                    "ngayDangKy", khachHang.getNgayDangKy()
                ));
                result.consume(); // Tiêu thụ kết quả để tránh lỗi
                return null;
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public TTKhachHang find(String maKH) {
        String query = "MATCH (c:Customer {MaKH: $maKH}) RETURN c";

        try (Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<TTKhachHang>() {
                @Override
                public TTKhachHang execute(Transaction tx) {
                    var result = tx.run(query, org.neo4j.driver.Values.parameters("maKH", maKH));
                    if (result.hasNext()) {
                        var record = result.next();
                        var k = record.get("k").asNode();
                        return new TTKhachHang(
                                k.get("MaKH").asString(),
                                k.get("TenKH").asString(),
                                k.get("GioiTinh").asString(),
                                k.get("SDT").asString(),
                                k.get("DiaChi").asString(),
                                k.get("SoThich").asString(),
                                k.get("SoLuongMua").asInt(),
                                k.get("VIP_Status").asBoolean(),
                                k.get("NgayDangKy").asLocalDate() // Adjust based on actual type
                        );
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(TTKhachHang khachHang) {
        String query = "MATCH (c:Customer {MaKH: $maKH}) " +
                       "SET c.TenKH = $tenKH, c.GioiTinh = $gioiTinh, c.SDT = $sdt, " +
                       "c.DiaChi = $diaChi, c.SoThich = $soThich, " +
                       "c.SoLuongMua = $soLuongMua, c.VIP_Status = $vipStatus, " +
                       "c.NgayDangKy = $ngayDangKy";

        try (Session session = driver.session()) {
            session.writeTransaction(tx -> {
                tx.run(query, org.neo4j.driver.Values.parameters(
                        "maKH", khachHang.getMaKH(),
                        "tenKH", khachHang.getTenKH(),
                        "gioiTinh", khachHang.getGioiTinh(),
                        "sdt", khachHang.getSDT(),
                        "diaChi", khachHang.getDiaChi(),
                        "soThich", khachHang.getSoThich(),
                        "soLuongMua", khachHang.getSoLuongMua(),
                        "vipStatus", khachHang.isVIP_Status(),
                        "ngayDangKy", khachHang.getNgayDangKy()
                ));
                return null;
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maKH) {
        String query = "MATCH (c:Customer {MaKH: $maKH}) DELETE c";

        try (Session session = driver.session()) {
            session.writeTransaction(tx -> {
                tx.run(query, org.neo4j.driver.Values.parameters("maKH", maKH));
                return null;
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
