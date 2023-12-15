package org.example.Controler;

import org.example.DAO.CategorieDAO;
import org.example.DAO.HistoryDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.UserDAO;

public class MainController {
    public static void mainDAO()
    {
        /*UserController userController = new UserController();
        TaskController taskController = new TaskController();
        CategorieController categorieController = new CategorieController();
        HistoryController historyController = new HistoryController();
        userController.getAll();
        categorieController.getAll();
        taskController.getAll();
        historyController.getAll();*/
        UserDAO.getAll();
        CategorieDAO.getAll();
        TaskDAO.getAll();
        HistoryDAO.getAll();
    }
}
