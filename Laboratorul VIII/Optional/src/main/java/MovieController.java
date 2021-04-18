import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieController {

    public void add(int id, String title, int releaseDate, int DurationTime, double score) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO MOVIES (ID,TITLE,RELEASE_DATE,DURATION_TIME,SCORE) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setInt(3, releaseDate);
            statement.setInt(4, DurationTime);
            statement.setDouble(5, score);
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

    public List<Movie> getAllMovies() {
        List<Movie> movie = new ArrayList<>();
        Movie prepare;
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
                prepare = new Movie();
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
