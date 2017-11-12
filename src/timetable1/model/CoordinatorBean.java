/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import timetable.Coordinator;

/**
 *
 * @author Abhishek
 */
public class CoordinatorBean //implements Runnable
{

    Connection connection;
    Vector class_details = new Vector();  //this will use to display the value of semester and stream.
    Vector teacher_name = new Vector();    //this will use to display the value of cc.
    Vector subject_id = new Vector();    //this will use to display the value of subject.
    Vector boxt = new Vector();   //this will display the vaues of teachers in accordance with subject.
    private String box1;    //this will contain the value of semester and stream.
    private String box2;    //this will contain the value of cc1.
    private String box73;    //this will contain the value of cc2.  
    private String subject;     // get the value of subject
    private String teacher;    // get the value of teacher
    private String day;
    private String lecture;
    private String status = "true";
    private int practical;
    private String lab_subject;
    Vector lab_subject_vector = new Vector();
    private Vector lab_id = new Vector();
    private String setsubject;
    private String setlab;

    public CoordinatorBean() {
        super();
    }

    public String getSetlab() {
        return setlab;
    }

    public void setSetlab(String setlab) {
        this.setlab = setlab;
    }

    public String getSetsubject() {
        return setsubject;
    }

    public void setSetsubject(String setsubject) {
        this.setsubject = setsubject;
    }

    public String getLab_subject() {
        return lab_subject;
    }

    public void setLab_subject(String lab_subject) {
        this.lab_subject = lab_subject;
    }

    public Vector getLab_subject_vector() {
        return lab_subject_vector;
    }

    public void setLab_subject_vector(Vector lab_subject_vector) {
        this.lab_subject_vector = lab_subject_vector;
    }

    public Vector getLab_id() {
        return lab_id;
    }

    public void setLab_id(Vector lab_id) {
        this.lab_id = lab_id;
    }

    /*
     * getter and setter start
     */
    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }

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

    public Vector getTeacherName() {
        return teacher_name;

    }

    public void setTeacherName(Vector teacher_name) {
        this.teacher_name = teacher_name;
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

    ////////////////////////////// clear the teacher_name vector
    public void clearTeacherDetails() {
        teacher_name.clear();
    }

    /////////////////////////////// clear the teacher_name vector
    public void clearTeacherDetails1() {
        boxt.clear();
    }
    //////////////////////////////// clear the subject_id vector

    public void clearSubjectID() {
        subject_id.clear();
    }

    /*
     * this method will display the values of the stream and semester
     */
    public Vector myjcombobox1() {
        try {
            connection = DataBaseConnection.getConnection();
            String str = "select * from class_details";
            PreparedStatement ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                class_details.add(rs.getString(1));
            }

//            String str1 = "select * from lab_details";
//            PreparedStatement ps1 = connection.prepareStatement(str1);
//            ResultSet rs1 = ps1.executeQuery();
//            while (rs1.next()) {
//                lab_id.add(rs1.getString(1));
//            }
//String str2= "select * from subject_details";
//PreparedStatement ps2 = connection.prepareStatement(str2);
//ResultSet rs2 =ps2.executeQuery();
//while(rs2.next())
//{
//    lab_subject=rs2.getString(1);
//practical=rs2.getInt(5);
//    //System.out.println(lab);
//if(practical>0)
//{
//    //System.out.println("lab1\t"+practical);
//    lab_subject_vector.add(lab_subject);///////////////////////////////////////
//}
//else
//{
//    System.out.println("lab2\t"+practical);
//}
//}


            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return class_details;
    }

    /*
     * this method will display the values of cc.
     */
    public Vector box1ActionPerformedTeacher() {
        try {
            connection = DataBaseConnection.getConnection();
            //String str= "select * from teacher_class where class_details_id='"+box1+"'"; 
            String str = "select * from teacher_details td join teacher_class tc on td.teacher_id = tc.teacher_details_id1 where class_details_id='" + box1 + "'";
            PreparedStatement ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                teacher_name.add(rs.getString("teacher_name"));
            }
            /*
             * Iterator itr=teacher_name.iterator(); while(itr.hasNext()) {
             * System.out.println(""+itr.next());
        }
             */
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return teacher_name;
    }

    /*
     * this method will display the value of subjects
     */
    public Vector box1ActionPerformedSubject() {
        try {
            connection = DataBaseConnection.getConnection();
            PreparedStatement check = connection.prepareStatement("select * from time_table_details where time_table_class_id='" + box1 + "'");
            ResultSet rs = check.executeQuery();
            if (rs.toString().length() == 0) {
                PreparedStatement ps = connection.prepareStatement("select * from subject_stream where subject_stream='" + box1 + "'");
                ResultSet rs1 = ps.executeQuery();
                while (rs1.next()) {
                    subject_id.add(rs1.getString("subject_id"));
                }
                System.out.println("subject_id: "+subject_id);
            } else {
                while (rs.next()) {
                    subject_id.add(rs.getString("time_table_subject_id"));
                }
                System.out.println("subject_id: "+subject_id);
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subject_id;
    }

    /*
     * this method is use to get the values of subject from UI and get the
     * teacher value from database.
     */
    public Vector myjcombobox() {
        try {
            connection = DataBaseConnection.getConnection();
            String str = "select * from teacher_subject where subject_details_id='" + subject + "'";
            PreparedStatement ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                boxt.add(rs.getString(2));
            }
//String str1= "select * from subject_details where subject_id='"+subject+"'";
//PreparedStatement ps1 = connection.prepareStatement(str1);
//ResultSet rs1 =ps1.executeQuery();
//while(rs1.next())
//{
//    lab_subject=rs1.getString(1);
//practical=rs1.getInt(5);
//    //System.out.println(lab);
//}
//if(practical>0)
//{
//    System.out.println("lab1\t"+practical);
//    lab_subject_vector.add(lab_subject);///////////////////////////////////////
//}
//else
//{
//    System.out.println("lab2\t"+practical);
//
//    
//}
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return boxt;
    }

    public void setTeacherSubject() {
        try {
            connection = DataBaseConnection.getConnection();
            String str = "select day, lecture, time_table_teacher_id from time_table_details where  day='" + day + "' and lecture='" + lecture + "' and time_table_teacher_id='" + teacher + "'";
            PreparedStatement ps = connection.prepareStatement(str);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = 1;
            }
            if (count == 1) {
                System.out.println("teacher already engaged");

                int response = JOptionPane.showConfirmDialog(null, "This teacher is already engaged, \t do you want to override ?",
                        "Override?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    System.out.println("Yes button clicked");
                    setTeacherSubjectOverride();
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
            } else {
                setTeacherSubject1();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTeacherSubject1() {
        try {
            connection = DataBaseConnection.getConnection();
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT into time_table_details (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id,class_councillor1,class_councillor2,status) VALUES('" + box1 + "','" + day + "','" + lecture + "','" + subject + "','" + teacher + "','" + box2 + "','" + box73 + "','" + status + "')");
            System.out.println("1");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         * if(subject==null) { System.out.println("null value"); } else { try {
         * //System.out.println(box1); connection
         * =DataBaseConnection.getConnection(); String str= "select
         * time_table_class_id, day, lecture from time_table_details where
         * time_table_class_id='"+box1+"' and day='"+day+"' and
         * lecture='"+lecture+"'"; PreparedStatement ps =
         * connection.prepareStatement(str); ResultSet rs =ps.executeQuery();
         * int count=0; while(rs.next()) { count=1; } if(count==0) { Statement
         * st = connection.createStatement(); st.executeUpdate("INSERT into
         * time_table_details
         * (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id,class_councillor1,class_councillor2,status)
         * VALUES('"+box1+"','"+day+"','"+lecture+"','"+subject+"','"+teacher+"','"+box2+"','"+box73+"','"+status+"')");
         * System.out.println("1"); } else { PreparedStatement
         * stmt1=connection.prepareStatement("delete from time_table_details
         * where time_table_class_id='"+box1+"' and day='"+day+"'and
         * lecture='"+lecture+"'"); stmt1.executeUpdate(); Statement st =
         * connection.createStatement(); st.executeUpdate("INSERT into
         * time_table_details
         * (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id,class_councillor1,class_councillor2,status)
         * VALUES('"+box1+"','"+day+"','"+lecture+"','"+subject+"','"+teacher+"','"+box2+"','"+box73+"','"+status+"')");
         * System.out.println("2"); } connection.close(); } catch(Exception e) {
         * e.printStackTrace(); }
        }
         */

    }

    public String done() {
        return "true";
    }

    public void setTeacherSubjectOverride() {
        try {
            connection = DataBaseConnection.getConnection();
            PreparedStatement stmt1 = connection.prepareStatement("delete from time_table_details where time_table_class_id='" + box1 + "' and day='" + day + "'and lecture='" + lecture + "'");
            stmt1.executeUpdate();
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT into time_table_details (time_table_class_id,day,lecture,time_table_subject_id,time_table_teacher_id,class_councillor1,class_councillor2,status) VALUES('" + box1 + "','" + day + "','" + lecture + "','" + subject + "','" + teacher + "','" + box2 + "','" + box73 + "','" + status + "')");
            System.out.println("2");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLabSubject() {
        try {
            connection = DataBaseConnection.getConnection();
            Statement st = connection.createStatement();
            st.executeUpdate("insert into time_table_lab_subject (time_table_class_id1,time_table_subject_id1,time_table_lab_id1) values('" + box1 + "','" + setsubject + "','" + setlab + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLabSubject() {
        try {
            connection = DataBaseConnection.getConnection();
            String str2 = "select * from subject_details";
            PreparedStatement ps2 = connection.prepareStatement(str2);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                lab_subject = rs2.getString(1);
                practical = rs2.getInt(5);
                //System.out.println(lab);
                if (practical > 0) {
                    //System.out.println("lab1\t"+practical);
                    lab_subject_vector.add(lab_subject);///////////////////////////////////////
                } else {
                    System.out.println("lab2\t" + practical);
                }
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}