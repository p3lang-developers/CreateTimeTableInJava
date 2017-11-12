/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek
 */
public class three implements ActionListener
{

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1)
            JOptionPane.showMessageDialog(null, "btn1");
        else if(e.getSource()==btn2)
            JOptionPane.showMessageDialog(null, "btn2");
               //if(e.getActionCommand().equals(btn1))
            //JOptionPane.showMessageDialog(null, "btn1");
        //else if(e.getActionCommand().equals(btn2))
          //  JOptionPane.showMessageDialog(null, "btn2");
        //JOptionPane.showMessageDialog(null, long.toString(e.getWhen()));
}
static JFrame frame=new JFrame("");
static JButton btn1=new JButton("one");
static JButton btn2=new JButton("two");
    public static void main(String args[])
    {
        three t=new three();
        frame.setLayout(new FlowLayout());
        btn1.addActionListener(t);
        btn2.addActionListener(t);
        frame.setSize(300, 300);
        frame.add(btn1);
        frame.add(btn2);
        frame.setVisible(true);
        
    }
}