package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SudokuFrame extends JPanel {
        private JFrame f;


        public SudokuFrame(int dimension) {
            f = new JFrame("Sudoku Game");
            JTextField[][] Tf = new JTextField[dimension+1][dimension+1];
            f.setLayout(new GridLayout(dimension+1, dimension));
            f.setSize(700, 600);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
            buildMenu();


            //Center View
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            int x = (d.width-f.getWidth())/2;
            int y = (d.height-f.getHeight())/2;
            f.setLocation(x, y);

            //Set Image Icon
            new ImageIcon();
            try {
                f.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
            } catch (IOException ex) {
                System.out.println("When reading icon file: " + ex.getMessage());
            }

            GameReader reader= new GameReader(9);
            int[][] startingSudoku= reader.getUnsolvedSudoku();
            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    Tf[i][j] = new JTextField();
                    Tf[i][j].setText(startingSudoku[i][j] +"");
                    if(startingSudoku[i][j]!=0) {
                        Tf[i][j].setFont(new Font("Tahoma", Font.BOLD, 14));
                        Tf[i][j].setEditable(false);
                    }

                    f.add(Tf[i][j]);

                }
            }
            for(int i = 1; i<= dimension; i++){
                for(int j = 1; j<=dimension; j++){
                    int k = i;
                    int l = j;
                    Tf[i][j].addActionListener(e -> {
                        Check check = new Check(Tf, dimension);
                        String mes = e.getActionCommand();
                        int value = Integer.parseInt(mes);
                        if (value<=0 || value >9){
                            String str = "0";
                            Tf[k][l].setText(str);
                            JOptionPane.showMessageDialog(null,
                                    "Error: Please enter number from 1 to 9", "Error Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }else{

                            boolean flag = check.accept(k, l, value);
                            if(flag){
                                String str = "" + value;
                                Tf[k][l].setText(str);
                                JOptionPane.showMessageDialog(null, "Value set");
                            }else{
                                String str = "0";
                                Tf[k][l].setText(str);
                                JOptionPane.showMessageDialog(null, "Value could not be set");
                            }

                        }
                    });
                }
            }

            JButton b= new JButton("Solve");
            f.add(b);
            b.addActionListener(e -> {
                int[][] endingSudoku= reader.getSolvedSudoku();
                for (int i = 1; i <= dimension; i++) {
                    for (int j = 1; j <= dimension; j++) {
                        Tf[i][j].setText(endingSudoku[i][j] +"");

                    }
                }

            });


        }
        private void buildMenu() {
            JMenuBar bar = new JMenuBar();
            JMenu fileMenu = new JMenu("Menu");
            JMenuItem newgame = new JMenuItem("New Game");
            JMenuItem hint = new JMenuItem("Hint");
            JMenuItem statistics= new JMenuItem("Statistics");
            JMenuItem returnb = new JMenuItem("Return");

            newgame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    f.dispose();
                    new SudokuFrame(9);
                }
            });
            hint.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    f.dispose();
                }
            });
            statistics.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    f.dispose();
                }
            });
            returnb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    f.dispose();
                    new SecondWindow();
                }
            });


            fileMenu.setText("Menu");
            fileMenu.add(newgame);
            fileMenu.add(hint);
            fileMenu.addSeparator();
            fileMenu.add(statistics);
            fileMenu.add(returnb);


            bar.add(fileMenu);



            f.setJMenuBar(bar);

        }
    }