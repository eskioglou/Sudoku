package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SecondWindow {
    private JFrame frame= new JFrame();
    private JLabel label= new JLabel();


    public SecondWindow(){
        makeFrame();
    }
    void makeFrame(){
        frame.setTitle("Sudoku Game");
        frame.setSize(600,500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton sudokubutton = new JButton();
        sudokubutton.setText("Sudoku");
        sudokubutton.setActionCommand("Like");
        sudokubutton.addActionListener(actionEvent -> {
        frame.dispose();
            new SudokuFrame(9);
    });

        JButton killerbutton = new JButton();
        killerbutton.setText("Killer Sudoku");
        killerbutton.setActionCommand("Like");
        killerbutton.addActionListener(actionEvent -> {
            frame.dispose();
            new SudokuFrame(9);
        });

        JButton duidokubutton = new JButton();
        duidokubutton.setText("Duidoku");
        duidokubutton.setActionCommand("Like");
        duidokubutton.addActionListener(actionEvent -> {
            frame.dispose();
            new SudokuFrame(4);
        });
        //Center View
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);

        //Set Image Icon
        new ImageIcon();
        try {
            frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        }
        catch(IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }


        label.setText("Choose a version: ");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(sudokubutton);
        panel.add(killerbutton);
        panel.add(duidokubutton);




        frame.add(panel);

        frame.setVisible(true);
    }

}
