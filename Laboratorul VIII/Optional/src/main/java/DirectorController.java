import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorController {
    public void add(int id, String name, String country, String movie) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO DIRECTORS (ID,NAME,COUNTRY,MOVIE) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, country);
            statement.setString(4, movie);
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
