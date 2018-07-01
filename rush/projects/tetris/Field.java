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
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }
        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }
        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    /** будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз*/
    public void removeFullLines() {
        ArrayList<int[]> lines=new ArrayList<>();
        for(int y=0;y<height;y++){
            int linesvalue=0;
            for(int x=0;x<width;x++){
                linesvalue+=matrix[y][x];
            }
            if(linesvalue==matrix.length)matrix[y]=null;
            else if(matrix[y]!=null)lines.add(matrix[y]);
        }
        int count=height-lines.size();
        for(int i=0;i<count;i++){
            int[] line=new int[width];
            for(int j=0;j<width;j++){
                line[j]=0;
            }
            lines.add(0,line);
        }
        for(int y=0;y<height;y++){
            matrix[y]=lines.get(y);
        }
        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу
    }
    /** возвращает значение которое находится в матрице с координатами x и y*/
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];
        return null;
    }
    /** устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y*/
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }
}
