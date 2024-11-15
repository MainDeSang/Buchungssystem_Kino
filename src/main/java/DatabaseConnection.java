// Verbindung zum Datenbankcontainer von Manu um den Zugriff externer Verwender auf die Datenbank zu ermöglichen

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    public static Connection verbinden() {
        try {
            // MySQL JDBC-Treiber laden
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Verbindungs-URL (ersetze 'meinProjektDB', 'root', und 'deinPasswort' mit deinen Werten)
            String url = "jdbc:mysql://localhost:3306/Buchungssystem";
            String benutzer = "root";
            String passwort = "08August1968";

            // Verbindung aufbauen
            Connection conn = DriverManager.getConnection(url, benutzer, passwort);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Verbindung herstellen
        Connection conn = verbinden();
        if (conn != null) {
            System.out.println("Verbindung erfolgreich!");

            // Beispiel für das Erstellen einer Tabelle
            try {
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS BeispielTabelle (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(50) NOT NULL)";
                stmt.executeUpdate(sql);
                System.out.println("Tabelle erfolgreich erstellt.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return null;
    }
}
