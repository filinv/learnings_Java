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
public class MyTextArea extends JFrame{
   JTextArea text;
   JButton button;
   public MyTextArea(String str){
    super (str);
    Container c = getContentPane();
    c.setLayout(new GridLayout(1, 2));
    
    text = new JTextArea ("", 10, 15);//строка и размеры текстового поля
    text.setLineWrap(true);//для перехода на след.строку во время набора текста
    c.add(text);
    button = new JButton ("Submit");
    button.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
    JOptionPane.showMessageDialog(null, text.getText());//в диалоговом окне выводить 
    //текст, который пользователь введёт в пустое поле до нажатия кнопки
    }
    });
    c.add(button);
    
    setSize (300, 100);
    setVisible (true);
    }
}