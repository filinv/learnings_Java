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
public class MyList1 extends JFrame{
    JTextField text;
    JList list;//класс определяющий список, множественный выбор с помощью клавиши Ctrl
    JButton button;//класс кнопки
    String [] colors = {"red", "blue", "green", "yellow", "white"};//массив строк, который и будет элементами выпадающего списка
    Color [] stat = {Color.red, Color.blue, Color.green, Color.yellow, Color.white};//массив, содержащий статические переменные для загрузки этих цветов
    
    public MyList1 (String str){
        super (str);//после вызова конструктора суперкласса данный параметр стр будет загружен как заголовок окна
        Container c = getContentPane ();//класс контейнер для того, чтобы сложить в него метки
        c.setLayout(new FlowLayout());
        JLabel label = new JLabel ("My Label");//создали метку, в которую можно складывать текстовые подсказки
        label.setToolTipText("Label Text");//текст подсказки при наведении мыши
        label.setText("Text");//загружает в метку другой текст
        c.add (label);
        
        text = new JTextField ("Text");
        c.add(text);
        
        list = new JList (colors);
        list.setVisibleRowCount(3);//устанавливаем количество элементов, которые видны в данный момент
        //запрещаем множественный выбор:
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //загружаем в контейнер,НО список не имеет полос прокрутки, поэтому 
        //их нужно загружать отдельно с помощью анонимного класса
        c.add(new JScrollPane(list));
        
        button = new JButton ("Submit");
        c.add(button);
        //регистрируем обработчик событий для кнопки:
        button.addActionListener(new ActionListener (){
        public void actionPerformed (ActionEvent e){
        JOptionPane.showMessageDialog(null, list.getSelectedValues());
        }
        });
                
        setSize(400, 150);
        setVisible(true);
    }
}