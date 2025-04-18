package system;
import books.Book;
import java.util.*;
import users.*;

public class Library {
    private static Library instance;
    private final List<Book> books = new ArrayList<>();
    private final List<Transaction> transactionLog = new ArrayList<>();

    private Library() {

    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }




    private void logTransaction(String user, String action, String bookTitle) {
        Transaction transaction = new Transaction(user, bookTitle, action);
        transactionLog.add(transaction);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library under construction");
        } else {
            System.out.println("Books in the Library:");
            for (Book book : books) {
                System.out.println("["+book.getType()+"]"+book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void addBook(Accounts currentUser,Book book) {
        books.add(book);
        logTransaction(currentUser.getName(), "add", book.getTitle());
        System.out.println(currentUser.getName() + " added \"" + book.getTitle() + "\"");
    }

    public void removeBook(Accounts currentUser, String title) {
        for(int i = 0 ; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                i--;
                logTransaction(currentUser.getName(), "remove", title);
                System.out.println(currentUser.getName() + " removed \"" + book.getTitle() + "\"");
                return;
            }
        }
        System.out.println("Book with this name can't be found");
    }

    public void borrowBook(Accounts currentUser, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.borrow()) {
                    logTransaction(currentUser.getName(),"Borrow",title);
                    System.out.println(currentUser.getName() + " borrowed \"" + book.getTitle() + "\"");
                } 
                else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(Accounts currentUser, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.returnBook()) {
                    logTransaction(currentUser.getName(), "Return", title);
                    System.out.println(currentUser.getName() + " returned \"" + book.getTitle() + "\"");
                } else {
                    System.out.println("Nothing to return for this book.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void printTransactionLog() {
        if (transactionLog.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactionLog) {
                System.out.println(t);
            }
        }
    }
}
