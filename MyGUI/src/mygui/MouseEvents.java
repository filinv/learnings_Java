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
public class MouseEvents extends JFrame implements MouseMotionListener, MouseListener{
    JTextField text;
    
    public MouseEvents (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        
        text = new JTextField ("                                            ");
        c.add(text);
        
    addMouseListener(this);//приложение слушает события мыши, которые произошли в его окне
    addMouseMotionListener(this);//вверху обязательно нужно упомянуть про реализацию этих двух интерфейсов
    
    setSize (300, 100);
    setVisible (true);
    }
    public void mouseClicked (MouseEvent e){
    text.setText("Ckicked in (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mousePressed (MouseEvent e){
    text.setText("Pressed in (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseReleased (MouseEvent e){//кнопка отпущена
    text.setText("Released in (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseEntered (MouseEvent e){//входит в пределы компонента
    text.setText("Mouse entered in component");
    }
    public void mouseExited (MouseEvent e){//покинула пределы компонента
    text.setText("Mouse Exited component");
    }
    public void mouseDragged (MouseEvent e){//это уже из обработчика событий
    //MouseMoutionListener перетаскивание с зажимом
    text.setText("Drag in (" + e.getX() + ", " + e.getY() + ")");
    }
    public void mouseMoved (MouseEvent e){//перемещение мыши
    text.setText("Move in (" + e.getX() + ", " + e.getY() + ")");
    }
}