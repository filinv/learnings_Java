import java.util.ArrayList;
import java.util.List;

/** будет содержать игровую логику и хранить игровое поле.*/
public class Model {
    /** определяющая ширину игрового поля*/
    private static final int FIELD_WIDTH = 4;
    /** текущий счет*/
    int score;
    /** максимальный вес плитки на игровом поле*/
    int maxTile;

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
    }
    /**
     * будет смотреть какие плитки пустуют и менять вес одной из них,
     * выбранной случайным образом,
     * на 2 или 4 (на 9 двоек должна приходиться 1 четверка)*/
    private void addTile(){
        getEmptyTiles().get((int)(Math.random()*getEmptyTiles().size())).value=Math.random() < 0.9 ? 2 : 4;
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
     * т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}*/
    private void compressTiles(Tile[] tiles){
        for (int j = 0; j < tiles.length - 1; j++){
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value == 0) {
                    tiles[i].value = tiles[i + 1].value;
                    tiles[i + 1].value = 0;
                }
            }
        }
    }
    /** Слияние плиток одного номинала,
     * т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
     * Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0},
     * а {4, 4, 4, 0} в {8, 4, 0, 0}
     * Счет увеличивается после каждого слияния,
     * например если текущий счет 20 и
     * было выполнено слияние ряда {4, 4, 4, 0}, счет должен увеличиться на 8*/
    private void mergeTiles(Tile[] tiles){
        for(int i=0;i<tiles.length-1;i++){
            if(!tiles[i].isEmpty()&&tiles[i].value==tiles[i+1].value){
                tiles[i].value*=2;
                score+=tiles[i].value;
                if(tiles[i].value>maxTile)maxTile=tiles[i].value;
                tiles[i+1].value=0;
                ++i;
            }
        }
        compressTiles(tiles);
    }
}
