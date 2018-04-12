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
    public void initEditor(){
        htmlTextPane.setContentType("text/html");

        tabbedPane.addTab("HTML",new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст",new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(100,100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    /**инициализирует графический интерфейс */
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){}
    public void exit(){
        controller.exit();
    }
}
