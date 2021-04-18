import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorController {
    public void add(int id, String name, String country) {
        Connection connection = Database.getConnection();
        try {
            String sql = "INSERT INTO ACTORS (ID,NAME,COUNTRY) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, country);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findByName(String name) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM ACTORS WHERE NAME = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String title = result.getString("NAME");
                String country = result.getString("COUNTRY");
                System.out.println("id= " + id + " ; title= " + name + " ; date release= " + country + " ");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findById(int id) {
        Connection connection = Database.getConnection();
        try {
            String sql = "SELECT * FROM ACTORS WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int idResult = result.getInt("ID");
                String name = result.getString("NAME");
                String country = result.getString("COUNTRY");
                System.out.println("id= " + idResult + " ; title= " + name + " ; date release= " + country + " ");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
