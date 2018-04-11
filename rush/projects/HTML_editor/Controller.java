import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;//отвечает за представление
    private HTMLDocument document;//отвечает за модель
    private File currentFile;//отвечает за файл, который сейчас открыт в нашем редакторе

    public Controller(View view) {
        this.view = view;
    }
    public static void main(String []args){}
}
