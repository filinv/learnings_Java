import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**отвечает за стиль текста "Подстрочный знак" */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SubscriptAction() {
        super("Подстрочный знак");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
