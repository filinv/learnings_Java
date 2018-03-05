public class Canvas {
  private int width,height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix=new char[height+2][width+2];
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
    public void setPoint(double x, double y, char c){
        int xx=(int)Math.round(x);
        int yy=(int)Math.round(y);
        if(!(xx<0||yy<0||yy>matrix.length||xx>matrix[0].length)){
            matrix[yy][xx]=c;
        }
    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        int height = matrix.length;
        int width = matrix[0].length;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]==1){
                    setPoint(x+j,y+i,c);
                }
            }
        }
    }
    public void clear(){
        this.matrix=new char[height+2][width+2];
    }
    public void print(){
        System.out.println();
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
