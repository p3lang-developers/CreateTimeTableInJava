/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Abhishek
 */
public class four {
    public static void main(String args[])
    {
        Frame frame=new Frame();
        frame.addWindowListener(
                new WindowListener()
                        {
                            public void windowClosing(WindowEvent e)
                            {
                                System.exit(0);
                            }
                            public void windowClosed(WindowEvent e)
                            {
                                System.out.println("closed");
                            }
                            public void windowOpened(WindowEvent e)
                            {
                                System.out.println("open");
                            }
                            public void windowIconified(WindowEvent e)
                            {
                                System.out.println("mimize");
                            }
                            public void windowDeiconified(WindowEvent e)
                            {
                                System.out.println("maximized");
                            }
                            public void windowActivated(WindowEvent e)
                            {
                                System.out.println("activated");
                            }
                             public void windowDeactivated(WindowEvent e)
                            {
                                System.out.println("deactivated");
                            }
                        });
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
