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
class MyPanel1 extends JPanel {
//нарисуем цветной прямоугольник, который после нажатие кнопок будет менять свой цвет
    public final static int RED = 1, GREEN = 2, YELLOW = 3;
    int color;
    public void paintComponent (Graphics g){
    super.paintComponent(g);
    if (color == RED) g.setColor(Color.red);
    else if (color == GREEN) g.setColor(Color.green);
    else if (color == YELLOW) g.setColor(Color.yellow);
    
    g.fillRect (50, 10, 60, 60);
    }
    public void draw (int color){
    this.color = color;
    repaint ();
    }
}

public class MyPanel2 extends JFrame{
    MyPanel1 myPanel;
    JPanel buttons;
    JButton redButton, greenButton, yellowButton;
   
   public MyPanel2(String str){
    super (str);
    myPanel = new MyPanel1();
    redButton = new JButton("RED");
    redButton.addActionListener(new ActionListener (){
    public void actionPerformed (ActionEvent e){
    myPanel.draw(MyPanel1.RED);
    }
    });
    greenButton = new JButton("GREEN");
    greenButton.addActionListener(new ActionListener (){
    public void actionPerformed (ActionEvent e){
    myPanel.draw(MyPanel1.GREEN);
    }
    });
    yellowButton = new JButton("YELLOW");
    yellowButton.addActionListener(new ActionListener (){
    public void actionPerformed (ActionEvent e){
    myPanel.draw(MyPanel1.YELLOW);
    }
    });
    
    buttons = new JPanel();
    buttons.setLayout(new GridLayout(1, 3));
    buttons.add(redButton);
    buttons.add(greenButton);
    buttons.add(yellowButton);
    
    
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    
    c.add(myPanel, BorderLayout.CENTER);
    c.add(buttons, BorderLayout.SOUTH);
    
    
    setSize (300, 100);
    setVisible (true);
    }
}