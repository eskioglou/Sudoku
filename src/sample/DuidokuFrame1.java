package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DuidokuFrame1 extends JPanel {
    private JFrame f;


    DuidokuFrame1(int dimension) {
        f = new JFrame("Duidoku Game");
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
        new ImageIcon();
        try {
            f.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        } catch (IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }
        LoadGame load= new LoadGame(4);
        int[][] startingSudoku= load.getUnsolvedSudoku();
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                Tf[i][j] = new JTextField();
                Tf[i][j].setText(startingSudoku[i][j] +"");
                f.add(Tf[i][j]);

            }
        }
        for(int i = 1; i<= dimension; i++){
            for(int j = 1; j<=dimension; j++){
                int k = i;
                int l = j;
                Tf[i][j].addActionListener(e -> {
                    CheckDui check = new CheckDui(Tf, dimension);
                    String mes = e.getActionCommand();
                    int value = Integer.parseInt(mes);
                    if (value<=0 || value >4){
                        String str = "0";
                        Tf[k][l].setText(str);
                        JOptionPane.showMessageDialog(null,
                                "Error: Please enter number from 1 to 4", "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }else{
                        boolean end = false;
                        boolean flag = check.accept(k, l, value);
                        if(flag){
                            String str = "" + value;
                            Tf[k][l].setText(str);

                            for(int a = 0; a<4; a++){
                                for(int b = 0; b<4; b++){
                                    boolean f = check.makeInactive(a, b);
                                    if(f){
                                        int i2 = check.getNumi()+1;
                                        int j2 = check.getNumj()+1;
                                        Tf[i2][j2].setText("9");

                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Value set");
                            check.movePC();
                            int num = check.getVal();
                            String v = "" +num;
                            int i1 = check.getNumi()+1;
                            int j1 = check.getNumj()+1;
                            Tf[i1][j1].setText(v);

                            for(int a = 0; a<4; a++){
                                for(int b = 0; b<4; b++){
                                    boolean f = check.makeInactive(a, b);
                                    if(f){
                                        int i3 = check.getNumi()+1;
                                        int j3 = check.getNumj()+1;
                                        Tf[i3][j3].setText("9");

                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Your turn to play");
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
            JOptionPane.showMessageDialog(null,"You can't solve Duidoku.");
        });

        JButton save= new JButton("Save");
        f.add(save);
        save.addActionListener(e -> {

            FileWriter fileWriter;
            try {

                System.out.println("Please confirm your username: ");
                Scanner x1=new Scanner(System.in);
                String username=x1.next();
                String filename= username+".txt";
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
            Check check= new Check(Tf,9);
            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    System.out.println("╔═══════════════════════╗" );
                    System.out.println("        H I N T S        ");
                    System.out.println("╚═══════════════════════╝");
                    System.out.println("{You have to give in the number of the row and column and you will get all the available values.}");
                    System.out.println("Please give me the row: ");
                    Scanner scanner= new Scanner(System.in);
                    int k=scanner.nextInt();
                    System.out.println("Please give me the column: ");
                    int l=scanner.nextInt();
                    if (check.accept(k, l, 1)) {
                        System.out.println( 1 + " is acceptable");
                    }
                    if (check.accept(k, l, 2)) {
                        System.out.println(2 + " is acceptable");
                    }
                    if (check.accept(k, l, 3)) {
                        System.out.println(3 + " is acceptable");
                    }
                    if (check.accept(k, l, 4)) {
                        System.out.println( 4 + " is acceptable");
                    }
                    return;
                }
            }
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
                new DuidokuFrame(4);
            }
        });
        loadgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                new DuidokuFrame1(4);
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