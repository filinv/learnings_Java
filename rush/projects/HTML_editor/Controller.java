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
    public void init(){
        createNewDocument();
    }
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
    /**должен получать текст из документа со всеми html тегами */
    public String getPlainText(){
        StringWriter writer=new StringWriter();
        try {
            new HTMLEditorKit().write(writer,document,0,document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile=null;
    }
    public void openDocument(){}
    public void saveDocument(){}
    public void saveDocumentAs(){}
    public void exit(){
        System.exit(0);
    }
}
