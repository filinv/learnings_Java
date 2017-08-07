/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @author user
 */
public class MyApplet extends JApplet{
    JLabel label;
    JButton b1;
    JButton b2;
    int w;
    int h;
    
    public void init(){
        setSize(w, h);//задание размеров апплета
    label = new JLabel ("First");
    b1 = new JButton ("First");
    b2 = new JButton ("Second");
    
    b1.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
    label.setText("First");//менять текст при нажатии на кнопку
    }
    });
    b2.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
    label.setText("Second");//менять текст при нажатии на кнопку
    }
    });
    Container c = getContentPane ();
    c.setLayout(new FlowLayout());
    c.add(label);
    c.add(b1);
    c.add(b2);
    }
    
    void setWidth (int w){
    this.w = w;
    }
    void setHeight (int h){
    this.h = h;
    }
    
    public static void main (String [] args){
    JFrame app = new JFrame ("My App");
    MyApplet myApplet = new MyApplet ();
    myApplet.setWidth (200);
    myApplet.setHeight (200);
    
    myApplet.init();//инициализация
    myApplet.start();//запуск
    app.getContentPane().add(myApplet);//добавляем апплет в окно приложения
    app.setSize(200, 200);
    app.setVisible(true);
    }
}
