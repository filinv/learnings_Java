import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**отвечает за стиль текста "Зачеркнутый" */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */

    public StrikeThroughAction() {
        super("Зачеркнутый");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
