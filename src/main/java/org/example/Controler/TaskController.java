package org.example.Controler;

import org.example.DAO.CategorieDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.UserDAO;
import org.example.Model.Categorie;
import org.example.Model.Priority;
import org.example.Model.Task;
import org.example.Model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TaskController implements InterfaceController{
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void add() throws SQLException {
        Task task = saisie();
        TaskDAO.addDBO(task);
        task.getCategorie().getTasks().put(task.getCode(), task);
        String status = "Ajouter tache";
        if(TaskDAO.taskExist(task.getCode()))
        {
            HistoryController.addHistory(User.getUserConnect(),task,status,LocalDate.now());
        }else{
            System.out.println("this task is not found in database !");
        }
    }

    @Override
    public void update() throws SQLException 
    {
        Task task = saisie();
        TaskDAO.updateDBOByCode(task.getCode(), task);
        String status = "Modifier tache";
        if(TaskDAO.taskExist(task.getCode()))
        {
            HistoryController.addHistory(User.getUserConnect(),task,status,LocalDate.now());
        }else{
            System.out.println("this task is not found in database !");
        }
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer code de tache");
        String code = scanner.next();
        Task task  = TaskDAO.searchTaskByCode(code);
        TaskDAO.deleteDOAByCode(code);
        String status = "Supprimer tache";
        HistoryController.addHistory(User.getUserConnect(), task, status , LocalDate.now());
    }

    @Override
    public void getAll()
    {
        TaskDAO.getAll();
        // Task.getTasks().forEach((s, task) -> System.out.println(task.toString()));
    }

    public void trieTaskWithDate()
    {
        System.out.println("Cherchez tache par date :");
        LocalDate date = LocalDate.parse(scanner.next());
        List<Task> task = TaskDAO.searchDOAByDate(date);
        assert task != null;

        task.forEach(task1 -> System.out.println(task1.toString()));
    }

    public void trieTaskWithCategory()
    {
        System.out.println("Cherchez tache par id category :");
        int idCategorie = scanner.nextInt();
        List<Task> tasks = TaskDAO.searchDBOByIdCategorie(idCategorie);
        assert tasks != null;
        tasks.forEach(t -> System.out.println(t.toString()));
    }

    public void trieTaskWithPriority()
    {
        System.out.println("Entrer tache priority 1 - LOW / 2 - MEDIUM / 3 - HIGH:");
        String priorityChoice = scanner.next().toUpperCase();
        List<Task> task = TaskDAO.searchDOAByPriority(priorityChoice);
        assert task != null;
        task.forEach(t -> System.out.println(t.toString()));
    }

    @Override
    public Task saisie() throws SQLException
    {
        System.out.println("Entrer code de tache:");
        String code = scanner.next();
        if (User.getUserConnect() != null)
        {
            System.out.println("Entrer libelle de tache:");
            String libelle = scanner.next();
            System.out.println("Entrer tache priority 1 - LOW / 2 - MEDIUM / 3 - HIGH:");
            String priorityChoice = scanner.next().toUpperCase();
            Priority priority = Priority.valueOf(Priority.class, priorityChoice) ;
            System.out.println("Entrer tache libelle categorie:");
            String libelleCategorie = scanner.next();
            Categorie categorie = CategorieDAO.searchDAOByLibelle(libelleCategorie);
            return new Task(code, libelle,priority , categorie, User.getUserConnect(), LocalDate.now());
        }
        return null;
    }

    public void affecterTache()
    {
        System.out.println("Entrer code de tache:");
        String code = scanner.next();
        Task task =TaskDAO.searchTaskByCode(code);
        System.out.println("entrer l'id de user");
        int id = scanner.nextInt();
        User user = UserDAO.searchDOAById(id);
        if (task != null) {
            task.setUser(user);
            assert user != null;
            TaskDAO.affecterTaskByCode(user.getId(), task.getCode());
        }
    }
}
