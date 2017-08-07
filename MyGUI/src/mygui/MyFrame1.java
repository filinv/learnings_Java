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
public class MyFrame1 extends JFrame{
    JButton button;//поле, которое потом будет кнопкой
    
    public MyFrame1 (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel ("My Label");//создали метку, в которую можно складывать текстовые подсказки
        label.setToolTipText("Label Text");//текст подсказки при наведении мыши
        label.setText("Text");//загружает в метку другой текст
        c.add (label);
        
        button = new JButton ("My button");
        c.add (button);//добавляем данный объект в контейнер
        Handler handler = new Handler ();
        button.addActionListener(handler);
        
        setSize(400, 150);
        setVisible(true);
    }
    class Handler implements ActionListener {
    public void actionPerformed (ActionEvent e){
    if (e.getSource()== button) JOptionPane.showMessageDialog(null, "button pressed");
    }
    }
}
