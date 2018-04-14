import java.util.Observable;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
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
    public Order createOrder(){
        order=null;
        try {
            order=new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        setChanged();
        notifyObservers(order);
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
