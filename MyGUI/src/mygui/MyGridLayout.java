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
public class MyGridLayout extends JFrame{
   GridLayout layout;
    public MyGridLayout(String str){
    super (str);
    Container c = getContentPane();
    layout = new GridLayout (2, 3, 5, 5);//число строк и столбцов будущей таблицы, размер зазоров
    c.setLayout(layout);
    JButton b1 = new JButton ("1");
    JButton b2 = new JButton ("2");
    JButton b3 = new JButton ("3");
    JButton b4 = new JButton ("4");
    JButton b5 = new JButton ("5");
    JButton b6 = new JButton ("6");
    
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(b4);
    c.add(b5);
    c.add(b6);
      
    setSize (300, 100);
    setVisible (true);
    }
}