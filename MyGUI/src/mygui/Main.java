/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mygui;
import java.awt.event.*;

/**
 *
 * @author user
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*
MyFrame m = new MyFrame ("My Frame");//работа с классом поля ввода текста и паролей
MyFrame1 m = new MyFrame1 ("My Frame1");//работа с классом кнопки
FrameStateButtons m = new FrameStateButtons ("My FrameStateButtons");//работа с классом кнопки состояний
MyFrame2 m = new MyFrame2 ("My Frame2");//работа с выпадающими списками
MyList m = new MyList ("My List");//работа со списком элементов с одиночным выбором
MyList1 m = new MyList1 ("My List1");//работа со списком эл-в с множественным выбором
MouseEvents m = new MouseEvents ("MouseEvents");//обработка событий мыши
MouseDragDraw m = new MouseDragDraw ("MouseDragDraw");//рисование зажатием мыши
NextMouseAdapter m = new NextMouseAdapter ("NextMouseAdapter");//какая клавиша мыши щёлкнула
NextAdapter m = new NextAdapter ("NextAdapter");//различия в состоянии нажатия клавиш клавиатуры
MyLayout m = new MyLayout ("MyLayout");//менеджер расположения по-порядку
MyBorderLayout m = new MyBorderLayout ("MyBorderLayout");//менеджер расположения по краю
MyGridLayout m = new MyGridLayout ("MyGridLayout");//менеджер расположения по сетке
MyPanel m = new MyPanel ("MyPanel");//разбитие окна на несколько панелей с различным содержимым
MyTextArea m = new MyTextArea ("MyTextArea");
MyPanel2 m = new MyPanel2 ("MyPanel2");//смена цвета прямоугольника после нажатия кнопок
MyPanel3 m = new MyPanel3 ("MyPanel3");//появление прямоугольника в точке щелчка мыши
MySlider m = new MySlider ("MySlider");//работа с полкунком прокрутки
MyMenu m = new MyMenu ("MyMenu");
MyPopupMenu m = new MyPopupMenu ("MyPopupMenu");
MyFlexGUI m = new MyFlexGUI ("MyFlexGUI");//изменение интерфейса под разные ОС
*/
WindowInWindow m = new WindowInWindow ("WindowInWindow");//вложенные окна

m.addWindowListener(new WindowAdapter (){
public void windowClosing (WindowEvent e){//метод вызывается ПОСЛЕ закрытия окна
System.exit(0);//окончание выполнения приложения, после закрытия окна
}
//перечислим все 7 методов класса WindowAdapter:
/*
public void windowActivated (WindowEvent e){
System.out.println("Window was Activated");
}
public void windowClosed (WindowEvent e){//метод вызывается ПРИ ПОПЫТКЕ закрыть окно
System.out.println("Window was Closed");
}
public void windowDeactivated (WindowEvent e){
System.out.println("Window was Deactivated");
}
public void windowIconified (WindowEvent e){//свёртывание окна
System.out.println("Window was Iconified");
}
public void windowDeiconified (WindowEvent e){//разворачивание
System.out.println("Window was Deiconified");
}
public void windowOpened (WindowEvent e){
System.out.println("Window was Opened");
}
*/
});    
    }

}
