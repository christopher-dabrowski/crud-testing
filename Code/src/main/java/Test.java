import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        System.out.println("Soon this will connect to qsl");

        var url = "jdbc:postgresql://localhost:5432/";
        var user = "postgres";
        var pass = "postgres";

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.family_members");

            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("name"), resultSet.getString("surname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
