public class Ball extends BaseObject{
  private double speed, direction, dx, dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed=speed;
        this.direction=direction;
        isFrozen=true;
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'O');
    }
    @Override
    public void move() {
        if(!isFrozen){
            x+=dx;
            y+=dy;
        }
    }
    public void start(){
        isFrozen=false;
    }
    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }
    public double getDx() {
        return dx;
    }
    public double getDy() {
        return dy;
    }
}
