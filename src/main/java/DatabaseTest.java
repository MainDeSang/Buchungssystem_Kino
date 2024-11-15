//Testverbindung zum PHP-Server

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookingsystemDB";
        String user = "java_user";
        String password = "050590Ll62911.";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Verbindung erfolgreich!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
