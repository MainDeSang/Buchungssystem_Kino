
//Zur Bearbeitung der Datenbank "bookingsystemDB", die auf dem PHP-Server liegt. Auch direkt über das Terminal möglich,
//in dem man mit den SUDO Befehlen die MYSQL Tabellen erstellen und bearbeiten kann.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdater {
    public static void updateRecord(int id, String neuerName) {
        String updateSQL = "UPDATE beispieltabelle SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, neuerName);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " Zeile(n) aktualisiert.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateRecord(1, "Neuer Name");
    }
}
