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
    public void left(){}
    public void right(){}
    public void down(){}
    public void up(){}
    /** для поворота фигурки вокруг главной диагонали*/
    public void rotate(){}
    /** падение фигурки в низ до дна*/
    public void downMaximum(){}
    /** проверка - может ли фигурка быть помещена в текущую позицию.*/
    public boolean isCurrentPositionAvailable(){return true;}
    /** вызывается, когда фигурка достигла дна или уперлась в другую фигурку.
     * Все ее занятые клетки теперь должны добавиться в Field*/
    public void landed(){}
}
