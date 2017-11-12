/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyattendance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Abhishek
 */
public class ScheduleTask extends TimerTask{
 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = sdf.format(date);
    @Override
    public void run() {
        System.out.println("hello");
        GenerateSchedule gs=new GenerateSchedule();
        gs.todayAttendance();
        
        System.out.println("hello1");
        System.exit(0);
    }
        
}