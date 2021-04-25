package controller;

import controller.Database;
import dao.GenreJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreControllerJDBC {

    public void create(GenreJDBC genreJDBC) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO GENRES (ID,NAME) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, genreJDBC.getId());
            statement.setString(2, genreJDBC.getName());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String findByName(String name) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM GENRES WHERE NAME = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String nume = result.getString("NAME");
                int id = result.getInt("ID");
                return (nume + " " + id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String findById(int idSearch) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM GENRES WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idSearch);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String nume = result.getString("NAME");
                int id = result.getInt("ID");
                return (nume + " " + id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
