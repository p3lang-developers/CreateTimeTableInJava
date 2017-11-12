/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Abhishek
 */
public class girdbaglayout1 {
    public static void main(String args[])
    {
    JFrame frame=new JFrame();
    GridBagLayout gl=new GridBagLayout();
    GridBagConstraints gbc=new GridBagConstraints();
    JPanel panel=new JPanel();
    panel.setLayout(gl);
    JLabel label=new JLabel("name");
    gbc.gridx=0;
    gbc.gridy=0;
    panel.add(label,gbc);
    final JTextField jtf = new JTextField(20);
    gbc.gridx=1;
    gbc.gridy=0;
    //gbc.insets=new Insets(0,0,10,0);
    panel.add(jtf,gbc);
    JButton btnok = new JButton("ok");
    JButton btncancel = new JButton("cancel");
    
    final JTextArea jta = new JTextArea(5,20);
    jta.setLineWrap(true);  //column ki widh same rheti he..agar content zada he to isi text area ke andar niche a jata he
    
    JScrollPane sp= new JScrollPane(jta);
    gbc.gridx=0;
    gbc.gridy=1;
    //gbc.insets = new Insets(0,0,0,0);
    //gbc.anchor=gbc.WEST;
    
    panel.add(sp,gbc);
    JPanel btnPanel=new JPanel();
    btnPanel.add(btnok);
    btnPanel.add(btncancel);
    gbc.gridx=1;
    gbc.gridy=2;
    //gbc.insets=new Insets(20, 0, 0, 0);
    panel.add(btnPanel,gbc);
    
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setVisible(true);
    btnok.addActionListener(
            new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         jta.setText(jtf.getText());
         jtf.setText("");
         
            }
        });
    
}
}