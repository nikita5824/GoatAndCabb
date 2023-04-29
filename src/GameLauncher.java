import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {
    public static void main(String[] args) {
        Field f = new Field();
    }
    /*public static void main(String[] args) {
        MainGame mg = new MainGame();

        JFrame frame = new JFrame("Goat and cabbage in minecraft");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.add(new MainWindow());
        frame.add(mg);
        mg.initField();
        //frame.setSize(width + 2* CELL_PADDING , height + 2*CELL_PADDING);
        frame.setBackground(Color.BLACK);
        frame.pack();


        Dimension preferredSize = new Dimension( mg.getField().getHeight() + 2 * mg.getField().CELL_PADDING,
                mg.getField().getWidth() + 2 * mg.getField().CELL_PADDING); //Потому что отступы с двух сторон
        frame.getContentPane().setPreferredSize(preferredSize);
        frame.pack();
        *//*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        frame.setSize(width, height);*//*
        *//*Dimension preferredSize = new Dimension( mg.getField().getWidth() + 2 * Field.CELL_PADDING,
                mg.getField().getWidth() + 2 * Field.CELL_PADDING); //Потому что отступы с двух сторон
        frame.getContentPane().setPreferredSize(preferredSize);

        frame.pack();
*//*
        frame.setVisible(true);


    }*/
}
