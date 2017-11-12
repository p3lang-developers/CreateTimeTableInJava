/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Abhishek
 */
public class CoordinatorBean //implements Runnable
{
    Connection connection;
    Vector class_details=new Vector();  //this will use to display the value of semester and stream.
    Vector teacher_details_id1=new Vector();    //this will use to display the value of cc.
    Vector subject_id=new Vector();    //this will use to display the value of subject.
    Vector boxt=new Vector();   //this will display the vaues of teachers in accordance with subject.
    private String box1;    //this will contain the value of semester and stream.
    private String box2;    //this will contain the value of cc1.
    private String box73;    //this will contain the value of cc2.  
    private String subject;     // get the value of subject
    private String teacher;    // get the value of teacher
    private String day;     
    private String lecture;
    private String status="true";

    /*
     * getter and setter start
     */
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public Vector getBoxt() {
        return boxt;
    }

    public void setBoxt(Vector boxt) {
        this.boxt = boxt;
    }
    
    public String getBox73() {
        return box73;
    }

    public void setBox73(String box73) {
        this.box73 = box73;
    }

    public String getBox2() {
        return box2;
    }

    public void setBox2(String box2) {
        this.box2 = box2;
    }

    public Vector getClass_details() {
        return class_details;
    }

    public void setClass_details(Vector class_details) {
        this.class_details = class_details;
    }

    public String getBox1() {
        return box1;
    }

    public void setBox1(String box1) {
        this.box1 = box1;
    }

    public Vector getTeacher_details_id1() {
        return teacher_details_id1;
        
    }

    public void setTeacher_details_id1(Vector teacher_details_id1) {
        this.teacher_details_id1 = teacher_details_id1;
    }

    public Vector getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Vector subject_id) {
        this.subject_id = subject_id;
    }
    /*
     * getter and setter end
     */
    
    
    /*
     * this method will display the values of the stream and semester
     */
    public Vector myjcombobox1()
        {
            try {
            connection =DataBaseConnection.getConnection();
            String str= "select * from class_details";
PreparedStatement ps = connection.prepareStatement(str);
ResultSet rs =ps.executeQuery();
while(rs.next())
{
        class_details.add(rs.getString(1));
        }
        connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
            return class_details;
        }
    
    
    /*
     * this method will display the values of cc.
     */
    public Vector box1ActionPerformedTeacher()
    {
        try {
            connection =DataBaseConnection.getConnection();
            String str= "select * from teacher_class where class_details_id='"+box1+"'"; 
PreparedStatement ps = connection.prepareStatement(str);
ResultSet rs =ps.executeQuery();
while(rs.next())
{
    teacher_details_id1.add(rs.getString(2));
        }
Iterator itr=teacher_details_id1.iterator();
while(itr.hasNext())
        {
            System.out.println(""+itr.next());
        }
        connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return teacher_details_id1;
    }
    
    
    /*
     * this method will clear the teacher_details_id1 vector
     */
    public void clearTeacherDetails()
    {
        teacher_details_id1.clear();
    }
    
    
    /*
     * this method will display the value of subjects
     */
    public Vector box1ActionPerformedSubject()    
    {
         try {
            connection = timetable1.model.DataBaseConnection.getConnection();
            PreparedStatement check = connection.prepareStatement("select * from time_table_details where time_table_class_id='" + box1 + "'");
            ResultSet rs = check.executeQuery();
            if (rs.toString().length() == 0) {
                PreparedStatement ps = connection.prepareStatement("select * from subject_stream where subject_stream='" + box1 + "'");
                ResultSet rs1 = ps.executeQuery();
                while (rs1.next()) {
                    subject_id.add(rs1.getString("subject_stream"));
                }
                System.out.println("subject_id: "+subject_id);
            } else {
                while (rs.next()) {
                    subject_id.add(rs.getString("time_table_class_id"));
                }
                System.out.println("subject_id: "+subject_id);
            }
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return subject_id;
    }
    
    public String done()
    {
        return "true";
    }
    
    public void clearTeacherDetails1()
    {
        boxt.clear();
    }
    
    /*
     * this method is use to get the values of subject from UI and get the teacher value from database.
     */
    public Vector myjcombobox()
    {
             try {
            connection =DataBaseConnection.getConnection();
            String str= "select * from teacher_subject where subject_details_id='"+subject+"'";
PreparedStatement ps = connection.prepareStatement(str);
ResultSet rs =ps.executeQuery();
while(rs.next())
{
    boxt.add(rs.getString(2));
        }
        connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
             return boxt;
    }
    
    public void setTeacherSubject()
    {
        try
        {
             connection =DataBaseConnection.getConnection();
String str= "select * from time_table_details where day='"+day+"'and lecture='"+lecture+"'";
PreparedStatement ps = connection.prepareStatement(str);
ResultSet rs =ps.executeQuery();
if(rs==null)
{
    Statement st = connection.createStatement();
    st.executeUpdate("INSERT into time_table_details (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id) VALUES('"+box1+"','"+day+"','"+lecture+"','"+subject+"','"+teacher+"')");
    System.out.println("1");
}
else
{
PreparedStatement stmt1=connection.prepareStatement("delete from time_table_details where day='"+day+"'and lecture='"+lecture+"'");
stmt1.executeUpdate();
Statement st = connection.createStatement();
st.executeUpdate("INSERT into time_table_details (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id,status) VALUES('"+box1+"','"+day+"','"+lecture+"','"+subject+"','"+teacher+"','"+status+"')");
System.out.println("2");
}
        connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}