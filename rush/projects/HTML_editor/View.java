import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    /**панель с двумя вкладками. */
    private JTabbedPane tabbedPane=new JTabbedPane();

    /**компонент для визуального редактирования html. Он будет размещен на первой вкладке.*/
    private JTextPane htmlTextPane=new JTextPane();

    /**компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое). */
    private JEditorPane plainTextPane=new JEditorPane();
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void init(){
        initGui();
        this.addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }
    /**отвечает за инициализацию меню редактора. */
    public void initMenuBar(){}

    /**отвечает за инициализацию панелей редактора. */
    public void initEditor(){}

    /**инициализирует графический интерфейс */
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void exit(){
        controller.exit();
    }
}
