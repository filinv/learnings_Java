import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/** будет содержать игровую логику и хранить игровое поле.*/
public class Model {
    /** определяющая ширину игрового поля*/
    private static final int FIELD_WIDTH = 4;
    /** текущий счет*/
    int score;
    /** максимальный вес плитки на игровом поле*/
    int maxTile;
    Stack previousStates,previousScores;
    boolean isSaveNeeded = true;

    private Tile[][] gameTiles;

    public Model() {
        resetGameTiles();
    }
    void resetGameTiles(){
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i=0;i<FIELD_WIDTH;i++){
            for (int j=0;j<FIELD_WIDTH;j++){
                gameTiles[i][j]=new Tile();
            }
        }
        addTile();
        addTile();
        score=0;
        maxTile=0;
        previousStates=new Stack();
        previousScores=new Stack();
    }
    /**
     * будет смотреть какие плитки пустуют и менять вес одной из них,
     * выбранной случайным образом,
     * на 2 или 4 (на 9 двоек должна приходиться 1 четверка)*/
    private void addTile(){
        if (getEmptyTiles().size()>0) {
            getEmptyTiles().get((int)(Math.random()*getEmptyTiles().size())).value=Math.random() < 0.9 ? 2 : 4;
        }
    }
    /** возвращает список
     * свободных плиток в массиве gameTiles*/
    private List<Tile> getEmptyTiles(){
        List<Tile> result=new ArrayList<>();
        for(int i=0;i<gameTiles.length;i++){
            for (int j=0;j<gameTiles.length;j++){
                if(gameTiles[i][j].isEmpty())result.add(gameTiles[i][j]);
            }
        }
        return result;
    }
    /** Сжатие плиток, таким образом,
     * чтобы все пустые плитки были справа,
     * т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
     * возвращает true в случае, если он вносил изменения во входящий массив, иначе - false*/
    private boolean compressTiles(Tile[] tiles){
        boolean change=false;
        for (int j = 0; j < tiles.length - 1; j++){
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].isEmpty()& !tiles[i+1].isEmpty()) {
                    tiles[i].value = tiles[i + 1].value;
                    tiles[i + 1].value = 0;
                    change=true;
                }
            }
        }
        return change;
    }
    /** Слияние плиток одного номинала,
     * т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
     * Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0},
     * а {4, 4, 4, 0} в {8, 4, 0, 0}
     * Счет увеличивается после каждого слияния,
     * например если текущий счет 20 и
     * было выполнено слияние ряда {4, 4, 4, 0}, счет должен увеличиться на 8
     * возвращает true в случае, если он вносил изменения во входящий массив, иначе - false*/
    private boolean mergeTiles(Tile[] tiles){
        boolean change=false;
        for(int i=0;i<tiles.length-1;i++){
            if(!tiles[i].isEmpty()&&tiles[i].value==tiles[i+1].value){
                tiles[i].value*=2;
                score+=tiles[i].value;
                if(tiles[i].value>maxTile)maxTile=tiles[i].value;
                tiles[i+1].value=0;
                ++i;
                change=true;
            }
        }
        compressTiles(tiles);
        return change;
    }
    /** для каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles
     * и добавлять одну плитку с помощью метода addTile в том случае, если это необходимо*/
    public void left(){
        if(isSaveNeeded)saveState(gameTiles);
        boolean change=false;
        for(int i=0;i<FIELD_WIDTH;i++){
            if(compressTiles(gameTiles[i])|mergeTiles(gameTiles[i]))change=true;
        }
        if(getEmptyTiles().size()>0&&change)addTile();
        isSaveNeeded=true;
    }
    private void rotate(){
        Tile[][] rotateTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        int n = FIELD_WIDTH - 1;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotateTile[j][n] = gameTiles[i][j];
            }
            n--;
        }
        gameTiles = rotateTile;
    }
    public void right(){
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }
    public void up(){
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }
    public void down(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    public boolean canMove(){
        boolean canMove=false;
        if(getEmptyTiles().size()>0)canMove=true;
        else{
            for(int i=0;i<gameTiles.length-1;i++){
                for (int j=0;j<gameTiles.length-1;j++){
                    if(!gameTiles[i][j].isEmpty()&&(gameTiles[i][j].value==gameTiles[i+1][j].value||gameTiles[i][j].value==gameTiles[i][j+1].value)){
                        canMove=true;
                        break;
                    }
                }
            }
        }
        return canMove;
    }
    /** будет сохранять текущее игровое состояние и счет в стеки*/
    private void saveState(Tile[][] tiles){
        Tile[][] copyTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                copyTiles[i][j] = new Tile();
                copyTiles[i][j].value = tiles[i][j].value;
            }
        }
        previousStates.push(copyTiles);
        previousScores.push(score);
        isSaveNeeded=false;
    }
    /** будет устанавливать текущее игровое состояние
     * равным последнему находящемуся в стеках*/
    public void rollback(){
        if (!previousStates.empty()&&!previousScores.empty()) {
            gameTiles=(Tile[][]) previousStates.pop();
            score=(int)previousScores.pop();
        }
    }
    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0: left();break;
            case 1: right();break;
            case 2: up();break;
            case 3: down();break;
        }
    }
    /** будет возвращать true, в случае,
     * если вес плиток в массиве gameTiles отличается
     * от веса плиток в верхнем массиве стека previousStates*/
    public boolean hasBoardChanged(){
        int currentWeight=0;
        int previousWeight=0;
        Tile[][] buf=(Tile[][])previousStates.peek();
        for(int i=0;i<FIELD_WIDTH;i++){
            for (int j=0;j<FIELD_WIDTH;j++){
                currentWeight+=gameTiles[i][j].value;
                previousWeight+=buf[i][j].value;
            }
        }
        return currentWeight!=previousWeight;
    }
    /** возвращает объект типа MoveEfficiency,
     * описывающий эффективность переданного хода*/
    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency move0=new MoveEfficiency(getEmptyTiles().size(),score,move);
        move.move();
        if(!hasBoardChanged()){
            rollback();
            return new MoveEfficiency(-1,0,move);
        }
        else {
            rollback();
            return move0;
        }
    }
    public void autoMove(){
        PriorityQueue<MoveEfficiency>queue=new PriorityQueue(4,Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.poll().getMove().move();
    }
}
