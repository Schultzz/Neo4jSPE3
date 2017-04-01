import java.sql.SQLException;

/**
 * Created by ms on 01-04-17.
 */
public class Main {
    public static void main(String[] args) {
        try {
            MySQL mySQL = new MySQL();
            mySQL.depthOne(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
