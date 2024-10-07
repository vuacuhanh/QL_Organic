/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qloganic;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class QLOganic {

    private final Driver driver;

    // Khởi tạo kết nối với cơ sở dữ liệu Neo4j
    public QLOganic() {
        String uri = "bolt://localhost:7687";
        String user = "neo4j";
        String password = "123456789"; 
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        if (checkConnection()) {
            System.out.println("Kết nối Neo4j thành công!");
        } else {
            System.out.println("Kết nối Neo4j thất bại!");
        }
    }

    private boolean checkConnection() {
        try (Session session = driver.session()) {
            session.run("RETURN 1");
            return true;  
        } catch (Exception e) {
            e.printStackTrace();  
            return false;  
        }
    }

    public Driver getDriver() {
        return driver;
    }

    private void displayUsernames() {
        try (Session session = driver.session()) {
            var result = session.run("MATCH (c:Customer) RETURN c.MaKH AS MaKH");
            System.out.println("Danh sách KH:");
            while (result.hasNext()) {
                var record = result.next();
                System.out.println(record.get("TenDangNhap").asString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Đóng kết nối
    public void close() {
        driver.close();
    }

    public static void main(String[] args) {
        // Khởi tạo đối tượng QLOganic
        QLOganic connection = new QLOganic();
        connection.displayUsernames();
        
    }
}
