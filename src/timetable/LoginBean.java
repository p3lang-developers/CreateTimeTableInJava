/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import timetable1.view.Coordinator;

/**
 *
 * @author Abhishek
 */
public class LoginBean {
    String admin_id;
    String admin_password;
    Connection connection;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    public String check()
    {
         try {
            connection =DataBaseConnection.getConnection();
            //String str= "select * from ";
PreparedStatement ps = connection.prepareStatement("select * from admin where admin_id='"+admin_id+"' and admin_password='"+admin_password+"' ");
ResultSet rs =ps.executeQuery();
int count=0;
while(rs.next())
{
    System.out.println(rs.getString(1));
    System.out.println(rs.getString(2));
    count=1;
}
        connection.close();
        if(count>0)
        {
        return "true";
        }
        else
        {
            //System.out.println("invalid login");
            //System.out.println("you can not access in confidential, JAMA");
            return "false";
        }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "false";
        }
        // return "true";
    }
}
