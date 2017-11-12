/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;


/**
 *
 * @author Abhishek
 */
public class one {
    public static void main(String args[])
    {
        Frame frame=new Frame("awt frame");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        //frame.setLayout(null);
        //frame.setDefaultCloseOperation(Frame.);
        Button btn=new Button("ok");
        frame.add(btn);
        //btn.setBounds(400, 400, 100, 100);
    }
}
