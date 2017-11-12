/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Abhishek
 */
public class borderlayout {
    public static void main(String args[])
    {
        BorderLayout bl = new BorderLayout(50,100);
        JFrame frame=new JFrame("frame");
        frame.setLayout(bl);
        JButton btn1=new JButton("one");
        JButton btn2=new JButton("two");
        JButton btn3=new JButton("three");
        JButton btn4=new JButton("four");
        JButton btn5=new JButton("five");
        frame.add(btn1,BorderLayout.NORTH);
        frame.add(btn2,BorderLayout.SOUTH);
        frame.add(btn3,BorderLayout.WEST);
        frame.add(btn4,BorderLayout.EAST);
        frame.add(btn5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
