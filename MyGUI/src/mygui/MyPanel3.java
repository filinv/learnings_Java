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

//будем щёлкать мышью, и в местах щелчков будут появляться прямоугольнички

class MyPanel3a extends JPanel {
int x, y;
public MyPanel3a(){
addMouseListener (new MouseAdapter(){
public void mousePressed (MouseEvent e){
x = e.getX();
y = e.getY();
repaint();
}
});
}
public void paintComponent (Graphics g){
super.paintComponent (g);
g.fillRect(x, y, 10, 10);
}
}

public class MyPanel3 extends JFrame{
    
   MyPanel3a myPanel;
   public MyPanel3(String str){
    super (str);
    myPanel = new MyPanel3a();
   
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    c.add(myPanel, BorderLayout.CENTER);
    
    setSize (300, 100);
    setVisible (true);
    }
}