package controller;

import controller.Database;
import dao.AssociationJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociationControllerJDBC {
    public void create(AssociationJDBC associationJDBC) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO ASOCIERE (ID_MOVIE,ID_GENDER) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, associationJDBC.getId_movie());
            statement.setInt(2, associationJDBC.getId_gender());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String findByIdMovie(int idSearch) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM ASOCIERE WHERE ID_MOVIE = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idSearch);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                int idMovie = result.getInt("ID_MOVIE");
                int idGender = result.getInt("ID_GENDER");
                return ("Id-ul filmului:" + idMovie + ",id-ul genului:" + idGender);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String findByIdGender(int idSearch) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM ASOCIERE WHERE ID_GENDER = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idSearch);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                int idMovie = result.getInt("ID_MOVIE");
                int idGender = result.getInt("ID_GENDER");
                return ("Id-ul filmului:" + idMovie + ",id-ul genului:" + idGender);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
