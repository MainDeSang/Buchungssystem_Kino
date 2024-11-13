import java.util.Collections;
import java.util.List;

public class Admin {
    private String adminName;
    private String adminPassword;
    private List<String> library;

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
    public String addToLibrary(String movieName) {
        library.add(movieName);
        return movieName;
    }
    public void removeFromLibrary(String movieName) {
        library.remove(movieName);
    }
    public void changeLibrary(String movieName) {
        library.set(library.indexOf(movieName), movieName);
    }
}
