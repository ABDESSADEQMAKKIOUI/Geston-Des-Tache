package org.example.Service;

import org.example.Controler.UserController;
import org.example.Model.User;

import java.sql.SQLException;

public class ServiceController {
    static UserController userController = new UserController();
    static ServiceUser serviceUser = new ServiceUser();
    static ServiceAdmin serviceAdmin = new ServiceAdmin();
    public  static void login() throws SQLException {
        userController.login();
        if ("admin".equalsIgnoreCase(User.getUserConnect().getRole())){
            serviceAdmin.choixAdmin();
        } else {
            serviceUser.choixUser();
        }
            }
}