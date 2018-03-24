import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public static Car create(int type, int numberOfPassengers){
        Car car=null;
        switch (type){
            case 0:car= new Truck(numberOfPassengers);break;
            case 1:car= new Sedan(numberOfPassengers);break;
            case 2:car= new Cabriolet(numberOfPassengers);break;
            default: car=new Car(type,numberOfPassengers);
        }
        return car;
    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date,SummerStart,SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(canPassengersBeTransferred())return numberOfPassengers;
        else return 0;
    }
    private boolean canPassengersBeTransferred(){
        return isDriverAvailable()&&fuel>0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if(date.after(summerStart)&&date.before(summerEnd))return true;
        else return false;
    }
}
