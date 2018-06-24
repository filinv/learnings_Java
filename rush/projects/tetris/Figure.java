/** Этот класс будет описывать падающую фигурку*/
public class Figure {
    private int x,y;
    /** За форму будет отвечать матрица.
     * Двумерный массив 3×3, состоящий из единиц и нулей.
     * Единицей мы обозначаем что клетка есть, нулем - что она пустая*/
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int[][] getMatrix() {
        return matrix;
    }
}
