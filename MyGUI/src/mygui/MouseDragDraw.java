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
public class MouseDragDraw extends JFrame{
    JTextField text;
    int x = 0;
    int y = 0;
    
    public MouseDragDraw (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        
        text = new JTextField ("                                            ");
        c.add(text);
        
    addMouseMotionListener(new MouseMotionAdapter (){
    public void mouseDragged (MouseEvent e){
    x= e.getX();
    y = e.getY();
    repaint();
    }
    });
    
    setSize (300, 100);
    setVisible (true);
    }
    public void paint (Graphics g){
    g.fillRect(x, y, 2, 2);
    }
}