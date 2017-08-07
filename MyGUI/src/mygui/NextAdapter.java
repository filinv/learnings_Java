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
public class NextAdapter extends JFrame implements KeyListener{
    public NextAdapter(String str){
    super (str);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    setSize (300, 100);
    setVisible (true);
    
    addKeyListener (this);
    }
    public void keyPressed (KeyEvent e){
    JOptionPane.showMessageDialog(null, e.getKeyText(e.getKeyCode()));//вывести в качестве текста клавишу, которая была нажата
    }
    public void keyReleased (KeyEvent e){
    JOptionPane.showMessageDialog(null, e.getKeyText(e.getKeyCode()));//вывести информацию о том, какую клавишу отпустили
    }
    public void keyTyped (KeyEvent e){
    JOptionPane.showMessageDialog(null, "" + e.getKeyChar());//вывести название не управляющей клавиши в юникоде
    }
}