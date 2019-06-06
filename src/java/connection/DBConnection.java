package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Danya on 24.02.2016.
 */
public class DBConnection
{
    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "mmm333";

    public synchronized static Connection getConnection() {
        if(connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                    "?user=" + dbUser + "&password=" + dbPass);
                try(Statement statement = connection.createStatement()) {
                    statement.execute("CREATE TABLE " +
                        "IF NOT EXISTS site_visit(id INT NOT NULL AUTO_INCREMENT," +
                        "`name` VARCHAR(64) NOT NULL UNIQUE, `count` INT NOT NULL, PRIMARY KEY(id))");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
