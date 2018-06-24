public class Tetris {
    private Field field;
    private Figure figure;
    public static Tetris game;
    
    public static void main(String [] args){
        game=new Tetris();
        game.run();
    }
    public Field getField() {
        return field;
    }
    public Figure getFigure() {
        return figure;
    }
    /** будет отвечать за всю игру*/
    public void run(){}
    /** будет отвечать за один шаг в игре*/
    public void step(){}
}
