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
public class MyFrame extends JFrame{
    JTextField field1;
    JPasswordField field2;
    /*
    public void paint (Graphics g){
        g.setFont (new Font ("Serif", Font.ITALIC, 30));
        g.drawString("Hello Java!", 20, 100);
    }
    */
    public MyFrame (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel ("My Label");//создали метку, в которую можно складывать текстовые подсказки
        label.setToolTipText("Label Text");//текст подсказки при наведении мыши
        label.setText("Text");//загружает в метку другой текст
        c.add (label);
        
        field1 = new JTextField("Text");//текст по дефолту для поля ввода текста
        c.add (field1);//добавили поле в окно
        field2 = new JPasswordField ("Hidden Text");
        c.add (field2);
        /*
        JLabel label2 = new JLabel ("My Label2");//создали метку, в которую можно складывать текстовые подсказки
        c.add (label2);
        */
        setSize(400, 150);
        setVisible(true);
        //реализация интерфейса обработчика событий:
FieldHandler handler = new FieldHandler ();
//регистрируем обработчиков:
field1.addActionListener (handler);
field2.addActionListener (handler);
        
    }    
class FieldHandler implements ActionListener {
        public void actionPerformed (ActionEvent e){
            //определяем в каком из полей нажата клавиша и выводим сообщение в случае, если нажать в этом поле интер:
            if (e.getSource()== field1) JOptionPane.showMessageDialog (null, "Text Field");
            else JOptionPane.showMessageDialog (null, "Password Field");
        }
    }
}