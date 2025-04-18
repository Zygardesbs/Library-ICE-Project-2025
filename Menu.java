import books.Book;
import books.BookFactory;
import system.Library;
import users.Accounts;
import java.util.Scanner;

public class Menu {
public static void run(Accounts currentUser, Library library, Scanner scanner) {
        boolean running = true;
        while (running) {
            if (currentUser.isAdmin()) {
                System.out.println("0. Display Books");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. View Transaction Log");
                System.out.println("6. Exit");
            } else {
                System.out.println("0. Display Books");
                System.out.println("1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. View Transaction Log");
                System.out.println("4. Exit");
            }

            System.out.print("Type desired action: ");
            String choice = scanner.nextLine().trim();

            if (currentUser.isAdmin()) {
                switch (choice) {
                    case "0" -> library.displayBooks();
                    case "1" -> {
                        System.out.print("Enter book type (printed/ebook): ");
                        String type = scanner.nextLine();
                        if (type != null && (type.toLowerCase().equals("printed") || type.toLowerCase().equals("ebook"))) {
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            Book book = BookFactory.createBook(type, title, author);
                            library.addBook(currentUser,book);
                        } else {
                            System.out.println("Unknown Type");
                        }
              
                    }
                    case "2" -> {
                        System.out.print("Enter book title to remove: ");
                        String title = scanner.nextLine();
                        library.removeBook(currentUser,title);
                    }
                    case "3" -> {
                        System.out.print("Enter book title to borrow: ");
                        String title = scanner.nextLine();
                        library.borrowBook(currentUser, title);
                    }
                    case "4" -> {
                        System.out.print("Enter book title to return: ");
                        String title = scanner.nextLine();
                        library.returnBook(currentUser, title);
                    }
                    case "5" -> library.printTransactionLog();
                    case "6" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } else {
                switch (choice) {
                    case "0" -> library.displayBooks();
                    case "1" -> {
                        System.out.print("Enter book title to borrow: ");
                        String title = scanner.nextLine();
                        library.borrowBook(currentUser, title);
                    }
                    case "2" -> {
                        System.out.print("Enter book title to return: ");
                        String title = scanner.nextLine();
                        library.returnBook(currentUser, title);
                    }
                    case "3" -> library.printTransactionLog();
                    case "4" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
