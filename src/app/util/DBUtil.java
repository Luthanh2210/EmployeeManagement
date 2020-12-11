package app.util;
import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
public Connection connection;
    public  Connection getConnection() {

        String dbName="EmployeeManagement";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection= DriverManager.getConnection("jdbc:mysql://localhost:8012/"+dbName+userName+password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
