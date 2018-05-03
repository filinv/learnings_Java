/** класс описывающий эффективность хода
 * 1. Первый ход является лучше второго,
 * если после его совершения на поле находится больше пустых плиток,
 * чем в результате второго хода.
 * 2. Первый ход является лучше второго,
 * если общий счет после его совершения больше,
 * чем счет полученный в результате второго хода.*/
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        int i=Integer.compare(this.numberOfEmptyTiles,o.numberOfEmptyTiles);
        if(i!=0)return i;
        else {
            int j=Integer.compare(this.score,o.score);
            if(j!=0)return j;
            else return 0;
        }
    }
}
