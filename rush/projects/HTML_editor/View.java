import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private UndoManager undoManager=new UndoManager();
    private UndoListener undoListener=new UndoListener(undoManager);
    /**панель с двумя вкладками. */
    private JTabbedPane tabbedPane=new JTabbedPane();

    /**компонент для визуального редактирования html. Он будет размещен на первой вкладке.*/
    private JTextPane htmlTextPane=new JTextPane();

    /**компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое). */
    private JEditorPane plainTextPane=new JEditorPane();
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }
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
    public void initMenuBar(){
        JMenuBar jMenuBar=new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

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
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){return undoManager.canRedo();}
    /**отменяет последнее действие */
    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }
    /**возвращает ранее отмененное действие */
    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }
    /**должен сбрасывать все правки в менеджере undoManager */
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    /**Пункты меню, отвечающие за стиль, шрифт, цвет и т.д.
     * должны быть доступны только тогда,
     * когда в нашем редакторе выбрана первая вкладка */
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    /**получает документ у контроллера и устанавливает его в панель редактирования htmlTextPane */
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(),"message","title",JOptionPane.INFORMATION_MESSAGE);
    }
    public void exit(){
        controller.exit();
    }
}
