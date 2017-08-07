/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
public class KeyIcon extends KBIcon{
    private boolean position_upperleft;
    
    public KeyIcon (String legend, int unit_size, int width_factor, int height_factor){
    super (legend, unit_size, width_factor, height_factor);
    set_legend(legend);
    }
    public KeyIcon(String legend, int width_factor){
    this(legend, DEFAULT_SIZE, width_factor, 100);
    }
    
    public synchronized void paintComponent (Graphics g){
    super.paintComponent(g);
    Dimension d = getSize();//получили размер значка
    if(legend != null){
    Color color = (highlight_color != null)? highlight_color : getForeground();
    g.setColor(color);
    g.fillRect(2, 2, d.width - 4, d.height - 4);
    if(show_legend){//если хотим, чтобы надписи на кнопках рисовались
    if(!color.equals(Color.black)){
    g.setColor(Color.black);
    }
    else g.setColor(Color.white);
    }
    FontMetrics fm = g.getFontMetrics();
    if(position_upperleft){//если выводим надписи в верхнем левом углу, то рисуем буквы
    g.drawString(legend, 3, fm.getAscent() + 3);
    }
    else g.drawString(legend, (d.width - fm.stringWidth(legend))/2, (d.height + fm.getAscent())/2);
    
    g.setColor(color);
    g.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
    }
    else{
    g.setColor(getBackground());
    g.fillRect(0, 0, d.width - 1, d.height - 1);
    }
    }
    public synchronized void set_legend (String legend){
    if(legend == null){
    this.legend= null;
    position_upperleft = false;
    repaint();
    }
    else if(! legend.equals(this.legend)){
    if(legend.length()==1 && Character.isLetter(legend.charAt(0))){
    this.legend = legend.toUpperCase();
    position_upperleft = true;
    }
    else{
    this.legend = legend;
    position_upperleft = false;//т.к. хотим, чтобы в верхнлев.углу рисовались только буквы
    }
    repaint();
    }
    }
    
}
