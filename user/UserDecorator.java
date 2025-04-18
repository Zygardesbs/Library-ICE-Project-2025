package users;

public class UserDecorator implements Accounts {
    protected Accounts user;
    public String getName(){
        return user.getName();
    }
    public boolean isAdmin(){
        return user.isAdmin();
    }
    public void update(String message){
        user.update(message);
    }
}
