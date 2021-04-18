import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
