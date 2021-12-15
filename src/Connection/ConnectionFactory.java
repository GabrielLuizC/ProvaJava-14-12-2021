package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prova", "root", "");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
