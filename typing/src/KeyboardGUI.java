/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
public class KeyboardGUI extends JInternalFrame implements Runnable, ActionListener, InternalFrameListener{
    
    private static final KeyCode ROW_1_KEY1 = KeyCode.KC_01;
    private static final KeyCode [] ROW_1_SEQ = {
    KeyCode.KC_02, KeyCode.KC_03, KeyCode.KC_04, KeyCode.KC_05, KeyCode.KC_06, KeyCode.KC_07, KeyCode.KC_08, KeyCode.KC_09, KeyCode.KC_10, KeyCode.KC_11, KeyCode.KC_12, KeyCode.KC_13};
    private static final KeyCode ROW_1_BACKSPACE = KeyCode.KC_14;
    private static final KeyCode [] ROW_2_SEQ = {
    KeyCode.KC_15, KeyCode.KC_16, KeyCode.KC_17, KeyCode.KC_18, KeyCode.KC_19, KeyCode.KC_20, KeyCode.KC_21, KeyCode.KC_22, KeyCode.KC_23, KeyCode.KC_24, KeyCode.KC_25, KeyCode.KC_26, KeyCode.KC_27};
    private static final KeyCode [] ROW_3_SEQ = {
    KeyCode.KC_28, KeyCode.KC_29, KeyCode.KC_30, KeyCode.KC_31, KeyCode.KC_32, KeyCode.KC_33, KeyCode.KC_34, KeyCode.KC_35, KeyCode.KC_36, KeyCode.KC_37, KeyCode.KC_38};
    private static final KeyCode ROW_4_LEFT_SHIFT = KeyCode.KC_61;
    private static final KeyCode [] ROW_4_SEQ = {
    KeyCode.KC_39, KeyCode.KC_40, KeyCode.KC_41, KeyCode.KC_42, KeyCode.KC_43, KeyCode.KC_44, KeyCode.KC_45, KeyCode.KC_46, KeyCode.KC_47, KeyCode.KC_48, KeyCode.KC_49};
    private static final KeyCode ROW_4_RIGHT_SHIFT = KeyCode.KC_62;
    private static final KeyCode ROW_5_LEFT_ALT = KeyCode.KC_63;
    private static final KeyCode ROW_5_SPACE = KeyCode.KC_60;
    private static final KeyCode ROW_5_RIGHT_ALT = KeyCode.KC_64;
    private static final KeyCode [] ROW_6_SEQ = {
    KeyCode.KC_50, KeyCode.KC_51, KeyCode.KC_52};
    private static final KeyCode [] ROW_7_SEQ = {
    KeyCode.KC_53, KeyCode.KC_54, KeyCode.KC_55};
    private static final KeyCode [] ROW_8_SEQ = {
    KeyCode.KC_56, KeyCode.KC_57, KeyCode.KC_58};
    private static final KeyCode ROW_9_NULL = KeyCode.KC_59;
    
    private static final Color COLOR_PANEL = Color.LIGHT_GRAY;
    private static final Color COLOR_NEUTRAL = Color.GRAY;
    private static final Color COLOR_EXPECTED = Color.BLUE;
    private static final Color COLOR_SUCCESS = Color.GREEN;
    private static final Color COLOR_ERROR = Color.RED;
    
    private static final Color COLOR_LH_PINKY = Color.CYAN;
    private static final Color COLOR_LH_RING = Color.MAGENTA;
    private static final Color COLOR_LH_MIDDLE = Color.ORANGE;
    private static final Color COLOR_LH_INDEX = Color.PINK;
    private static final Color COLOR_RH_INDEX = Color.YELLOW;
    private static final Color COLOR_RH_MIDDLE = Color.ORANGE;
    private static final Color COLOR_RH_RING = Color.MAGENTA;
    private static final Color COLOR_RH_PINKY = Color.CYAN;
    private static final Color COLOR_RH_THUMB = Color.GREEN;
    
    private KBLayout kblayout;
    
    private final Hashtable keyicons_by_keycode = new Hashtable ();
    private Hashtable fingericons_by_finger = new Hashtable ();
    private Hashtable colors_by_finger = new Hashtable ();
    private Hashtable numkeycodes_by_char = new Hashtable ();
    
    private KeyIcon last_expected;//подсветившееся в качестве подсказки в последний раз
    private KeyIcon num_last_expected;
    private KeyIcon last_error;
    private KeyIcon num_last_error;
    private KeyIcon last_success;
    private KeyIcon num_last_success;
    
    private long timestamp_error;//сколько времени держать подсвеченной клавишу
    private long timestamp_success;
    
    private FingerIcon last_expected_finger;//каким пальцем нужно было набрать символ
    
    private KeyIcon left_shift;
    private KeyIcon right_shift;
    private KeyIcon left_alt;
    private KeyIcon right_alt;
    
    private Object visible = new Object();
    
    private JPanel make_kb_panel (){
    JPanel panel = new JPanel ();
    panel.setLayout(new GridLayout (0, 1, 0, 0));
    String bkspc = "Bkspc";
    String tab = "Tab";
    String caps = "Caps";
    String enter = "Enter";
    String shift = "Shift";
    String ctrl = "ctrl";
    String alt = "alt";
    
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
    row_1.add(new_keyicon("", 100, ROW_1_KEY1));
    for(int index = 0; index< ROW_1_SEQ.length; index++)
        row_1.add(new_keyicon("",100,ROW_1_SEQ[index]));
    row_1.add(new_keyicon(bkspc, 200, ROW_1_BACKSPACE));
    
//create the second row of keys
    JPanel row_2 = new JPanel();
    row_2.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
    for(int index = 0; index< ROW_2_SEQ.length; index++)
        row_2.add(new_keyicon("",100,ROW_2_SEQ[index]));
    for(int index = 0; index< ROW_6_SEQ.length; index++)
        row_2.add(new_keyicon("",100,ROW_6_SEQ[index]));
    
    //create the third row of keys
    JPanel row_3 = new JPanel();
    row_3.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
    for(int index = 0; index< ROW_3_SEQ.length; index++)
    row_3.add(new_keyicon("",100,ROW_3_SEQ[index]));
    for(int index = 0; index< ROW_7_SEQ.length; index++)
        row_2.add(new_keyicon("",100,ROW_7_SEQ[index]));
    
    //create the firth row of keys
    JPanel row_4 = new JPanel();
    row_4.add(new_keyicon("", 100, ROW_4_LEFT_SHIFT));
    row_4.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
    for(int index = 0; index< ROW_4_SEQ.length; index++)
        row_4.add(new_keyicon("",100,ROW_4_SEQ[index]));
    row_4.add(new_keyicon("", 100, ROW_4_RIGHT_SHIFT));
    for(int index = 0; index< ROW_8_SEQ.length; index++)
        row_2.add(new_keyicon("",100,ROW_8_SEQ[index]));
    
    //create the fifth row of keys
    JPanel row_5 = new JPanel();
    row_5.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
    row_5.add(new_keyicon("", 100, ROW_5_LEFT_ALT));
    row_5.add(new_keyicon("", 100, ROW_5_SPACE));
    row_5.add(new_keyicon("", 100, ROW_5_RIGHT_ALT));
    row_5.add(new_keyicon("", 100, ROW_9_NULL));
    
    JPanel left_finger_row = new JPanel();
    JPanel right_finger_row = new JPanel();
    left_finger_row.add(new_fingericon("fP", Finger.LH_PINKY));
    left_finger_row.add(new_fingericon("fR", Finger.LH_RING));
    left_finger_row.add(new_fingericon("fM", Finger.LH_MIDDLE));
    left_finger_row.add(new_fingericon("fI", Finger.LH_INDEX));
    left_finger_row.add(new_fingericon("fI", Finger.RH_INDEX));
    left_finger_row.add(new_fingericon("fM", Finger.RH_MIDDLE));
    left_finger_row.add(new_fingericon("fR", Finger.RH_RING));
    left_finger_row.add(new_fingericon("fP", Finger.RH_PINKY));
    left_finger_row.add(new_fingericon("fT", Finger.RH_THUMB));
    
    JPanel finger_row = new JPanel();
    finger_row.setLayout(new GridLayout(0, 3, 0, 0));
    finger_row.add(left_finger_row);
    finger_row.add(right_finger_row);
    finger_row.add(new JPanel());
    
    panel.add(row_1); panel.add(row_2); panel.add(row_3); 
    panel.add(row_4); panel.add(row_5); panel.add(finger_row);
        return null;
    
    }
    
public KeyboardGUI(){
this.addInternalFrameListener(this);
this.setTitle("Keyboard");

colors_by_finger.put(Finger.LH_PINKY, COLOR_LH_PINKY);
colors_by_finger.put(Finger.LH_RING, COLOR_LH_RING);
colors_by_finger.put(Finger.LH_MIDDLE, COLOR_LH_MIDDLE);
colors_by_finger.put(Finger.LH_INDEX, COLOR_LH_INDEX);
colors_by_finger.put(Finger.RH_PINKY, COLOR_RH_PINKY);
colors_by_finger.put(Finger.RH_RING, COLOR_RH_RING);
colors_by_finger.put(Finger.RH_MIDDLE, COLOR_RH_MIDDLE);
colors_by_finger.put(Finger.RH_INDEX, COLOR_RH_INDEX);
colors_by_finger.put(Finger.RH_THUMB, COLOR_RH_THUMB);

JPanel panel = make_kb_panel();

getContentPane().add("Center", panel);
JLabel kbtype_label = new JLabel ("US", JLabel.RIGHT);
getContentPane().add("South", kbtype_label);

left_shift = (KeyIcon)keyicons_by_keycode.get(ROW_4_LEFT_SHIFT);
right_shift = (KeyIcon)keyicons_by_keycode.get(ROW_4_RIGHT_SHIFT);
left_alt = (KeyIcon)keyicons_by_keycode.get(ROW_5_LEFT_ALT);
right_alt = (KeyIcon)keyicons_by_keycode.get(ROW_5_RIGHT_ALT);

numkeycodes_by_char.put(new Character('7'), KeyCode.KC_50);
numkeycodes_by_char.put(new Character('8'), KeyCode.KC_51);
numkeycodes_by_char.put(new Character('9'), KeyCode.KC_52);
numkeycodes_by_char.put(new Character('4'), KeyCode.KC_53);
numkeycodes_by_char.put(new Character('5'), KeyCode.KC_54);
numkeycodes_by_char.put(new Character('6'), KeyCode.KC_55);
numkeycodes_by_char.put(new Character('1'), KeyCode.KC_56);
numkeycodes_by_char.put(new Character('2'), KeyCode.KC_57);
numkeycodes_by_char.put(new Character('3'), KeyCode.KC_58);
numkeycodes_by_char.put(new Character('0'), KeyCode.KC_59);

colorize_keyicons();
colorize_fingericons();
display_legends();
new Thread(this, "KeyboardGUI_timeout").start();
}
public void run(){
final int THREAD_TICK = 250;
final int HIGHLIGHT_TIMEOUT = 250;

Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//минимальный приоритет для задержки

while (true){//пока программа работает
while(!isVisible()){//пока клавиатура невидима
try{
synchronized(visible){
visible.wait();
}
}
catch (InterruptedException e){}
}
try{
Thread.sleep(THREAD_TICK);
}
catch (InterruptedException e){}
long now = System.currentTimeMillis();
if((now - timestamp_error)>= HIGHLIGHT_TIMEOUT)clear_error();
}
}
private KeyIcon new_keyicon (String default_legend, int width_factor, KeyCode keycode){
Glyph glyph = kblayout.find_glyph(keycode, KeyShiftState.UNSHIFTED);
if(glyph==null) kblayout.find_glyph(keycode, KeyShiftState.SHIFTED);
else if (glyph==null) kblayout.find_glyph(keycode, KeyShiftState.META_ALT);

String legend = default_legend;

if(glyph != null){
Character character = glyph.get_character();
if (character.charValue()==' ') legend = "Space";
else if(character.charValue()=='\n') legend = "Return";//если конец строки
else legend = character.toString();
}
KeyIcon keyicon = new KeyIcon(legend, width_factor);
keyicon.set_highlight(COLOR_NEUTRAL);
keyicons_by_keycode.put(keycode, keyicon);

return (keyicon);
}
private FingerIcon new_fingericon (String legend, Finger finger){
FingerIcon fingericon = new FingerIcon(legend);
fingericon.set_highlight(COLOR_NEUTRAL);
fingericons_by_finger.put(finger, fingericon);
return(fingericon);
}
public void colorize_keyicons(){
for (Enumeration enuma = kblayout.get_elements(); enuma.hasMoreElements(); ){
Glyph glyph = (Glyph)(enuma.nextElement());
KeyCode keycode = glyph.get_keycode();
Finger finger = glyph.get_finger();
KeyIcon keyicon = (KeyIcon)(keyicons_by_keycode.get(keycode));
if(keycode!=null){
keyicon.setBackground(COLOR_PANEL);
}
}
}
public void colorize_fingericons(){
for (Enumeration enuma = Finger.get_Elements(); enuma.hasMoreElements(); ){
Finger finger = (Finger)(enuma.nextElement());
FingerIcon fingericon = (FingerIcon)(fingericons_by_finger.get(finger));
if(fingericon != null){
Color color = (Color) (colors_by_finger.get(finger));
if(color != null)fingericon.set_highlight(color);
}
}
}
public void display_legends(){
for (Enumeration enuma = keyicons_by_keycode.elements(); enuma.hasMoreElements(); ){
KeyIcon keyicon = (KeyIcon)(enuma.nextElement());
keyicon.show_legend(true);
}
for (Enumeration enuma = fingericons_by_finger.elements(); enuma.hasMoreElements(); ){
FingerIcon fingericon = (FingerIcon)(enuma.nextElement());
fingericon.show_legend(true);
}
}
private KeyIcon highlight_keyicon(KeyCode keycode, Color color){
KeyIcon keyicon = (KeyIcon)(keyicons_by_keycode.get(keycode));
if(keyicon != null){
keyicon.set_highlight(color);
return (keyicon);
}
return (null);
}
private KeyIcon highlight_keyicon(Glyph glyph, Color color){
return (highlight_keyicon(glyph.get_keycode(), color));
}
private KeyIcon highlight_keyicon(char character, Color color){
Glyph glyph = kblayout.find_glyph(character);
if(glyph != null){
highlight_keyicon(glyph, color);
}
return (null);
}
private KeyIcon num_highlight_keyicon (char character, Color color){
KeyCode num_keycode = (KeyCode)(numkeycodes_by_char.get(new Character(character)));
if (num_keycode != null){
return (highlight_keyicon(num_keycode, color));
}
return (null);
}
public void char_expected (char character){
clear_expected();
Glyph glyph = kblayout.find_glyph(character);
if (glyph != null){
Finger finger = glyph.get_finger();
FingerIcon fingericon = (FingerIcon)(fingericons_by_finger.get(finger));
if(fingericon != null){
fingericon.set_highlight(COLOR_EXPECTED);
last_expected_finger = fingericon;
KeyIcon shifticon = null;
KeyShiftState keyshiftstate = glyph.get_shiftstate();
if (keyshiftstate == KeyShiftState.SHIFTED){
if(finger.is_left_handed())shifticon = right_shift;
else shifticon = left_shift;
}
else if(keyshiftstate == KeyShiftState.META_ALT){
if(finger.is_left_handed())shifticon = right_alt;
else shifticon = left_alt;
if (shifticon != null){
shifticon.set_highlight(COLOR_EXPECTED);
last_expected = highlight_keyicon (glyph, COLOR_EXPECTED);
}
}
}
}
}
public void clear_expected (){
if(last_expected != null){
last_expected.clear_highlight();
last_expected = null;
}
if (num_last_expected != null){
num_last_expected.clear_highlight();
num_last_expected = null;
}
left_shift.clear_highlight();
right_shift.clear_highlight();
left_alt.clear_highlight();
right_alt.clear_highlight();

}
public void char_error(char character){
clear_error();
last_error = highlight_keyicon (character, COLOR_ERROR);
num_last_error = num_highlight_keyicon (character, COLOR_ERROR);
timestamp_error = System.currentTimeMillis();
}
public void clear_error (){
if(last_error != null){
if(last_error != last_expected){
last_error.clear_highlight();
last_error = null;
}
}
if(num_last_error != null){
if(num_last_error != num_last_expected){
num_last_error.clear_highlight();
num_last_error = null;
}
}
}
public void char_success(char character){
clear_success();
last_success = highlight_keyicon (character, COLOR_SUCCESS);
num_last_success = num_highlight_keyicon (character, COLOR_SUCCESS);
if (last_success == last_expected){
last_expected = null;
}
if (num_last_success == num_last_expected){
num_last_expected = null;
}
timestamp_success = System.currentTimeMillis();
}
public void clear_success(){
if(last_success != null){
if(last_success == last_expected){
last_success.clear_highlight();
last_success = null;
}
}
if(num_last_success != null){
if(num_last_success == num_last_expected){
num_last_success.clear_highlight();
num_last_success = null;
}
}
}
public void setVisible (boolean is_visible){
super.setVisible(is_visible);
if(is_visible) synchronized (visible){
    visible.notify();
}
}
private void handle_close_button(){
setVisible (false);
}
public void actionPerformed (ActionEvent evt){}
public void internalFrameActivated (InternalFrameEvent evt){}
public void internalFrameClosed (InternalFrameEvent evt){}
public void internalFrameClosing (InternalFrameEvent evt){
handle_close_button();
}
public void internalFrameDeactivated (InternalFrameEvent evt){}
public void internalFrameDeiconified (InternalFrameEvent evt){}
public void internalFrameIconified (InternalFrameEvent evt){}
public void internalFrameOpened (InternalFrameEvent evt){}
public void itemStateChanged(ItemEvent evt){}
    
}
