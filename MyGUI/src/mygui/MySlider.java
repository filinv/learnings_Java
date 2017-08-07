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

//в некоторой панели будет рисоваться толстая линия размером с позицию ползунка

class MyPanel4 extends JPanel {
int length = 5;
public void paintComponent (Graphics g){
super.paintComponent(g);
g.fillRect(5, 5, length, 5);
}
public void setLength (int length){
this.length = (length >0? length : 5);//если >=0 то присваивай length, иначе =5
repaint();
}
}
public class MySlider extends JFrame{
   MyPanel4 panel;
   JSlider slider;
   public MySlider(String str){
    super (str);
    
    panel = new MyPanel4();
    slider = new JSlider (SwingConstants.HORIZONTAL, 0, 200, 5);//горизонтальный бегунок
    //со значениями от 0 до 200, изначальная позиция бегунка 5
    slider.setMajorTickSpacing(5);//минимальный шаг передвижения бегунка
    slider.setPaintTicks(true);//добавляет деления(убирает полоску, по которой движется бегунок)
    slider.setPaintLabels(false);//нумерация значений с шагом в минимальный шаг
    slider.setPaintTrack(true);//отображать полоску, по которой движется бегунок
    slider.addChangeListener(new ChangeListener (){//слушатель для бегунка
    public void stateChanged (ChangeEvent e){
    panel.setLength(slider.getValue());//в качестве длины панели устанавливаем значение бегунка
    }
    });
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    c.add(slider, BorderLayout.SOUTH);
    c.add(panel, BorderLayout.CENTER);
    
    setSize (300, 100);
    setVisible (true);
    }
}