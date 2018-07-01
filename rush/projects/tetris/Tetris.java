public class Tetris {
    private Field field;
    private Figure figure;
    public static Tetris game;
    private boolean isGameOver;

    public Tetris(int width, int height) {
        field = new Field(width, height);
        figure = null;
    }
    public static void main(String[] args) throws Exception {
        game = new Tetris(10, 20);
        game.run();
    }
    
    public void run() throws Exception {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
        isGameOver = false;
        //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //пока игра не окончена
        while (!isGameOver) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                //получить самое первое событие из очереди
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;
                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                    //Если  код клавиши равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
                else if (event.getKeyCode() == 12)
                    figure.rotate();
                    //Если "пробел" - фигурка падает вниз на максимум
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //делаем очередной шаг
            field.print();      //печатаем состояние "поля"
            Thread.sleep(300);  //пауза 300 миллисекунд - 1/3 секунды
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over");
    }
    /**Один шаг игры*/
    public void step() {
        //опускам фигурку вниз
        figure.down();
        //если разместить фигурку на текущем месте невозможно:
        if(!figure.isCurrentPositionAvailable()){
            //поднимаем обратно
            figure.up();
            //приземляем
            figure.landed();
            //если фигурка приземлилась на самом верху - игра окончена
            if(figure.getY()==0)isGameOver=true;
            //удаляем заполненные линии
            field.removeFullLines();
            //создаем новую фигурку
            figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);
        }
    }
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
    public void setField(Field field) {
        this.field = field;
    }
}
