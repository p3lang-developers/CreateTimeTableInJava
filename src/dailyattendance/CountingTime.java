/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyattendance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Abhishek
 */
public class CountingTime {

    Timer timer = new Timer();
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date1 = new Date();
    String time1 = sdf1.format(date1);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str = "00:01:00";
    Date date;
    //date=sdf.parse(str);

    public CountingTime() {
        try {
            String str1 = time1.substring(0, 11);
            //String str1="16:00:00";
            String str2 = str1.concat(str);
            date = sdf.parse(str2);
            System.out.println(date);
            timer.schedule(new ScheduleTask(), date);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
