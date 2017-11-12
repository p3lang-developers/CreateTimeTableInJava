/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Abhishek
 */
public class gridlayout {
    public static void main(String args[])
    {
        GridLayout gl=new GridLayout(2,3);
        JFrame frame =new JFrame("grid layout");
        frame.setLayout(gl);
         JButton btn1=new JButton("one");
        JButton btn2=new JButton("two");
        JButton btn3=new JButton("three");
        JButton btn4=new JButton("four");
        JButton btn5=new JButton("five");
        JButton btn6=new JButton("six");
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
