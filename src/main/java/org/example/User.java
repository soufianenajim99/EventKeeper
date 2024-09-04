package org.example;

public class User {
    protected int Id;
    protected String username;
    protected String password;
    public static int counter=1;


    public User(String username,String password) {

        this.username = username;
        this.password=password;
        Id = counter;
        counter++;
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
