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
public class MyPopupMenu extends JFrame{
    //выбор фона окна с помощью всплывающего от правой клавиши мыши меню
    
    Color [] colors = {Color.red, Color.green, Color.blue};
    JRadioButtonMenuItem [] colorItem;
    JPopupMenu pop;
     
    public MyPopupMenu(String str){
    super (str);
    
    Ihandler handler = new Ihandler ();
    String [] names = {"Red", "Green", "Blue"};
    ButtonGroup group = new ButtonGroup();
    pop = new JPopupMenu ();
    colorItem = new JRadioButtonMenuItem [3];
    for (int i=0; i<3; i++){
    colorItem [i] = new JRadioButtonMenuItem (names[i]);
    pop.add (colorItem[i]);
    group.add(colorItem[i]);
    colorItem[i].addActionListener(handler);
    }
    
    addMouseListener (new MouseAdapter(){
    public void mousePressed (MouseEvent e){
    check (e);//проверяем действительно ли произошло всплытие меню
    }
    public void mouseReleased (MouseEvent e){
    check (e);
    }
    void check (MouseEvent e){
    if (e.isPopupTrigger()){
    pop.show(e.getComponent(), e.getX(), e.getY());//что показать во всплывающем меню и где
    }
    }
    });
    
    Container c = getContentPane();
    c.setLayout (new BorderLayout());
    
    setSize (300, 100);
    setVisible (true);
    }  
    class Ihandler implements ActionListener {
    public void actionPerformed (ActionEvent e){
    for (int i = 0; i < 3; i++){
    if (e.getSource() == colorItem[i]){//если объект, который вызвал событие равен итому элементу массива цветов
    getContentPane ().setBackground(colors[i]);//назначить фон для вызванной панели
    repaint();
    return;
    }
    }
    }
    }
}