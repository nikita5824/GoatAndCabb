import javax.swing.*;

public class Field extends JPanel {


    //Размер стороны клетки в пикселях
    public static final int CELL_SIZE = 50;

    //Отступ
    public static final int CELL_PADDING = 10;


    //число строк и столбцов (нужно будет в главном классе)
    public static final int ROWS = 10;
    public static final int COLS = 10;

    // Длина и высота в пикселях (пока что настраивается в сериализации)
    private final int width, height; // cols * CELL_SIZE;
                                     // rows * CELL_SIZE;

    //Массив всех клеток
    //private ArrayList <Cell> cells = new ArrayList<>();
    private Cell [][] cells;


    public Field() {

        //default расстановка
//        if(!isSerialization){

        cells = new Cell[ROWS][COLS];

        width = COLS * CELL_SIZE;
        height = ROWS * CELL_SIZE;

        cells = FieldGenerator.generateField(cells, this).clone();
    }

    public Cell getCells(int x, int y) {
        return cells[x][y];
    }

    public void addObject(int x, int y, GameObject object) {
        cells[x][y].addObject(x, y, object);
    }

    public void removeObject(int x, int y) {
        cells[x][y].removeObject();
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public int getWidthOfField() {
        return width;
    }
    public int getHeightOfField() {
        return height;
    }

    //Циклом
      //  cells.addAll(FieldGenerator.generateField(rows, cols));
/*
        }
*//*
        *//*} else {
            cells.addAll(FieldGenerator.generateFieldSerialization());
        }*//*
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Color colorLines = new Color(43, 130, 78, 255);
        Color colorBackground = new Color(59, 191, 112, 255);
        setBackground(colorBackground);
        int i = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                *//**
                 * Здесь значение X и Y поменять на X и Y класса Cell (то есть вызвать массив Cell из класса Field)
                 *//*
                *//*g2d.setColor(colorLines);
                g2d.setBackground(colorBackground);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawRect(cells.get(i).getX(), cells.get(i).getY(), Field.CELL_SIZE, Field.CELL_SIZE);
                g2d.drawImage(cells.get(i).getGrave(), cells.get(i).getX(), cells.get(i).getY(),
                        Field.CELL_SIZE, Field.CELL_SIZE, null);

                //Тут координаты козы
                if(row == 1 && col == 1){
                    g2d.drawImage(cells.get(i).isHasGoat().getGoat(), 4 * Field.CELL_SIZE + Field.CELL_PADDING,
                            3 * Field.CELL_SIZE + Field.CELL_PADDING, Field.CELL_SIZE, Field.CELL_SIZE,null );
                }

                if(row == 0 || row == rows - 1 || col == 0 || col == cols - 1){
                    g2d.drawImage(cells.get(i).isHasFence().getFence(), cells.get(i).getX(), cells.get(i).getY(),
                            Field.CELL_SIZE, Field.CELL_SIZE, null);
                }*//*
                i++;
            }
        }

//        cabbageX = 7 * Field.CELL_SIZE + Field.CELL_PADDING;
//        cabbageY = 7 * Field.CELL_SIZE + Field.CELL_PADDING;
//        g2d.drawImage(cabbage, cabbageX, cabbageY, Field.CELL_SIZE, Field.CELL_SIZE, null);
//
//        barrelX = 2 * Field.CELL_SIZE + Field.CELL_PADDING;
//        barrelY = 6 * Field.CELL_SIZE + Field.CELL_PADDING;
//        g2d.drawImage(barrel, barrelX, barrelY, Field.CELL_SIZE, Field.CELL_SIZE, null);
    }*/
}
