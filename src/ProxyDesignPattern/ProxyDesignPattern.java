package ProxyDesignPattern;

enum Role{
    ADMIN, USER
}
class User{
    private String name;
    private Role role;
}

interface UserService{
    public void getUser(String name);
    public void deleteUser();
}

class UserServiceImpl implements UserService{
    User user;
    public void getUser(String name){
        System.out.println("Returning user with" + name);
    }
    public void deleteUser(){
        System.out.println("Deleting user");
    }
}

class ProxyServer implements UserService{
    UserServiceImpl realService;
    public ProxyServer(UserServiceImpl realService){
        this.realService = realService;
    }
    public void getUser(String name){
        realService.getUser(name);
    }
    public void deleteUser(){
        realService.deleteUser();
    }
}

public class ProxyDesignPattern {
     public static void main(String[] args){
         // create two user
         // have not coded but this is the jist, the proxy implementes the main interface to mocks it's behaviour
         // and also holds object of the
         // implemented class to delegate request to it
     }
}
