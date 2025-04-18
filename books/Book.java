package books;

public abstract class Book {
    private final String title;
    private final String author;
    public abstract String getType();

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { 
        return title; 
    }
    public String getAuthor() { 
        return author; 
    }

    public boolean isBorrowed() { 
        return false; 
    }
    public void setBorrowed(boolean borrowed) {
        
    }

    public boolean borrow() {
        if (!isBorrowed()) {
            setBorrowed(true);
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (isBorrowed()) {
            setBorrowed(false);
            return true;
        }
        return false;
    }
}
