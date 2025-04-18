package books;

public class PrintedBook extends Book {
    public final String type = "Printed";
    private boolean borrowed;

    public PrintedBook(String title, String author) {
        super(title, author);
        this.borrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    public String getType(){
        return type;
    }
}
