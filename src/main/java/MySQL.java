import Interface.IConnection;
import Interface.IQueries;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ms on 01-04-17.
 */
public class MySQL implements IQueries {

    private java.sql.Connection connection;
    private String url = "jdbc:mysql://172.17.0.20:3306/";
    private String user = "root";
    private String password = "password";

    public MySQL() throws SQLException {
        connection = DriverManager.getConnection(url,user,password);
    }


    public int depthOne(int nodeId) {
        String sqlString = "SELECT count(distinct end2.* FROM t_endorses end1 " +
                "INNER JOIN t_endorses end2 on end1.id = end2.source_node_id " +
                "WHERE end1.id = " + nodeId + ";";
        return executeQuery(sqlString);
    }

    public int depthTwo(int nodeId) {
        return 0;
    }

    public int depthThree(int nodeId) {
        return 0;
    }

    public int depthFour(int nodeId) {
        return 0;
    }

    public int depthFive(int nodeId) {
        return 0;
    }

    private int executeQuery(String sqlString){


        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlString);

            return resultSet.getInt(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

}

class Connection implements IConnection{

    public java.sql.Connection createConnection() {
        return null;
    }
}
