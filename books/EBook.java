package books;

public class EBook extends Book {
    public final String type = "EBook";
    public EBook(String title, String author) {
        super(title, author);
    }

    @Override
    public boolean borrow() {
        return true;
    }

    @Override
    public boolean returnBook() {
        return false;
    }
    public String getType(){
        return type;
    }
}
