//Stellt die Notwendige verbindung zum PHP-Server her.

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bookingsystemDB";
        String user = "java_user";
        String password = "050590Ll62911.";
        return (Connection) DriverManager.getConnection(url, user, password);
    }
}
