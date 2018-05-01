import java.util.ArrayList;
import java.util.List;

/** будет содержать игровую логику и хранить игровое поле.*/
public class Model {
    /** определяющая ширину игрового поля*/
    private static final int FIELD_WIDTH = 4;

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
}
