import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class FieldGenerator  {


    public static Cell[][] generateField(Cell [][] cells, Field field) {
        /*
        ArrayList<Cell> cells = new ArrayList<>();

        int[] coordinatesCabbage = {1, 1};

        int[][] coordinatesBarrels = {
                {3, 1}, {3, 2}, {3, 3}, {3, 5}, {3, 6}, {3, 7}, {3, 8},
                {6, 1}, {6, 2}, {6, 3}, {6, 5}, {6, 6}, {6, 7}, {6, 8}
        };

        int[][] innerFence = {
                {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6}, {4, 7}
        };

        int flagForList = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //Добавляет клетку
                cells.add(new Cell(col * Field.CELL_SIZE + Field.CELL_PADDING,
                        row * Field.CELL_SIZE + Field.CELL_PADDING));

               */
        /*
               //Установить местоположение капусты
                if (row == coordinatesCabbage[0] && col == coordinatesCabbage[1]) {
                    cells.get(flagForList).addObj(new Cabbage());
                }

                //Прогоняем циклом Barrels и определяем, где должны быть бочки
                for (int[] currentCell : coordinatesBarrels) {
                    if (currentCell[0] == row && currentCell[1] == col) {
                        cells.get(flagForList).addObj(new Barrel());
                    }
                }

                //Прогоняем циклом innerFence и определяем, где должны быть заборы внутри
                for (int[] currentCell : innerFence) {
                    if (currentCell[0] == row && currentCell[1] == col) {
                        cells.get(flagForList).addObj(new Fence());
                    }
                }

                //Добавляет забор, где нужно
                if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
                    cells.get(flagForList).addObj(new Fence());
                }
                flagForList++;
            }*/

        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[row].length; col++){
                cells[row][col] = new Cell(row, col);

                if (row == 0 || row == cells.length - 1 || col == 0 || col == cells[row].length - 1) {
                    new Fence(row, col, field);
                }
            }
        }
        return cells;
    }


 /*   public static Field generateField(Field myField){

        FileInputStream fis;
        int numbOfField = (int) (Math.random() * 3);

        try {
            if(numbOfField == 0) {
                fis = new FileInputStream("first_field.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                myField = (Field) ois.readObject();
                System.out.println(myField.getRows());
                System.out.println(myField.getCols());
                System.out.println(Field.CELL_SIZE);
                System.out.println(Field.CELL_PADDING);
                myField.setWidth(myField.getRows() * Field.CELL_SIZE);
                myField.setHeight(myField.getCols() * Field.CELL_SIZE);

                System.out.println(myField.getWidth());
                System.out.println(myField.getHeight());
                ois.close();
            }

            if(numbOfField == 1){
                fis = new FileInputStream("second_field.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                myField = (Field) ois.readObject();
                System.out.println(myField.getRows());
                System.out.println(myField.getCols());
                System.out.println(Field.CELL_SIZE);
                System.out.println(Field.CELL_PADDING);

                myField.setWidth(myField.getRows() * Field.CELL_SIZE);
                myField.setHeight(myField.getCols() * Field.CELL_SIZE);

                System.out.println(myField.getWidth());
                System.out.println(myField.getHeight());
                ois.close();
            }

            if(numbOfField == 2){
                fis = new FileInputStream("third_field.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                myField = (Field) ois.readObject();
                System.out.println(myField.getRows());
                System.out.println(myField.getCols());
                System.out.println(Field.CELL_SIZE);
                System.out.println(Field.CELL_PADDING);

                myField.setWidth(myField.getRows() * Field.CELL_SIZE);
                myField.setHeight(myField.getCols() * Field.CELL_SIZE);

                System.out.println(myField.getWidth());
                System.out.println(myField.getHeight());
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return myField;
    }


        }
        return cells;
    }

    //Дописать класс с сериализацией
    public static ArrayList<Cell> generateFieldSerialization(){
        ArrayList<Cell> cells = new ArrayList<>();



        return cells;
    }
*/

}
