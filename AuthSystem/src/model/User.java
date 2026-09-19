package model;

public class User extends Person {

    private String username;
    private String passwordHash;
    private Role role;

    // Abstract parent
    public User(String name, int age, String username, String passwordHash, Role role) {
        super(name, age);
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    //Abstract method implement
    @Override
    public void display() {
        System.out.println("Username : " + username);
        System.out.println("Role     : " + role);

        if (role == Role.ADMIN) {
            System.out.println("Access   : Full access");
        } else {
            System.out.println("Access   : Limited access");
        }
    }

    //toString()--> it can override  but name() can't override
    @Override
    public String toString() {
        return "User[" + username + ", " + role + "]";
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        User other = (User) obj;
        return this.username.equals(other.username);
    }

    //hashCode()
    @Override
    public int hashCode() {
        return username.hashCode();
    }

    // Getters
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public Role getRole() { return role; }


}