package org.example;


import org.example.Controler.*;
import org.example.DAO.CategorieDAO;
import org.example.DAO.HistoryDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.UserDAO;
import org.example.Model.Categorie;
import org.example.Model.Priority;
import org.example.Model.Task;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        {
            //MainController.mainDAO();
            CsvController.saveInCsv();
        }

        UserController userController = new UserController();
        TaskController taskController = new TaskController();
        CategorieController categorieController = new CategorieController();
        HistoryController historyController = new HistoryController();

        //HistoryDAO.getAll();
        //historyController.getAll();
        userController.login();

        taskController.getAll();
        categorieController.getAll();
        //categorieController.delete();
        categorieController.trieParCategorie();
        //taskController.getAll();
        //categorieController.trieParAllCategorie();
        //Task.getTasks().forEach(t -> System.out.println(t));
        //taskController.trieTaskWithCategory();
        //CsvController.transfererInCsv();




    }
}