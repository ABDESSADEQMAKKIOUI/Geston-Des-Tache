package org.example.DAO;


import org.example.Model.Categorie;
import org.example.Model.Priority;
import org.example.Model.Task;
import org.example.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    static Connection connection = DatabaseConnection.getConnection();

    public static void addDBO(Task task)
    {
        try{
            String query
                    = "insert into taches(code, "
                    + "nom,"+"priority,"+"id_categorie,"+"id_user,"+"date_creation) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, task.getCode());
            ps.setString(2, task.getLibelle());
            ps.setString(3, task.getPriority().getName());
            ps.setInt(4, task.getCategorie().getId());
            ps.setInt(5, task.getUser().getId());
            ps.setDate(6, Date.valueOf(task.getDate_creation()));
            ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDOAByCode(String code)
    {
        try{
            String deleteQuery = "DELETE FROM taches WHERE code = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setString(1, code);
            int n = ps.executeUpdate();

            if (n > 0) {
                System.out.println("task with code '" + code + "' deleted successfully.");
            } else {
                System.out.println("task with code '" + code + "' not found.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateDBOByCode(String code, Task task)
    {
        try{
            if(taskExist(code))
            {
                String query = "UPDATE taches " +
                        "SET nom = ?, priority = ?, id_categorie = ?, id_user = ?, date_creation = ? " +
                        "WHERE code = ?";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, task.getLibelle());
                ps.setString(2, task.getPriority().getName());
                ps.setInt(3, task.getCategorie().getId());
                ps.setInt(4,task.getUser().getId());
                ps.setDate(5, Date.valueOf(task.getDate_creation()));
                ps.setString(6, code);
                ps.executeUpdate();

                System.out.println("Task with code: '"+ code +"' updated successfully");
            }else{
                System.out.println("Task with code: '"+ code + "' not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean taskExist(String code) throws SQLException
    {
        String checkQuery = "SELECT COUNT(*) FROM taches WHERE code = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setString(1, code);

        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();

        int count = resultSet.getInt(1);

        return count > 0;
    }

    public static void getAll()
    {
        try{
            String query = "SELECT * FROM taches";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("All tasks in DataBase :");
            Task task = null;
            while (rs.next())
            {
                Categorie categorie = CategorieDAO.searchDAOById(rs.getInt("id_categorie"));
                User user = UserDAO.searchDOAById(rs.getInt("id_user"));
                task = new Task(
                        rs.getString("code"),
                        rs.getString("nom"),
                        Priority.valueOf(rs.getString("priority").toUpperCase()),
                        categorie,
                        user,
                        rs.getDate("date_creation").toLocalDate()
                );
                task.getCategorie().getTasks().put(task.getCode(),task);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Task searchDOAByCode(String code)
    {
        try {
            String selectQuery = "SELECT * FROM taches WHERE code = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            Task task = null;
            while (resultSet.next())
            {
                Categorie categorie = CategorieDAO.searchDAOById(resultSet.getInt("id_categorie"));
                User user = UserDAO.searchDOAById(resultSet.getInt("id_user"));
                task = new Task(
                        resultSet.getString("code"),
                        resultSet.getString("nom"),
                        Priority.valueOf(Priority.class, resultSet.getString("priority").toUpperCase()),
                        categorie,
                        user,
                        resultSet.getDate("date_creation").toLocalDate()
                );
                task.getCategorie().getTasks().put(task.getCode(),task);
            }

            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for task in the database.");
        }
        return null;
    }

    public static List<Task> searchDOAByDate(LocalDate dateCreation)
    {
        try {
            String selectQuery = "SELECT * FROM taches WHERE date_creation = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setDate(1, Date.valueOf(dateCreation));
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Task with date '" + dateCreation + "':");

            List<Task> tasks = new ArrayList<>();
            while (resultSet.next())
            {
                Categorie categorie = CategorieDAO.searchDAOById(resultSet.getInt("id_categorie"));
                User user = UserDAO.searchDOAById(resultSet.getInt("id_user"));
                Task task = new Task(
                        resultSet.getString("code"),
                        resultSet.getString("nom"),
                        Priority.valueOf(resultSet.getString("priority").toUpperCase()),
                        categorie,
                        user,
                        resultSet.getDate("date_creation").toLocalDate()
                );
                tasks.add(task);
            }

            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for task in the database.");
        }
        return null;
    }

    public static void updateDBOByCode(int id , String  code)
    {
        try{
            if(taskExist(code))
            {
                String query = "UPDATE taches " +
                        "SET  id_user = ? " +
                        "WHERE code = ?";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1,id);
                ps.setString(2, code);
                ps.executeUpdate();

                System.out.println("Task with code: '"+ code +"' updated successfully");
            }else{
                System.out.println("Task with code: '"+ code + "' not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Task> searchDOAByPriority(String priority)
    {
        try {
            String selectQuery = "SELECT * FROM taches WHERE priority = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, priority);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Task with priority '" + priority + "':");

            List<Task> tasks = new ArrayList<>();
            while (resultSet.next())
            {
                Categorie categorie = CategorieDAO.searchDAOById(resultSet.getInt("id_categorie"));
                User user = UserDAO.searchDOAById(resultSet.getInt("id_user"));
                Task task = new Task(
                        resultSet.getString("code"),
                        resultSet.getString("nom"),
                        Priority.valueOf(resultSet.getString("priority").toUpperCase()),
                        categorie,
                        user,
                        resultSet.getDate("date_creation").toLocalDate()
                );
                tasks.add(task);
            }

            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for task in the database.");
        }
        return null;
    }


}
