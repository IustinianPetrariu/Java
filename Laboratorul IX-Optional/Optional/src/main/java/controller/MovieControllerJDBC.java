package controller;

import com.opencsv.CSVReader;
import dao.MovieJDBC;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieControllerJDBC {

    public void add(MovieJDBC movie) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO MOVIES (ID,TITLE,RELEASE_DATE,DURATION_TIME,SCORE) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setInt(3, movie.getReleaseDate());
            statement.setInt(4, movie.getDurationTime());
            statement.setDouble(5, movie.getScore());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findByName(String name) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM MOVIES WHERE TITLE = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String title = result.getString("TITLE");
                int releaseDate = result.getInt("RELEASE_DATE");
                int durationTime = result.getInt("DURATION_TIME");
                double score = result.getDouble("SCORE");
                System.out.println("id= " + id + " ; title= " + title + " ; date release= " + releaseDate + " ; duration= " + durationTime + " ;score= " + score + " ;");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findById(int id) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM MOVIES WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idResult = result.getInt("ID");
                String title = result.getString("TITLE");
                int releaseDate = result.getInt("RELEASE_DATE");
                int durationTime = result.getInt("DURATION_TIME");
                double score = result.getDouble("SCORE");
                System.out.println("id= " + idResult + " ; title= " + title + " ; date release= " + releaseDate + " ; duration= " + durationTime + " ;score= " + score + " ;");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void populateWithData() {
        int numberOfRows = 0;
        CSVReader reader = null;
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO MOVIES (TITLE,RELEASE_DATE,DURATION_TIME,SCORE) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            reader = new CSVReader(new FileReader("movies.csv"));
            String[] columns;
            while ((columns = reader.readNext()) != null) {
                numberOfRows++;
                if (numberOfRows == 1)
                    continue;
                statement.setString(1, columns[2]);
                statement.setInt(2, Integer.parseInt(columns[3]));
                statement.setInt(3, Integer.parseInt(columns[6]));
                statement.setDouble(4, Double.parseDouble(columns[14]));
                statement.executeUpdate();
                if (numberOfRows == 30)
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<MovieJDBC> getAllMovies() {
        List<MovieJDBC> movie = new ArrayList<>();
        MovieJDBC prepare;
        Connection connection = Database.getConnection();

        try {
            String sql = "SELECT * FROM MOVIES";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idResult = result.getInt("ID");
                String title = result.getString("TITLE");
                int releaseDate = result.getInt("RELEASE_DATE");
                int durationTime = result.getInt("DURATION_TIME");
                double score = result.getDouble("SCORE");
                prepare = new MovieJDBC();
                prepare.setId(idResult);
                prepare.setDurationTime(durationTime);
                prepare.setReleaseDate(releaseDate);
                prepare.setScore(score);
                prepare.setTitle(title);
                movie.add(prepare);
                // System.out.println("id= " + idResult + " ; title= " + title + " ; date release= " + releaseDate + " ; duration= " + durationTime + " ;score= " + score + " ;");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return movie;
    }

}
