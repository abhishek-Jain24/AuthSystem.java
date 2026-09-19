import exception.AuthException;
import model.Role;
import model.User;
import service.AuthService;
import service.SessionManager;
import util.InputUtil;

public class Main{
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        SessionManager sessionManager = new SessionManager();
        SessionManager.Session currentSession = null;

        while (true) {
            System.out.println("\n=== AUTH SYSTEM ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Users");
            System.out.println("4. Logout");
            System.out.println("5. Exit");

            int choice = InputUtil.readInt("Choose: ");

            try {
                if (choice == 1) {
                    // Register
                    String name = InputUtil.readLine("Name: ");
                    int age = InputUtil.readInt("Age: ");
                    String user = InputUtil.readLine("Username: ");
                    String pass = InputUtil.readLine("Password: ");
                    auth.register(name, age, user, pass, Role.USER);

                } else if (choice == 2) {
                    // Login
                    String user = InputUtil.readLine("Username: ");
                    String pass = InputUtil.readLine("Password: ");
                    User u = auth.login(user, pass);
                    currentSession = sessionManager.createSession(u);
                    currentSession.show();

                } else if (choice == 3) {
                    // View Users
                    auth.printUsersSorted();

                } else if (choice == 4) {
                    // Logout
                    if (currentSession != null) {
                        currentSession = null;
                        System.out.println("Logged out");
                    } else {
                        System.out.println("Not logged in");
                    }

                } else if (choice == 5) {
                    // Exit
                    System.out.println("Bye!");
                    return;

                } else {
                    System.out.println("Invalid choice");
                }

            } catch (AuthException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}