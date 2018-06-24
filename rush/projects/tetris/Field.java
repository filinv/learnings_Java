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
}
