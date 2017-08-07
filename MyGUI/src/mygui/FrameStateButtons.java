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
public class FrameStateButtons extends JFrame{
    JTextField text;
    /*
    JCheckBox check;//поле для создания чекбокса
    */
    JRadioButton red, blue;
    
    public FrameStateButtons (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel ("My Label");//создали метку, в которую можно складывать текстовые подсказки
        label.setToolTipText("Label Text");//текст подсказки при наведении мыши
        label.setText("Text");//загружает в метку другой текст
        c.add (label);
        
        text = new JTextField ("Text");
        c.add(text);
        /*
        check = new JCheckBox ("Red");//надпись рядом с чекбоксом
        c.add(check);
        Handler handler = new Handler ();
        check.addItemListener(handler);//регистрируем слушателя
        */
        red = new JRadioButton ("Red", true);
        c.add (red);
        blue = new JRadioButton ("Blue", false);
        c.add (blue);
        Handler handler = new Handler ();
        red.addItemListener (handler);
        blue.addItemListener (handler);
        //объединим 2 радиокнопки в одну группу:
        ButtonGroup group = new ButtonGroup ();
        group.add(red);
        group.add(blue);
        text.setBackground(Color.red);
        
        setSize(400, 150);
        setVisible(true);
    }
    //слушатель для радиокнопок:
    class Handler implements ItemListener {
    Color color;//будем записывать в это поле старый цвет фона
    public void itemStateChanged (ItemEvent e){
    if (e.getSource()== red) text.setBackground(Color.red);
    else if (e.getSource()== blue) text.setBackground(Color.blue);
    }
    }
    /*слушатель для чекбокса:
    class Handler implements ItemListener {
    Color color;//будем записывать в это поле старый цвет фона
    public void itemStateChanged (ItemEvent e){
    if (e.getSource()== check){//проверяем наша ли кнопка задействована
    if(e.getStateChange()== ItemEvent.SELECTED){//проверяем стоит флажок
    color = text.getBackground();
    text.setBackground(Color.red);
    }
    else text.setBackground(color);//или не стоит флажок
    }
    }
    }
    }
*/
}