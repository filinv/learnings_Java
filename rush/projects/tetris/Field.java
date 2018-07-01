/** Он будет отвечать за хранение данных
 * о текущих занятых и свободных клетках на поле игры*/
public class Field {
    private int width;
    private int height;
    /** первой координатой в массиве у нас будет номер строки, а второй - столбца.
     *  Другими словами ячейка с координатами x, y - это matrix[y][x]*/
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix=new int[height][width];
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    /** объект будет отрисовывать на экран свое текущее состояние*/
    public void print(){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                if(matrix[y][x]==0){
                    System.out.print(".");
                } else System.out.print("X");
            }
            System.out.println("");
        }
    }
    /** будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз*/
    public void removeFullLines(){}
    /** возвращает значение которое находится в матрице с координатами x и y*/
    public Integer getValue(int x, int y){return null;}
    /** устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y*/
    public void setValue(int x, int y, int value){}
}
