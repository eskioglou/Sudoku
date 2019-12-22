package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SudokuFrame extends JFrame{

    private final JFrame frame = new JFrame("Sudoku");
    private SudokuGrid grid;
    private JPanel panel= new JPanel();
    private JLabel label= new JLabel();



    public SudokuFrame() {
        frame.getContentPane().add(grid = new SudokuGrid(9));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMenu();
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


    }

    private void buildMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("Menu");
        JMenuItem login = new JMenuItem("Login");
        JMenuItem new_game = new JMenuItem("New Game");
        JMenuItem hint = new JMenuItem("Hint");
        JMenuItem statistics= new JMenuItem("Statistics");
        JMenuItem back = new JMenuItem("Back");


        fileMenu.setText("Menu");
        fileMenu.add(login);
        fileMenu.addSeparator();
        fileMenu.add(login);
        fileMenu.add(new_game);
        fileMenu.add(hint);
        fileMenu.addSeparator();
        fileMenu.add(statistics);
        fileMenu.add(back);


        bar.add(fileMenu);
        fileMenu.addSeparator();

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);

        frame.setJMenuBar(bar);
    }

}
