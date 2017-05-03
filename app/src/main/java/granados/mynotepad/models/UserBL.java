package granados.mynotepad.models;

import java.util.ArrayList;
import java.util.List;

import granados.mynotepad.models.User;

/**
 * Created by Steph on 3/05/2017.
 */

public class UserBL {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(100, "abc@gmail.com", "tecsup", "Juana Perez"));
        users.add(new User(200, "def@gmail.com", "tecsup", "Pepito Juarez"));
        users.add(new User(300, "ghi@gmail.com", "tecsup", "Pedro Poaz"));


    }

    public static void registrar(User user) {
        users.add(user);
    }

    public static User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User getUser(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

}
