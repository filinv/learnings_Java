public abstract class BaseObject {
    protected double x,y,radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public abstract void draw(Canvas canvas);
    public abstract void move();
    boolean isIntersec(BaseObject o){
        double distance=Math.sqrt(Math.pow(this.x-o.x,2)+Math.pow(this.y-o.y,2));
        return distance<=Math.max(this.radius,o.radius);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
