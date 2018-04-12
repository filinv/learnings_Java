import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    /**parent - меню в которое мы добавляем пункт, text - текст добавляемого пункта,
     * actionListener - слушатель действий добавляемого пункта меню */
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener){
        JMenuItem jMenuItem=new JMenuItem(text);
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }
    public static JMenuItem addMenuItem(JMenu parent, Action action){
        JMenuItem jMenuItem=new JMenuItem(action);
        parent.add(jMenuItem);
        return jMenuItem;
    }
    public static JMenuItem addMenuItem(JMenu parent, String text, Action action){
        JMenuItem jMenuItem=addMenuItem(parent,action);
        jMenuItem.setText(text);
        return jMenuItem;
    }
    /**инициализация меню помощи. */
    public static void initHelpMenu(View view, JMenuBar menuBar){}
    /**инициализация меню выбора шрифта.*/
    public static void initFontMenu(View view, JMenuBar menuBar){}
    /**инициализация меню выбора цвета. */
    public static void initColorMenu(View view, JMenuBar menuBar){}
    /**инициализация меню выравнивания. */
    public static void initAlignMenu(View view, JMenuBar menuBar) {}
    /**инициализация меню выбора стиля текста. */
    public static void initStyleMenu(View view, JMenuBar menuBar){}
    /**инициализация меню редактирования текста. */
    public static void initEditMenu(View view, JMenuBar menuBar){}
    /**инициализация меню Файл. */
    public static void initFileMenu(View view, JMenuBar menuBar){}
}
