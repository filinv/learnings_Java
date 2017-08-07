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
public class MyLayout extends JFrame{
    FlowLayout layout;//создаём переменную для задания с помощью неё других вариантов расположения
    public MyLayout(String str){
    super (str);
    Container c = getContentPane();
    layout = new FlowLayout();
    layout.setAlignment(FlowLayout.RIGHT);//метод для выравнивания всех компонентов контейнера
    c.setLayout(layout);
    //layout.layoutContainer(c);//при выполнении этого метода происходит перераспределение компонентов GUI
    
    JButton b1 = new JButton ("First");
    JButton b2 = new JButton ("Second");
    JButton b3 = new JButton ("Third");
    c.add(b1);
    c.add(b2);
    layout.setAlignment(FlowLayout.CENTER);
    layout.layoutContainer(c);//сначала компоненты выравнивались по правому краю, 
//а после вызова этого метода перераспределились по центру
    c.add(b3);
    
    setSize (300, 100);
    setVisible (true);
    }
}