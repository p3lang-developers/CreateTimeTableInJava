/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek
 */
class a implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "i got clicked");
    }
}
public class two {
    public static void main(String args[])
    {
        Frame frame=new Frame("awt frame");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        Button btn=new Button("ok");
        frame.add(btn);
        
        a a1=new a();
        btn.addActionListener(a1);
    }
}
