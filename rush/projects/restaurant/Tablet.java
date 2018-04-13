import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    /**это номер планшета,
     * чтобы можно было однозначно установить,
     * откуда поступил заказ */
    final int number;
    private Order order;
    private static Logger logger= Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }
    /**будет создавать заказ из тех блюд,
     * которые выберет пользователь */
    public void createOrder(){
        try {
            order=new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
