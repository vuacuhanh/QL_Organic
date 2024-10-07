/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectingNeo4j;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;


/**
 *
 * @author User
 */
public class ConnectDB {
    private final Driver driver;

    // Khởi tạo kết nối với cơ sở dữ liệu Neo4j
    public ConnectDB(String uri, String user, String password) {
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
        // Tạo kết nối
        ConnectDB connection = new ConnectDB("bolt://localhost:7687", "neo4j", "123456789");
        // Đóng kết nối sau khi hoàn thành
        connection.close();
    }
}
