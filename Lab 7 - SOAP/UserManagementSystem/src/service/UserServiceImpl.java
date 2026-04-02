package service;

import javax.jws.WebService;
import java.util.ArrayList;
import model.User;

@WebService(endpointInterface = "service.UserService")
public class UserServiceImpl implements UserService {

    private static ArrayList<User> users = new ArrayList<>();

    @Override
    public String createUser(String username, int id, String password) {
        users.add(new User(username, id, password));
        return "User created successfully";
    }

    @Override
    public String getUser(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return "ID: " + u.getId() +
                        ", Username: " + u.getUsername();
            }
        }
        return "User not found";
    }

    @Override
    public String updateUser(int id, String username, String password) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setUsername(username);
                u.setPassword(password);
                return "User updated successfully";
            }
        }
        return "User not found";
    }

    @Override
    public String deleteUser(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
                return "User deleted successfully";
            }
        }
        return "User not found";
    }
}