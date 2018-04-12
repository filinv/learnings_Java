import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**отвечает за стиль "Надстрочный знак" */
public class SuperscriptAction extends StyledEditorKit.StyledTextAction{
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SuperscriptAction() {
        super("Надстрочный знак");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
