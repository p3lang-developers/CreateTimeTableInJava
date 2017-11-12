/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Abhishek
 */
public class scollableandupdatable {
    public static void main(String args[])
    {
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            {
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?"+"user=root&password=abhi");
                String str="select * from teacher_details";
                //PreparedStatement stmt= conn.prepareStatement(str);
                PreparedStatement stmt= conn.prepareStatement(str, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=stmt.executeQuery(str);
                while(rs.next())
                {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                    System.out.println(rs.getString(6));
                    //System.out.println(rs.getString(7));
                    //System.out.println(rs.getString(8));
                    //System.out.println(rs.getString(9));
                }
            }
        }
        catch(Exception e)
        {
            
        }
    }
}
