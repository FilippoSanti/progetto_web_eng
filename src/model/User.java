package model;

public class User {
    String email;

    public User() {
        this.email = "";
    }

    public User(String email) {

        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // TODO: getters and setters
}