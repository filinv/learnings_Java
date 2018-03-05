public class Arkanoid {
    private int width, height;
    private Ball ball;
    private Stand stand;
    private List<Brick>bricks;
    private boolean isGameOver;
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
    public void checkBricksBump(){
        int index=0;
        for(Brick brick: bricks){
            if(ball.isIntersec(brick)){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                index=bricks.indexOf(brick);
                break;
            }
        }
        bricks.remove(index);
    }
    public void checkStandBump(){
        if(ball.isIntersec(stand)){
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame(){
        if(ball.getY()>this.height){
            isGameOver=true;
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
