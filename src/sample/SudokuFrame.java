package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

    public class SudokuFrame extends JPanel {
        private Tables obj;
        private File f1;
        private JFrame f;

        SudokuFrame(int dimension) {
            f = new JFrame("Sudoku Game");
            JTextField[][] Tf = new JTextField[dimension+1][dimension+1];
            f.setLayout(new GridLayout(dimension+1, dimension));
            f.setSize(600, 500);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            buildMenu();

            //Center View
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            int x = (d.width - f.getWidth()) / 2;
            int y = (d.height - f.getHeight()) / 2;
            f.setLocation(x, y);

            //Set Image Icon
            ImageIcon icon = new ImageIcon();
            try {
                f.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
            } catch (IOException ex) {
                System.out.println("When reading icon file: " + ex.getMessage());
            }

            GameReader reader= new GameReader(9, "src/sample/sudoku/s1.txt");
            int[][] startingSudoku= reader.getUnsolvedSudoku();
            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    Tf[i][j] = new JTextField();
                    Tf[i][j].setText(startingSudoku[i][j] +"");
                    f.add(Tf[i][j]);
                }
            }

            JButton b = new JButton("Solve");
            f.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int sudb[][] = new int[dimension+1][dimension+1];
                    int suda[][] = new int[dimension+1][dimension+1];
                    for (int i = 1; i <= dimension; i++) {
                        for (int j = 1; j <= dimension; j++) {
                            try {
                                if ((Tf[i][j].getText()) == "") sudb[i][j] = 0;
                                else {
                                    sudb[i][j] = Integer.parseInt(Tf[i][j].getText());
                                }
                            } catch (Exception ee) {//System.out.println("error"+ee);
                            }
                        }
                    }

                    for (int i = 1; i <= dimension; i++) {
                        for (int j = 1; j <= dimension; j++) {
                            Tf[i][j].setText("" + suda[i][j]);
                        }
                    }
                }
            });
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

            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            int x = (d.width-f.getWidth())/2;
            int y = (d.height-f.getHeight())/2;
            f.setLocation(x, y);

            f.setJMenuBar(bar);

        }
    }