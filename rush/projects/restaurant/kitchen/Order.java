import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        dishes= ConsoleHelper.getAllDishesForOrder();
    }
    public int getTotalCookingTime(){
        int totalCookingTime=0;
        for(Dish dish: dishes){
            totalCookingTime+=dish.getDuration();
        }
        return totalCookingTime;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }
}
