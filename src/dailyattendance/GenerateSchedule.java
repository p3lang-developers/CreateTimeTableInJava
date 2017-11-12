/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyattendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Abhishek
 */
public class GenerateSchedule {
    
    Connection connection;
    
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = sdf.format(date);
    List present_teacher =new ArrayList();
    List total_teacher =new ArrayList();
    List absent_teacher ;
    String get_absent_teacher;
    List free_teacher=new ArrayList();
    String s;
    String arranged_id;
    
    String class_id;
    String day;
    String lecture;
    String subject;
    String class_councillor1;
    String class_councillor2;
    
    int subject_fitness;
    //String subject_fitness;
    int lecture_fitness;
    //String lecture_fitness;
    int absent_teacher_size;
    int total_fittness;
    //String total_fittness;
    HashMap<String,Integer> ht=new HashMap<String,Integer>();
    int i=0;
    //ArrayList<ArrayList<String>> details_absent_teacher=new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> details_absent_teacher;    //  details_absent_teacher arraylist is type of arraylist that accept arraylist 
                                                            //,and that arraylist will accept string
    
    ArrayList classdaylecturesubject=new ArrayList();

    public List getAbsent_teacher() {
        return absent_teacher;
    }

    public void setAbsent_teacher(List absent_teacher) {
        this.absent_teacher = absent_teacher;
    }

    public ArrayList getClassdaylecturesubject() {
        return classdaylecturesubject;
    }

    public void setClassdaylecturesubject(ArrayList classdaylecturesubject) {
        this.classdaylecturesubject = classdaylecturesubject;
    }

    public ArrayList<ArrayList<String>> getDetails_absent_teacher() {
        return details_absent_teacher;
    }

    public void setDetails_absent_teacher(ArrayList<ArrayList<String>> details_absent_teacher) {
        this.details_absent_teacher = details_absent_teacher;
    }

    public List getPresent_teacher() {
        return present_teacher;
    }

    public void setPresent_teacher(List present_teacher) {
        this.present_teacher = present_teacher;
    }

    public List getTotal_teacher() {
        return total_teacher;
    }

    public void setTotal_teacher(List total_teacher) {
        this.total_teacher = total_teacher;
    }
    
    
        
    /*
     * this method give the value of the present teacher, absent teacher and total teacher
     */
    public void todayAttendance()
    {
        details_absent_teacher=new ArrayList<ArrayList<String>>();
        //details_absent_teacher.add(new ArrayList<String>());
        try
        {
            String s=time.substring(0,11);
            String s1="00:00:00";
            String s2=s.concat(s1);
            connection =AttendanceDatabaseConnection.getConnection();
            String str="select today_teacher_id from today_attendance where today_date='"+s2+"'";
            PreparedStatement ps=connection.prepareStatement(str);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
{
    present_teacher.add(""+rs.getString(1));              //present teachers 
}
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            connection =AttendanceDatabaseConnection.getConnection();
            String str="select teacher_id from teacher_details";
            PreparedStatement ps=connection.prepareStatement(str);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
{
    //System.out.println("hello1");
    total_teacher.add(""+rs.getString(1));              //total teachers 
}
            connection.close();
        }
        catch(Exception e)
        {
            
        }       
            absent_teacher =new ArrayList(total_teacher);
            absent_teacher.removeAll(present_teacher);              //absent teachers 
            
        ListIterator itr1=absent_teacher.listIterator();
        while(itr1.hasNext())
        {
            System.out.println("absent\t"+itr1.next());
        }
        absent_teacher_size=absent_teacher.size();
        while(i<absent_teacher_size)
        {
        get_absent_teacher=(String)absent_teacher.get(i);       //fetch the [i]th element from absent_teacher arraylist 
        getAbsentTeacherDetails();                              //get all the details of absent teachers
        i++;
        }
        System.out.println("\n");
        System.out.println("abesnt teacher");
        System.out.println(details_absent_teacher);
        
        getIndividualAbsentTeacherDetails();                                //get all the details of absent teachers one by one
        
        
    }
    
    
    public void getAbsentTeacherDetails()
    {
        try
        {
            connection=AttendanceDatabaseConnection.getConnection();
            String str="select * from time_table_details where time_table_teacher_id='"+get_absent_teacher+"' ";
            PreparedStatement ps=connection.prepareStatement(str);
            ResultSet rs=ps.executeQuery();
            details_absent_teacher.add(new ArrayList<String>());
            while(rs.next())
            {
            //details_absent_teacher.add(new ArrayList<String>());
            details_absent_teacher.get(i).add(rs.getString(2));
            details_absent_teacher.get(i).add(rs.getString(3));
            details_absent_teacher.get(i).add(rs.getString(4));
            details_absent_teacher.get(i).add(rs.getString(5));
            details_absent_teacher.get(i).add(rs.getString(6));
            details_absent_teacher.get(i).add(rs.getString(7));
            details_absent_teacher.get(i).add(rs.getString(8));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        //System.out.println("total arrangement required for today "+a);
    }
    
    public void getIndividualAbsentTeacherDetails()
    {
        System.out.println("\n");
    ListIterator itr=details_absent_teacher.listIterator();
        while(itr.hasNext())                        //1st while loop begin
        {
            
            ArrayList al=(ArrayList) itr.next();
            //subjects.add(al);
             ListIterator itr1=al.listIterator();
             System.out.println("\n");
             System.out.println("list"+al.size());
             
            while(itr1.hasNext())                        //2nd while loop begin
            {
//                subjects.add();
//                System.out.println(itr1.next());
//                ClassDayLectureSubject cdls=new ClassDayLectureSubject();
//                cdls.setClass_id((String)itr1.next());
//                cdls.setDay((String)itr1.next());
//                cdls.setLecture((String)itr1.next());
//                cdls.setSubject((String)itr1.next());
//                classdaylecturesubject.add(cdls);
                
//                System.out.println(classdaylecturesubject);
//                System.out.println(itr1.next());
                
//                cdls.makeArrangement();
                
                
                class_id=((String)itr1.next());
                day=((String)itr1.next());
                lecture=((String)itr1.next());
                subject=((String)itr1.next());
                
                //System.out.println("s1"+subject);
                System.out.println("arrangement for\t"+itr1.next());
                class_councillor1=((String)itr1.next());
                class_councillor2=((String)itr1.next());
                ListIterator solution_present_teacher=present_teacher.listIterator();
                //System.out.println(present_teacher);
               
                if(present_teacher.isEmpty())
                {
                    System.out.println("it seems today is holiday");
                }
                else
                {
                   while(solution_present_teacher.hasNext())                        //3rd while loop begin
                {
                    s=(String) solution_present_teacher.next();
                    //System.out.println("s"+s);
                try
                {
                    //System.out.println("hi");
            connection =AttendanceDatabaseConnection.getConnection();
            String str="select * from time_table_details where day='"+day+"' and lecture='"+lecture+"' and time_table_subject_id='"+subject+"' and time_table_teacher_id='"+s+"'";
            PreparedStatement ps=connection.prepareStatement(str);
            ResultSet rs=ps.executeQuery();
            int status=0;
            while(rs.next())
{
    status++;
//    present_teacher.add(""+rs.getString(1));              //present teachers 
    System.out.println("hi");
}
            if(status>0)
            {
                System.out.println("status1\t"+status);
            }
            else
            {
                //System.out.println("status2\t"+status);
                
                System.out.println("present teacher\t"+s);
                fitness();                                              //method call for calculation of fittness number.
                total_fittness=lecture_fitness+subject_fitness;
                System.out.println("total_fittness\t"+total_fittness);
                //////////////////////////////////////
                ht.put(s, total_fittness);
                //free_teacher.add(s);
                System.out.println(ht);
            }
            
            connection.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                }                        //3rd while loop end
                   
                   System.out.println("end");
                   
                   selectFitest();                      //method call to get maximum fittest teacher.
                   
                   
                }                        //else end
            }                        //2nd while loop and
          }                        //1st while loop end
    }                       //end method getIndividualAbsentTeacherDetails()
    public void fitness()
    {
        //System.out.println("s\t"+free_teacher);
        try
        {
            connection=AttendanceDatabaseConnection.getConnection();
            //System.out.println("s2"+subject);
            PreparedStatement ps=connection.prepareStatement("select * from teacher_subject where teacher_details_id='"+s+"' and subject_details_id='"+subject+"'");
            ResultSet rs=ps.executeQuery();
            int status=0;
            while(rs.next())
            {
                status++;
            }
            if(status>0)
            {
                subject_fitness=10;
            }
            else
            {
                subject_fitness=0;
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            connection=AttendanceDatabaseConnection.getConnection();
            //System.out.println("s2"+subject);
            PreparedStatement ps=connection.prepareStatement("select * from time_table_details where time_table_teacher_id='"+s+"' and day='"+day+"'");
            ResultSet rs=ps.executeQuery();
            int status=0;
            while(rs.next())
            {
                status++;
            }
            if(status>0)
            {
                lecture_fitness=7-status;
            }
            else
            {
                lecture_fitness=7;
            }
            
            connection=AttendanceDatabaseConnection.getConnection();
            //System.out.println("s2"+subject);
            PreparedStatement ps1=connection.prepareStatement("select * from arrangement where arrangement_teacher_id='"+s+"' and arrangement_day='"+day+"'");
            ResultSet rs1=ps1.executeQuery();
            int status1=0;
            while(rs1.next())
            {
                status1++;
            }
            if(status1>0)
            {
                lecture_fitness=lecture_fitness-status1;
            }
            else
            {
                //lecture_fitness=7;
            }
            
        }
        catch(Exception e)
        {
            
        }
    }
    public void selectFitest()
    {
        
        ValueComparator bvc =  new ValueComparator(ht);
                TreeMap<String,Integer> sorted_map = new TreeMap(bvc);
                sorted_map.putAll(ht);

        System.out.println("results");
        //System.out.println("ye lo\t"+sorted_map.keySet());
//        int a=sorted_map.get(0);
//        System.out.println("a"+a);
        for (String key : sorted_map.keySet()) {
            //System.out.println("key/value: " + key + "/"+sorted_map.get(key));
            arranged_id=key;
            int i=sorted_map.get(key);
            System.out.println("key/value: " + arranged_id + "/"+i);
            
            
        try
        {
            connection=AttendanceDatabaseConnection.getConnection();
Statement st = connection.createStatement();
st.executeUpdate("INSERT into arrangement (arrangement_class_id,arrangement_day,arrangement_lecture,arrangement_subject_id,arrangement_teacher_id,arrangement_class_councillor1,arrangement_class_councillor2,arrangement_status) VALUES('"+class_id+"','"+day+"','"+lecture+"','"+subject+"','"+arranged_id+"','"+class_councillor1+"','"+class_councillor2+"','"+true+"')");
connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
            break;
        }
        //System.out.println("ye lo\t"+sorted_map.keySet());
        
        //sorted_map.higherEntry();
        System.out.println("\n");
    }
}
