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
public class MyMenu extends JFrame{
    
    JLabel text;//метка, цвет которой будем менять из меню
    Color colors [] = {Color.red, Color.blue, Color.green};
    String color_names [] = {"Red", "Blue", "Green"};//будет эти элементы загружать
    //в качестве подписей к пунктам меню
    JRadioButtonMenuItem [] colItems;//массив элементов меню с радио-кнопками
    JCheckBoxMenuItem [] colItems2;//массив для элементов с чек-боксами
    ButtonGroup group;//группа взаимоисключаемых кнопок
    
    public MyMenu(String str){
    super (str);
    
    JMenu file = new JMenu ("File (F)");//пункт меню, параметр это надпись
    file.setMnemonic('F');//при нажатии символа Alt+F на клавиатуре будет также вызываться меню
    JMenuItem about = new JMenuItem ("About (A)");
    about.setMnemonic('A');
    about.addActionListener(new ActionListener (){
    public void actionPerformed (ActionEvent e){
    JOptionPane.showMessageDialog(null, "About");
    }
    });
    file.add(about);//добавляем пункт about в пункт file
    JMenuBar bar = new JMenuBar();//создаём строку меню
    setJMenuBar(bar);
    bar.add(file);//добавляем пункт file в строку меню(она по разметке вверху)
    
    JMenu format2 = new JMenu ("Format2 (T)");
    format2.setMnemonic('T');
    JMenu colorMenu2 = new JMenu ("Colors 2 (O)");
    colorMenu2.setMnemonic('O');
    CheckHandler handler2 = new CheckHandler();
    colItems2 = new JCheckBoxMenuItem [colors.length];
    for (int i = 0; i<colors.length; i++){
    colItems2[i] = new JCheckBoxMenuItem (color_names[i]);
    colorMenu2.add(colItems2[i]);
    colItems2[i].addItemListener(handler2);
    }
    format2.add(colorMenu2);
    bar.add(format2);
    
    JMenu format = new JMenu("Format (R)");
    format.setMnemonic('R');
    JMenu colorMenu = new JMenu ("Colors (C)");
    colorMenu.setMnemonic('C');
    colItems = new JRadioButtonMenuItem [colors.length];//создали объект массива равный по длине массиву цветов
    group = new ButtonGroup();
    Handler iHandler = new Handler ();//объект для обработчика событий
    
    for (int i=0; i<colors.length; i++){//каждому пункту меню ставим в соответствие
    //объект JRadioButtonMenuItem с надписями их другого массива названий цветов
    colItems[i] = new JRadioButtonMenuItem (color_names[i]);
    group.add(colItems[i]);//загружаем итый элемент в группу кнопок
    colorMenu.add(colItems[i]);
    colItems[i].addActionListener(iHandler);//добавляем итому элементу обработчик событий
    }
    colItems[0].setSelected(true);//по умолчанию нажата кнопка с первым элементом массива
    format.add(colorMenu);//в меню "формат" добавляем "меню цветов"
    bar.add(format);//в строку меню добавляем пункт меню "формат"
    
    text = new JLabel("Text");
    Container c = getContentPane();
    c.setLayout (new BorderLayout());
    c.add(text);
    text.setForeground(Color.red);
    
    setSize (300, 100);
    setVisible (true);
    }
    class Handler implements ActionListener {
    public void actionPerformed (ActionEvent e){
    for (int i = 0; i< colors.length; i++){
    if (colItems[i].isSelected()){//если нажат итый элемент массива
    text.setForeground(colors[i]);//присвоить тексту цвет из массива colors
    break;
    }
    }
    repaint();
    }
    }
    class CheckHandler implements ItemListener{
        int r = 0;
        int g = 0;
        int b = 0;
    public void itemStateChanged (ItemEvent e){
    if (colItems2[0].isSelected()) r = 128;
    else r = 0;
    if (colItems2[1].isSelected()) b = 128;
    else b = 0;
    if (colItems2[2].isSelected()) g = 128;
    else g = 0;
    
    text.setForeground(new Color (r, g, b));
    repaint();
    }
    }
}