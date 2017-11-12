/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyattendance;

/**
 *
 * @author Abhishek
 */
public class ClassDayLectureSubject extends GenerateSchedule{
    private String class_id;
    private String day;
    private String lecture;
    private String subject;

   
    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
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
    
//    public void makeArrangement()
//    {
//        System.out.println("1");
//        System.out.println(present_teacher);
//        System.out.println(total_teacher);
//        System.out.println("2");
//    }
            
}
