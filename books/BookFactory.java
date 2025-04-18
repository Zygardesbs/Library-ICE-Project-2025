package books;

public class BookFactory {
    public static Book createBook(String type, String title, String author) {
        return switch (type.toLowerCase()) {
            case "printed" -> new PrintedBook(title, author);
            case "ebook" -> new EBook(title, author);
            default -> throw new IllegalArgumentException("Invalid book type.");
        };
    }
}
