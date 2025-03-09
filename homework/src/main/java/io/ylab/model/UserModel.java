package io.ylab.model;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean isActive;

    private static int userId = 0;

    public UserModel(String name, String email, String password) {
        this.id = ++userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return isActive;
    }

    public void setStatus(boolean status) { 
        this.isActive = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                "}";
    }
}
