/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qloganic;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

/**
 *
 * @author User
 */
public class QLOganic {

   private final Driver driver;

    // Khởi tạo kết nối với cơ sở dữ liệu Neo4j
    public QLOganic(String uri, String user, String password) {
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

    // Đóng kết nối
    public void close() {
        driver.close();
    }

    public static void main(String[] args) {
        String uri = "bolt://localhost:7687";
        String user = "neo4j";
        String password = "123456789"; 
        // Tạo kết nối
        QLOganic connection = new QLOganic(uri, user, password);
        // Đóng kết nối sau khi hoàn thành
        connection.close();
    }
    
}
