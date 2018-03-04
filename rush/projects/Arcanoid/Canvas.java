public class Canvas {
  private int width,height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix=new char[height+2][width+2];
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
