/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author user
 */
public class MyPanel extends JFrame{
   GridLayout layout;
   JPanel p1;//панели для вмещения сложного графического содержимого
   JPanel p2;
    public MyPanel(String str){
    super (str);
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    
    p1 = new JPanel ();
    p2 = new JPanel ();
    JButton b1 = new JButton ("1");
    JButton b2 = new JButton ("2");
    JButton b3 = new JButton ("3");
    
    p1.setLayout(new GridLayout(2, 2));
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);
    
    JButton b4 = new JButton ("4");
    JButton b5 = new JButton ("5");
    JButton b6 = new JButton ("6");
    
    p2.setLayout(new FlowLayout());
    p2.add(b4);
    p2.add(b5);
    p2.add(b6);
    
    c.add(p1, BorderLayout.NORTH);
    c.add(p2, BorderLayout.SOUTH);
    
    setSize (300, 100);
    setVisible (true);
    }
}