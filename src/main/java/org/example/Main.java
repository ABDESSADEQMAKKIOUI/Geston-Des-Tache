package org.example;


import org.example.Controler.CategorieController;
import org.example.Controler.HistoryController;
import org.example.Controler.TaskController;
import org.example.Controler.UserController;
import org.example.DAO.CategorieDAO;
import org.example.DAO.HistoryDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.UserDAO;
import org.example.Model.Categorie;
import org.example.Model.Priority;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserController userController = new UserController();
        TaskController taskController = new TaskController();
        CategorieController categorieController = new CategorieController();
        HistoryController historyController = new HistoryController();
        taskController.add();
        taskController.add();
        taskController.add();

        //HistoryDAO.getAll();
        //historyController.getAll();
        //TaskDAO.getAll();
        //CategorieDAO.getAll();
        //categorieController.getAll();
        taskController.affecterTache();



    }
}