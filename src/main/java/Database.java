import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import org.bson.Document;

public class Database {

    /**
     * Diese Methode stellt eine Verbindung zu einer MongoDB-Datenbank her.
     *
     * @param connectionString Die URL der MongoDB-Verbindung. Hier sind Zugangsdaten und Clusterinformationen enthalten.
     *                         Beispiel: "mongodb+srv://<benutzer>:<passwort>@<cluster>.mongodb.net/?retryWrites=true&w=majority".
     * @param dbName           Der Name der Datenbank, die du verwenden willst (z. B. "admin").
     * @return                 Die verbundene Datenbankinstanz, die für CRUD-Operationen genutzt werden kann,
     *                         oder null, wenn die Verbindung nicht funktioniert.
     */
    public static MongoDatabase connectToDatabase(String connectionString, String dbName) {

        // 1. Definiere, welche Version der MongoDB-Server-API genutzt werden soll.
        // Die Server-API steuert, wie sich die Verbindung verhält und welche Funktionen verfügbar sind.
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1) // Hier legen wir Version 1 der Server-API fest.
                .build();

        // 2. Erstelle die Verbindungs-Einstellungen für den MongoDB-Client.
        // Diese Einstellungen beinhalten:
        //   - die Verbindung zur MongoDB-Datenbank (connectionString) und
        //   - die Server-API-Version, die wir vorher festgelegt haben.
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString)) // Verbindungseinstellungen setzen
                .serverApi(serverApi) // Die Server-API, die oben definiert wurde, verwenden
                .build();

        // 3. Versuche, eine Verbindung zu MongoDB aufzubauen und die Datenbank zurückzugeben.
        try {
            // Erstelle den MongoDB-Client mit den angegebenen Einstellungen
            MongoClient mongoClient = MongoClients.create(settings); // Der Client verbindet sich jetzt zu MongoDB

            // Hole die gewünschte Datenbank anhand des Namens (dbName).
            MongoDatabase database = mongoClient.getDatabase(dbName); // Hier wird eine Verbindung zu der angegebenen Datenbank aufgebaut

            // 4. Sende einen Ping an die Datenbank, um sicherzustellen, dass die Verbindung funktioniert.
            database.runCommand(new Document("ping", 1)); // Der "ping"-Befehl prüft die Verbindung zur Datenbank.
            System.out.println("Verbindung zu MongoDB erfolgreich hergestellt!");

            // 5. Gebe die verbundene Datenbankinstanz zurück, damit andere Klassen sie für CRUD-Operationen nutzen können.
            return database;

        } catch (MongoException e) { // Wenn ein Fehler auftritt, z. B. die Verbindung fehlschlägt
            System.err.println("Fehler bei der Verbindung zu MongoDB: " + e.getMessage()); // Fehlermeldung ausgeben
            return null; // Gib null zurück, wenn die Verbindung nicht funktioniert
        }
    }
}
