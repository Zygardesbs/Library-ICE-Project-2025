package users;

public class AdminDecorator extends UserDecorator{
    public AdminDecorator(Accounts user){
        this.user = user;
    }
    @Override
    public boolean isAdmin(){
        return true;
    }
    @Override
    public String getName() {
        return "Admin[" + user.getName() + "]";
    }
}
