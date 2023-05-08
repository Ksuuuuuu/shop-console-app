package app;

import java.util.List;

public class UserService {
    private final List<User> users;

    public UserService(List<User> users){
        this.users = users;
    }

    public User loginUser(String login, String password){
        for (User user: users){
            if ((user.getLogin().equals(login) || user.getEmail().equals(login) && user.getPassword().equals(password))){
                return user;
            }
        }
        return null;
    }

    public boolean registry(User user){
        for (User p: users){
            if (p.getLogin().equals(user.getLogin()) || p.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        users.add(user);
        return true;
    }
}
