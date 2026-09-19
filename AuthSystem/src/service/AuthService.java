package service;

import exception.AuthException;
import model.Role;
import model.User;
import util.PasswordUtil;

import java.util.*;

public class AuthService {

    private final Map<String, User> users = new HashMap<>();

    // Register
    public void register(String name, int age, String username,
                         String password, Role role) throws AuthException {


        // 1. Password check
        if (!PasswordUtil.validate(password)) {
            throw new AuthException("Password must be at least 6 characters");
        }


        // 2. Duplicate check
        if (users.containsKey(username)) {
            throw new AuthException("Username already exists");
        }


        // 3. Hash password
        String hash = PasswordUtil.hash(password);


        // 4. create User  + store
        User user = new User(name, age, username, hash, role);
        users.put(username, user);

        System.out.println("Registered: " + username);
    }

    // Login
    public User login(String username, String password) throws AuthException {
        User user = users.get(username);

        if (user == null) {
            throw new AuthException("User not found");
        }

        if (!user.getPasswordHash().equals(PasswordUtil.hash(password))) {
            throw new AuthException("Wrong password");
        }

        return user;
    }

    // print user in sorted form
    public void printUsersSorted() {
        List<User> list = new ArrayList<>(users.values());

        // Anonymous class
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getUsername().compareTo(b.getUsername());
            }
        });

        System.out.println("\n--- All Users ---");
        for (User u: list) {
            u.display();
        }
    }
}