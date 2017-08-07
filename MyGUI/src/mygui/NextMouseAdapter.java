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
public class NextMouseAdapter extends JFrame{
    public NextMouseAdapter(String str){
    super (str);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    addMouseListener (new MyMouse());//наш собственный слушатель
    
    setSize (300, 100);
    setVisible (true);
    }
    
    class MyMouse extends MouseAdapter{
    public void mouseClicked (MouseEvent e){
    if (e.isMetaDown()) JOptionPane.showMessageDialog(null, "Rigth");
    else if (e.isAltDown()) JOptionPane.showMessageDialog(null, "Middle");
    else JOptionPane.showMessageDialog(null, "Left");
    }
    }
}