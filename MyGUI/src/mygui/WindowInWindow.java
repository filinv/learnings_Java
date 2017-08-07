/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author user
 */
public class WindowInWindow extends JFrame{
    //встроенные окна
    JDesktopPane desktop;
    
    public WindowInWindow(String str){
    super (str);
    
    Container c = getContentPane();
    desktop = new JDesktopPane();//объект для управления дочерними окнами
    c.add(desktop);
    JInternalFrame first = new JInternalFrame ("First", true, true, true, true);
    //заголовок, можно ли менять размер окна, закрывать, разворачивать, свёртывать
    JButton b1 = new JButton ("First");
    Container c1 = first.getContentPane();//получить контейнер для первого окна
    c1.setLayout(new FlowLayout());
    c1.add(b1);
    first.setSize(100, 100);
    desktop.add(first);
    first.setVisible(true);
    
    JInternalFrame second = new JInternalFrame ("Second", false, true, true, true);
    second.setSize(100, 100);
    desktop.add(second);
    second.setVisible(true);
    
    setSize (300, 100);
    setVisible (true);
    }
}