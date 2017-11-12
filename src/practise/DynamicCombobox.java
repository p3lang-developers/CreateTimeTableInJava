package practise;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DynamicCombobox {

public static void main(final String args[])throws Exception {
JFrame frame = new JFrame();
frame.setLayout(null);
JLabel lab1=new JLabel("Course");
        final JComboBox combo1=new JComboBox();
        combo1.addItem("--Select--");
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?" + "user=root&password=abhi");
           final Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from teacher");

           while(rs.next()){
           combo1.addItem(rs.getString("courseName"));
           }
           JLabel lab2=new JLabel("Semester");
           final JComboBox combo2=new JComboBox();
           JLabel lab3=new JLabel("Subjects");
           final JComboBox combo3=new JComboBox();

    combo1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        try{
    ItemSelectable is = (ItemSelectable)e.getSource();
    String str=selectedString(is);
    ResultSet rs1 = st.executeQuery("Select semester from course c,semester s where c.courseName='"+str+"' and c.courseid=s.courseid"); 
    while(rs1.next()){
        combo2.addItem(Integer.toString(rs1.getInt("semester")));
    }
    combo2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e1) {
    ItemSelectable isb = (ItemSelectable)e1.getSource();
    int sem=Integer.parseInt(selectedString(isb));
    try{
    ResultSet rs2 = st.executeQuery("Select subjects from semester s,subjects sub where s.semester="+sem+" and s.semesterid=sub.semesterid"); 
    while(rs2.next()){
        combo3.addItem(rs2.getString("subjects"));
    }
    }
    catch(Exception exception){}

    }
    });
        }
        catch(Exception ex){}
    }
    });
    lab1.setBounds(10,10,100,20);
    combo1.setBounds(120,10,100,20);

    lab2.setBounds(10,40,100,20);
    combo2.setBounds(120,40,100,20);

    lab3.setBounds(10,70,100,20);
    combo3.setBounds(120,70,100,20);

    frame.add(lab1);
    frame.add(combo1);

    frame.add(lab2);
    frame.add(combo2);

    frame.add(lab3);
    frame.add(combo3);

    frame.pack();
    frame.setVisible(true);
    }
    static private String selectedString(ItemSelectable is) {
    Object selected[] = is.getSelectedObjects();
    return ((selected.length == 0) ? "null" : (String)selected[0]);
    }
}