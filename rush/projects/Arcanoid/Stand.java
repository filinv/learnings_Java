public class Stand extends BaseObject{
    private double speed, direction;
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }
    @Override
    public void draw(Canvas canvas) {
    }
    @Override
    public void move() {
    }
    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }
}
