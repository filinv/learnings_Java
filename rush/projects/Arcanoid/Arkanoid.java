public class Arkanoid {
    private int width, height;
    private Ball ball;
    private Stand stand;
    private List<Brick>bricks;
    static Arkanoid game;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public static void main(String[] args){}
    public void run(){}
    public void move(){
        ball.move();
        stand.move();
    }
    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for(Brick brick:bricks){
            brick.draw(canvas);
        }
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void setStand(Stand stand) {
        this.stand = stand;
    }
    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
