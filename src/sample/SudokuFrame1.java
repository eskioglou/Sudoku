package sample;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SudokuFrame1 extends JPanel {
    private JFrame f;


    public  SudokuFrame1(int dimension) throws IOException {
        f = new JFrame("Sudoku Game");
        JTextField[][] Tf = new JTextField[dimension+1][dimension+1];
        f.setLayout(new GridLayout(dimension+1, dimension));
        f.setSize(700, 600);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


            System.out.println("!!!!!Please confirm your username: ");
            Scanner xx= new Scanner(System.in);
            String username=xx.nextLine();
            String pathname= username+".txt";
            File file1= new File(pathname);

        SudokuReader reader= new SudokuReader(9,file1);
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
                    int value = parseInt(mes);
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
            int[][] endingSudoku = reader.getSolvedSudoku();
            int[][] startingSudoku1= reader.getUnsolvedSudoku();

            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    String n=Tf[i][j].getText();

                    int result = parseInt(n);
                    if(endingSudoku[i][j]==result && result!=startingSudoku1[i][j] ){
                        Tf[i][j].setBackground(Color.GREEN);

                    }
                    else if(endingSudoku[i][j]!=result){
                        Tf[i][j].setBackground(Color.RED);

                    }
                    Tf[i][j].setText(endingSudoku[i][j] +"");
                }
            }
            Boolean found= false;
            Boolean found1=false;
            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    if(Tf[i][j].getBackground()==Color.GREEN) {
                        found=true;
                        found1=false;
                    }
                    else{
                        found1=true;
                        found=false;
                    }
                }
            }
            if(!found&&found1) {
                JOptionPane.showMessageDialog(null, "You lost the game!", "Try Again", 1);
            }
            if(found&&!found1){
                JOptionPane.showMessageDialog(null,"You won the game!","Congratulations", 1);
            }
        });


        JButton save= new JButton("Save");
        f.add(save);
        save.addActionListener(e -> {

            FileWriter fileWriter;
            try {

                Confirmation confirmation= new Confirmation();
                String username1=confirmation.getUsername();
                String filename= username1+".txt";
                fileWriter = new FileWriter(filename,false);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                String n ;
                for (int i = 1; i <= dimension; i++) {
                    for (int j = 1; j <= dimension; j++) {
                        n=Tf[i][j].getText();
                        printWriter.print(n+" ");
                    }
                    printWriter.println();
                }
                printWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        JButton hint= new JButton("Hint");
        f.add(hint);
        hint.addActionListener(e -> {
            JButton OK;
            JPanel panel;
            JLabel label1, label2;
            final JTextField text1, text2;

            JFrame frame = new JFrame();
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setTitle("Hints");
            frame.setVisible(true);

            //Center View
            Toolkit t1 = Toolkit.getDefaultToolkit();
            Dimension d1 = t1.getScreenSize();
            int x1 = (d1.width - f.getWidth()) / 2;
            int y1 = (d1.height - f.getHeight()) / 2;
            frame.setLocation(x1, y1);

            //Set Image Icon
            new ImageIcon();
            try {
                frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
            } catch (IOException ex) {
                System.out.println("When reading icon file: " + ex.getMessage());
            }

            Check check = new Check(Tf, 9);
            label1 = new JLabel();
            label1.setText("Row: ");
            text1 = new JTextField(5);

            label2 = new JLabel();
            label2.setText("Column: ");
            text2 = new JTextField(5);

            OK = new JButton("OK");
            panel = new JPanel(new GridLayout(3, 1));
            panel.add(label1);
            panel.add(text1);
            panel.add(label2);
            panel.add(text2);
            panel.add(OK);
            frame.add(panel, BorderLayout.CENTER);
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JFrame frame1= new JFrame();
                    frame1.setSize(300,200);
                    frame1.setTitle("Acceptable Numbers");
                    frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame1.setVisible(true);

                    //Center View
                    Toolkit t1 = Toolkit.getDefaultToolkit();
                    Dimension d1 = t1.getScreenSize();
                    int x1 = (d1.width - f.getWidth()) / 2;
                    int y1 = (d1.height - f.getHeight()) / 2;
                    frame1.setLocation(x1, y1);

                    //Set Image Icon
                    new ImageIcon();
                    try {
                        frame1.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
                    } catch (IOException ex) {
                        System.out.println("When reading icon file: " + ex.getMessage());
                    }

                    String row = text1.getText();
                    String column = text2.getText();
                    int k=Integer.parseInt(row);
                    int l= Integer.parseInt(column);

                    JLabel label1= new JLabel();
                    JLabel label2= new JLabel();
                    JLabel label3= new JLabel();
                    JLabel label4= new JLabel();
                    JLabel label5= new JLabel();
                    JLabel label6= new JLabel();
                    JLabel label7= new JLabel();
                    JLabel label8= new JLabel();
                    JLabel label9= new JLabel();
                    JPanel panel= new JPanel();

                    panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                    panel.add(label1);
                    panel.add(label2);
                    panel.add(label3);
                    panel.add(label4);
                    panel.add(label5);
                    panel.add(label6);
                    panel.add(label7);
                    panel.add(label8);
                    panel.add(label9);

                    frame1.add(panel);

                    if (check.accept(k, l, 1)) {
                        label1.setText("1 is acceptable \n");
                    }
                    if (check.accept(k, l, 2)) {
                        label2.setText("2 is acceptable \n");
                    }
                    if (check.accept(k, l, 3)) {
                        label3.setText("3 is acceptable \n");
                    }
                    if (check.accept(k, l, 4)) {
                        label4.setText("4 is acceptable \n");
                    }
                    if (check.accept(k, l, 5)) {
                        label5.setText("5 is acceptable \n");
                    }
                    if (check.accept(k, l, 6)) {
                        label6.setText("6 is acceptable \n");
                    }
                    if (check.accept(k, l, 7)) {
                        label7.setText("7 is acceptable \n");
                    }
                    if (check.accept(k, l, 8)) {
                        label8.setText("8 is acceptable \n");
                    }
                    if (check.accept(k, l, 9)) {
                        label9.setText("9 is acceptable \n");
                    }
                }
            });
        });

    }
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");
        JMenuItem newgame = new JMenuItem("New Game");
        JMenuItem loadgame= new JMenuItem("Load Game");
        JMenuItem statistics= new JMenuItem("Statistics");
        JMenuItem returnb = new JMenuItem("Return");

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                try {
                    new SudokuFrame(9);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        loadgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                try {
                    new SudokuFrame1(9);
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
        fileMenu.add(loadgame);
        fileMenu.addSeparator();
        fileMenu.add(statistics);
        fileMenu.add(returnb);

        bar.add(fileMenu);

        f.setJMenuBar(bar);
    }
}