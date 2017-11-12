/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ListIterator;
import java.util.Vector;

/**
 *
 * @author Abhishek
 */
public class NewJFrame3Database {
    Connection connection;
    ListIterator itr;
    Vector semester_stream=new Vector();
    String mycb1;
 public void myjcombobox1()
        {
            try {
            connection =DataBaseConnection.getConnection();
            String str= "select * from semester_stream";
PreparedStatement ps = connection.prepareStatement(str);
ResultSet rs =ps.executeQuery();
while(rs.next())
{
        semester_stream.add(rs.getString(1));
        }
        itr=semester_stream.listIterator();
        while(itr.hasNext())
        {
            mycb1=(String)itr.next();
            System.out.println(mycb1);
        }
        System.out.println(""+mycb1);
        connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        }

}
