import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemsolonin on 12.05.2017.
 */
public class PostgreSQLDAO {
    public PostgreSQLDAO(Connection connection) {

    }

    public List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        try(Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM persons");

            while (rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                Person person = new Person(name,surname,age);
                persons.add(person);
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }

        return persons;
    }
}