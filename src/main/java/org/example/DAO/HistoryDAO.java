package org.example.DAO;

import org.example.Model.History;
import org.example.Model.Task;
import org.example.Model.User;

import java.sql.*;

public class HistoryDAO {

    static Connection connection = DatabaseConnection.getConnection();
    public static void addHistory(History history)
    {
        try{
            String insertQuery = "INSERT INTO historiques (id_user,code_tache,libelle,date_creation)VALUES (?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setInt(1,history.getUser().getId());
            preparedStatement.setString(2,history.getTask().getCode());
            preparedStatement.setString(3,history.getLibelle());
            preparedStatement.setDate(4, Date.valueOf(history.getDate_creation()));

            preparedStatement.executeUpdate();

            System.out.println("history inserted into the database successfully.");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void getAll()
    {
        try {
            String selectQuery = "SELECT * FROM historiques";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            History history = null;
            while (resultSet.next())
            {
                User user = UserDAO.searchDOAById(resultSet.getInt("id_user"));
                Task task = TaskDAO.searchDOAByCode(resultSet.getString("code_tache"));
                history = new History(resultSet.getInt("id"),user, task, resultSet.getString("libelle"), resultSet.getDate("date_creation").toLocalDate());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
