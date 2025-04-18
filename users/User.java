package users;
import java.time.LocalDate;

public class User implements Accounts {
    protected final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() { 
        return name; 
    }

    public boolean isAdmin() { 
        return false; 
    }

    public void update(String message) {
        System.out.println("[" + name + "]" + LocalDate.now() + " : " + message);
    }
}
