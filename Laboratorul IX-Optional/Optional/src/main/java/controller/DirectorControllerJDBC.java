package controller;

import dao.DirectorJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorControllerJDBC {
    public void add(DirectorJDBC director) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO DIRECTORS (ID,NAME,COUNTRY,MOVIE) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, director.getId());
            statement.setString(2, director.getName());
            statement.setString(3, director.getCountry());
            statement.setString(4, director.getMovie());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findById(int id) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM DIRECTORS WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int idResult = result.getInt("ID");
                String name = result.getString("NAME");
                String country = result.getString("COUNTRY");
                String movie = result.getString("MOVIE");
                System.out.println("id= " + idResult + " ; numele= " + name + " ; nationalitate = " + country + " ;film: " + movie);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
