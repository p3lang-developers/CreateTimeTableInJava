/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyattendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Abhishek
 */
public class AttendanceDatabaseConnection {
    private static Connection connection;
    static 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        public static Connection getConnection() throws SQLException
        {
        if((connection==null)||(connection.isClosed()))
        {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?" + "user=root&password=abhi");
        }
        return connection;
    }
}
