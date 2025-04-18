package system;
import java.time.LocalDate;

public class Transaction {
    private final String user;
    private final String Title;
    private final String action;

    public Transaction(String user, String Title, String action) {
        this.user = user;
        this.Title = Title;
        this.action = action;
    }

    @Override
    public String toString() {
        return "[" + LocalDate.now() + "] " + user + " " + action + "ed \"" + Title + "\"";
    }
}
