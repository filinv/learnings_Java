import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void init(){}
    public void exit(){
        controller.exit();
    }
}
