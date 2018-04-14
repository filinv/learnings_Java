public class Restaurant {
    public static void main(String [] args){
        Tablet tablet=new Tablet(5);
        Cook cook=new Cook("Amigo");
        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
