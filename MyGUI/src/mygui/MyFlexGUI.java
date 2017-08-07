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
public class MyFlexGUI extends JFrame{
    //переключение графического интерфейса под разные ОС с помощью группы радиокнопок
    UIManager.LookAndFeelInfo l [];//создаём массив для разных интерфейсов
    JComboBox box;
    JTextArea text;
    JButton button;
    JRadioButton metal;
    JRadioButton motif;
    JRadioButton windows;
    
    public MyFlexGUI(String str){
    super (str);
    
    String [] s = {"1", "2", "3"};
    box = new JComboBox ();
    text = new JTextArea ("Text");
    button = new JButton ("Text");
    Container c = getContentPane ();
    c.setLayout(new FlowLayout());
    c.add(box);
    c.add(text);
    c.add(button);
    
    Handler handler = new Handler ();
    ButtonGroup group = new ButtonGroup();
    JPanel panel = new JPanel ();
    
    metal = new JRadioButton ("Metal");
    metal.addItemListener(handler);
    group.add(metal);
    panel.add(metal);
    
    motif = new JRadioButton ("Motif");
    motif.addItemListener(handler);
    group.add(motif);
    panel.add(motif);
    
    windows = new JRadioButton ("Windows");
    windows.addItemListener(handler);
    group.add(windows);
    panel.add(windows);
    c.add(panel);
    
    l = UIManager.getInstalledLookAndFeels();//заполняем массив информацией об интерфейсах
    setSize (300, 100);
    setVisible (true);
    }
    void change (int i){
    try {
    UIManager.setLookAndFeel(l[i].getClassName());//для итого элемента массива вызываем метод получения имени класса
    SwingUtilities.updateComponentTreeUI(this);//обновить весь фрейм
    }
    catch (Exception e){e.printStackTrace();}
    }
    class Handler implements ItemListener {
    public void itemStateChanged(ItemEvent e){
    if (metal.isSelected()) change (0);  
    else if (motif.isSelected()) change (1);
    else if (windows.isSelected()) change (2);
    }
    }
}