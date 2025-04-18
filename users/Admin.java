package users;

import java.time.LocalDate;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
    @Override
        public void update(String message) {
        System.out.println("Admin[" + name + "]" + LocalDate.now() + " : " + message);
        }
}
