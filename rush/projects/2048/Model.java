/** будет содержать игровую логику и хранить игровое поле.*/
public class Model {
  /** определяющая ширину игрового поля*/
    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;

    public Model() {
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i=0;i<FIELD_WIDTH;i++){
            for (int j=0;j<FIELD_WIDTH;j++){
                gameTiles[i][j]=new Tile();
            }
        }
    }
}
