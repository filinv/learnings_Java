public class Ball extends BaseObject{
    private double speed, direction, dx, dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed=speed;
        this.direction=direction;
        this.isFrozen=true;
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'O');
    }
    @Override
    public void move() {
        if(isFrozen)return;
        x+=dx;
        y+=dy;
        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }
    public void start(){
        this.setDirection(direction);
        this.isFrozen = false;
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
    public void setDirection(double direction){
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }
    public void checkRebound(int minx, int maxx, int miny, int maxy){
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }
        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }
        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }
        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }
}
