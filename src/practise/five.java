/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Abhishek
 */
public class five {
    public static void main(String args[])
    {
        final Frame frame=new Frame();
        frame.addWindowListener(
                new WindowAdapter() {
                public void windowClosing(WindowEvent e) 
                {
                    System.out.println("trying to close");
                    frame.dispose();
                }});
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
