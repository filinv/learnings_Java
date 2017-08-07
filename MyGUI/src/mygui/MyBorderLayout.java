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
public class MyBorderLayout extends JFrame{
   BorderLayout layout;
    public MyBorderLayout(String str){
    super (str);
    Container c = getContentPane();
    layout = new BorderLayout(4, 4);//параметр-размер зазора в пикселях между компонентами
    JButton b1 = new JButton ("1");
    JButton b2 = new JButton ("2");
    JButton b3 = new JButton ("3");
    JButton b4 = new JButton ("4");
    JButton b5 = new JButton ("5");
    /*
    JButton b10 = new JButton ("AFTER_LAST_LINE(PAGE_END)");//самый низ(замещают собой стороны света)
    JButton b20 = new JButton ("AFTER_LINE_ENDS(LINE_END)");//самое правое расположение
    JButton b30 = new JButton ("BEFORE_FIRST_LINE(PAGE_START)");//самый верх
    JButton b40 = new JButton ("BEFORE_LINE_BEGINS(LINE_START)");//самое левое расположение
    */
    c.add(b1, BorderLayout.NORTH);
    c.add(b2, BorderLayout.SOUTH);
    c.add(b3, BorderLayout.WEST);
    c.add(b4, BorderLayout.EAST);
    c.add(b5, BorderLayout.CENTER);
    /*
    c.add(b10, BorderLayout.AFTER_LAST_LINE);
    c.add(b20, BorderLayout.AFTER_LINE_ENDS);
    c.add(b30, BorderLayout.BEFORE_FIRST_LINE);
    c.add(b40, BorderLayout.BEFORE_LINE_BEGINS);
    */   
    setSize (300, 100);
    setVisible (true);
    }
}