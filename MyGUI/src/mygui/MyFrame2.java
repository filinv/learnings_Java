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
public class MyFrame2 extends JFrame{
    JTextField text;
    JComboBox box;
    String [] colors = {"red", "blue", "green"};//массив строк, который и будет элементами выпадающего списка
    
    public MyFrame2 (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel ("My Label");//создали метку, в которую можно складывать текстовые подсказки
        label.setToolTipText("Label Text");//текст подсказки при наведении мыши
        label.setText("Text");//загружает в метку другой текст
        c.add (label);
        
        text = new JTextField ("Text");
        c.add(text);
        
        box = new JComboBox (colors);//объект класса JComboBox
        box.addItemListener(new ItemListener(){//анонимный внутренний класс
        public void itemStateChanged (ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){//сброшен или установлен переключатель
        if (box.getSelectedIndex()== 0)//проверяем выбранный индекс
            text.setBackground(Color.red);
        else if (box.getSelectedIndex() == 1) text.setBackground(Color.blue);
        else text.setBackground(Color.green);
        }
        }
        });
        c.add(box);//помещаем созданный блок в контейнер
        
        setSize(400, 150);
        setVisible(true);
    }
}