import users.*;
import system.Library;
import java.util.Scanner;

public class LibraryApp {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Library library = Library.getInstance();

        while (true) {
            System.out.print("Login as admin? (Y/N, or type EXIT to Shutdown): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("\n--- Shutting Down ---\n");
                break;
            }
            Accounts currentUser;
            System.out.println("Enter name");
            Accounts user = new User(scanner.nextLine().trim());
            if (input.equals("y")) {
               currentUser = new AdminDecorator(user);
                System.out.println("\n--- Logged in as Admin ---\n");
            } else {
                currentUser = user;
                System.out.println("\n--- Logged in as User ---\n");
            }

            Menu.run(currentUser, library, scanner);
            System.out.println("\n--- Logged out ---\n");
        }

        scanner.close();
    }
}
