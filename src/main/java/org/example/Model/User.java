package org.example.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private  static int id;
    private String login;
    private String password;
    private String role;
    private static ArrayList<User> users = new ArrayList<User>();
    private static User userConnect;

    public User() {
    }

    public User(String login, String password, String role) {
        id++;
        this.login = login;
        this.password = password;
        this.role = role;
        users.add(this);
    }
    public User(int id,String login, String password, String role) {
        User.id = id ;
        this.login = login;
        this.password = password;
        this.role = role;
        users.add(this);
    }


    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    public static User getUserConnect() {
        return userConnect;
    }

    public static void setUserConnect(User userConnect) {
        User.userConnect = userConnect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        User.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
