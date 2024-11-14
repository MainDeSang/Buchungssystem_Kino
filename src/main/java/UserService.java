import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserService {

    public static boolean registrieren(String benutzername, String email, String passwort, String rolle) {
        String sql = "INSERT INTO USER (benutzer, email, passwort, rolle) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.verbinden();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, benutzername);
            stmt.setString(2, email);
            stmt.setString(3, passwort); // Achte darauf, dass das Passwort vor der Speicherung gehasht wird!
            stmt.setString(4, rolle);

            int result = stmt.executeUpdate();
            return result > 0; // Wenn das Einfügen erfolgreich war, gibt es eine positive Zahl zurück.
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
