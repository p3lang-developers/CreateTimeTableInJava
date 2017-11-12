/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abhishek
 */
public class Button {
    public static void main(String args[])
    {
        JFrame frame=new JFrame("button");
        frame.setVisible(true);
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel=new JPanel();
        frame.add(panel);
        
        JLabel label=new JLabel("hello");
        
        //frame.add(label);
        panel.add(label);
        JButton button=new JButton("hello again");
        panel.add(button);
    }
}
