import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;//отвечает за представление
    private HTMLDocument document;//отвечает за модель
    private File currentFile;//отвечает за файл, который сейчас открыт в нашем редакторе

    public Controller(View view) {
        this.view = view;
    }
    public static void main(String []args){View mainView=new View();
        Controller mainController=new Controller(mainView);
        mainView.setController(mainController);
        mainView.init();
        mainController.init();
    }
    public void init(){}
    public HTMLDocument getDocument() {
        return document;
    }
    public void resetDocument(){
        if(document!=null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document=(HTMLDocument)new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    /**записывает переданный текст с html тегами в документ document */
    public void setPlainText(String text){
        resetDocument();
        StringReader reader=new StringReader(text);
        try {
            new HTMLEditorKit().read(reader,document,0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public void exit(){
        System.exit(0);
    }
}
