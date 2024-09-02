package org.example;

public class User {
    protected int Id;
    protected String username;
    protected String password;

    public User(String username, int id,String password) {
        System.out.println("Parent here");
        this.username = username;
        this.password=password;
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                '}';
    }
}
