package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static sample.Confirmation.textfield;

/**
 * This class creates the frame for the Killer window. There is also the Language Addition that initializes the Locale using the language of the
 * system. If the computer's language is Greek, it accesses the Languages_Ελληνικά and transforms the words. Same goes if the computer's
 * language is English. The frame is located in the center, it includes an icon and contains 3 buttons Solve, Save and Hint. The Solve button
 * counts the number of the green backgrounds and the number of the red. If all cells are green, it shows a message that the game is won and if
 * it contains at least a red cell, the game is lost. The solve button also creates a file with the name usernmame+"score.txt" and initializes
 * with the value 0, if the game is lost and with the value 1, if the game is won.For the next games if the game is won it adds 1 point, else it
 * adds 0 points.The Save button opens a confirmation window and once you enter the username it stores the value
 * of the matrix at the given time in a txt file with the name username+".txt". The Hint button opens another window in which you give the number
 * of the row and the column you want to check and shows a list of all the acceptable numbers using checks from the CheckKiller. The Killer
 * Frame also has a method that returns the menu. The buildmenu method is described below.
 *
 * @author Maria Eskioglou
 */

public class KillerFrame extends JPanel {
    private JFrame f;
    //---------------LANGUAGE ADDITION------------------------
    Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

    public KillerFrame(int dimension) {
        f = new JFrame(bundle.getString("Killer Game"));
        JTextField[][] Tf = new JTextField[dimension + 1][dimension + 1];
        f.setLayout(new GridLayout(dimension + 1, dimension));
        f.setSize(700, 600);
        f.setResizable(false);
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


        KillerReader reader = new KillerReader(9);
        int[][] startingKiller = reader.getUnsolvedKiller();
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                Tf[i][j] = new JTextField();
                Tf[i][j].setText(startingKiller[i - 1][j - 1] + "");
                Tf[i][j].setToolTipText(reader.getSum(startingKiller[i - 1][j - 1]) + "");
                f.add(Tf[i][j]);
                if (startingKiller[i - 1][j - 1] == 0) {
                    Tf[i][j].setBackground(Color.pink.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
                }
                if (startingKiller[i - 1][j - 1] == 1) {
                    Tf[i][j].setBackground(Color.RED);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 2) {
                    Tf[i][j].setBackground(Color.GREEN);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 3) {
                    Tf[i][j].setBackground(Color.MAGENTA);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 4) {
                    Tf[i][j].setBackground(Color.orange.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 5) {
                    Tf[i][j].setBackground(Color.LIGHT_GRAY);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 6) {
                    Tf[i][j].setBackground(Color.green.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 7) {
                    Tf[i][j].setBackground(Color.cyan.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 8) {
                    Tf[i][j].setBackground(Color.ORANGE);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 9) {
                    Tf[i][j].setBackground(Color.PINK);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 10) {
                    Tf[i][j].setBackground(Color.YELLOW);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 11) {
                    Tf[i][j].setBackground(Color.pink.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 12) {
                    Tf[i][j].setBackground(Color.RED);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 13) {
                    Tf[i][j].setBackground(Color.GREEN);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 14) {
                    Tf[i][j].setBackground(Color.MAGENTA);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 15) {
                    Tf[i][j].setBackground(Color.CYAN);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 16) {
                    Tf[i][j].setBackground(Color.LIGHT_GRAY);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 17) {
                    Tf[i][j].setBackground(Color.yellow.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 18) {
                    Tf[i][j].setBackground(Color.cyan.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 19) {
                    Tf[i][j].setBackground(Color.ORANGE);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 20) {
                    Tf[i][j].setBackground(Color.PINK);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 21) {
                    Tf[i][j].setBackground(Color.YELLOW);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 22) {
                    Tf[i][j].setBackground(Color.pink.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 23) {
                    Tf[i][j].setBackground(Color.RED);
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                    Tf[i][j].setText("0");
                }
                if (startingKiller[i - 1][j - 1] == 24) {
                    Tf[i][j].setBackground(Color.GREEN);
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                    Tf[i][j].setText("0");
                }
                if (startingKiller[i - 1][j - 1] == 25) {
                    Tf[i][j].setBackground(Color.MAGENTA);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 26) {
                    Tf[i][j].setBackground(Color.orange.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 27) {
                    Tf[i][j].setBackground(Color.LIGHT_GRAY);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 28) {
                    Tf[i][j].setBackground(Color.BLUE.brighter());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 29) {
                    Tf[i][j].setBackground(Color.cyan.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 30) {
                    Tf[i][j].setBackground(Color.ORANGE);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 31) {
                    Tf[i][j].setBackground(Color.PINK);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 32) {
                    Tf[i][j].setBackground(Color.YELLOW);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 33) {
                    Tf[i][j].setBackground(Color.pink.darker());
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 34) {
                    Tf[i][j].setBackground(Color.RED);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 35) {
                    Tf[i][j].setBackground(Color.GREEN);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 36) {
                    Tf[i][j].setBackground(Color.MAGENTA);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 37) {
                    Tf[i][j].setBackground(Color.CYAN);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 38) {
                    Tf[i][j].setBackground(Color.LIGHT_GRAY);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 39) {
                    Tf[i][j].setBackground(Color.BLUE);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }
                if (startingKiller[i - 1][j - 1] == 40) {
                    Tf[i][j].setBackground(Color.RED);
                    Tf[i][j].setText("0");
                    Tf[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

                }

            }

        }

            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    int k = i;
                    int l = j;
                    Tf[i][j].addActionListener(e -> {
                        CheckKiller check = new CheckKiller(Tf, dimension);
                        String mes = e.getActionCommand();
                        int value = parseInt(mes);
                        if (value <= 0 || value > 9) {
                            String str = "0";
                            Tf[k][l].setText(str);
                            JOptionPane.showMessageDialog(null,
                                    bundle.getString("Error: Please enter number from 1 to 9"), bundle.getString("Error Message"),
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            boolean flag = check.accept(k, l, value);
                            if (flag) {
                                String str = Tf[k][l].getToolTipText();
                                int sum = Integer.parseInt(str);
                                boolean groupSum = check.checkSum(startingKiller[k - 1][l - 1], startingKiller, sum);
                                if(groupSum){
                                    str = "" + value;
                                    Tf[k][l].setText(str);
                                    JOptionPane.showMessageDialog(null, bundle.getString("Value set"));
                                }
                                else{
                                    str = "0";
                                    Tf[k][l].setText(str);
                                    JOptionPane.showMessageDialog(null, bundle.getString("Value could not be set"));
                                }
                            } else {
                                String str = "0";
                                Tf[k][l].setText(str);
                                JOptionPane.showMessageDialog(null, bundle.getString("Value could not be set"));
                            }
                        }
                    });
                }
            }

        JButton b= new JButton(bundle.getString("Solve"));
        f.add(b);
        b.addActionListener(e -> {
            int[][] endingSudoku = reader.getSolvedKiller();
            reader.getUnsolvedKiller();

            for (int i = 1; i <= dimension; i++) {
                for (int j = 1; j <= dimension; j++) {
                    String n=Tf[i][j].getText();
                    int result = parseInt(n);
                    if(endingSudoku[i-1][j-1]==result){
                        Tf[i][j].setBackground(Color.GREEN);

                    }
                    else if(endingSudoku[i-1][j-1]!=result){
                        Tf[i][j].setBackground(Color.RED);

                    }
                    Tf[i][j].setText(endingSudoku[i-1][j-1] +"");
                }
            }
            boolean found= false;
            boolean found1=false;
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
                JOptionPane.showMessageDialog(null, bundle.getString("You lost the game!"), bundle.getString("Try Again"), JOptionPane.INFORMATION_MESSAGE);
            }
            if(found){
                JOptionPane.showMessageDialog(null,bundle.getString("You won the game!"),bundle.getString("Congratulations"), JOptionPane.INFORMATION_MESSAGE);
            }
        });


            JButton save = new JButton(bundle.getString("Save"));
            f.add(save);
            save.addActionListener(e -> {

                FileWriter fileWriter;
                try {

                    Confirmation confirmation = new Confirmation();
                    String username = confirmation.getUsername();
                    String filename = username + ".txt";
                    fileWriter = new FileWriter(filename, false);
                    PrintWriter printWriter = new PrintWriter(fileWriter);

                    String n;
                    for (int i = 1; i <= dimension; i++) {
                        for (int j = 1; j <= dimension; j++) {
                            n = Tf[i][j].getText();
                            printWriter.print(n + " ");
                        }
                        printWriter.println();
                    }
                    printWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });

            JButton hint = new JButton(bundle.getString("Hint"));
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
                frame.setTitle(bundle.getString("Hint"));
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
                label1.setText(bundle.getString("Row: "));
                text1 = new JTextField(5);

                label2 = new JLabel();
                label2.setText(bundle.getString("Column: "));
                text2 = new JTextField(5);

                OK = new JButton(bundle.getString("OK"));
                panel = new JPanel(new GridLayout(3, 1));
                panel.add(label1);
                panel.add(text1);
                panel.add(label2);
                panel.add(text2);
                panel.add(OK);
                frame.add(panel, BorderLayout.CENTER);
                OK.addActionListener(actionEvent -> {
                    JFrame frame1 = new JFrame();
                    frame1.setSize(300, 200);
                    frame1.setTitle(bundle.getString("Acceptable Numbers"));
                    frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame1.setVisible(true);

                    //Center View
                    Toolkit t11 = Toolkit.getDefaultToolkit();
                    Dimension d11 = t11.getScreenSize();
                    int x11 = (d11.width - f.getWidth()) / 2;
                    int y11 = (d11.height - f.getHeight()) / 2;
                    frame1.setLocation(x11, y11);

                    //Set Image Icon
                    new ImageIcon();
                    try {
                        frame1.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
                    } catch (IOException ex) {
                        System.out.println("When reading icon file: " + ex.getMessage());
                    }

                    String row = text1.getText();
                    String column = text2.getText();
                    int k = Integer.parseInt(row);
                    int l = Integer.parseInt(column);

                    JLabel label11 = new JLabel();
                    JLabel label21 = new JLabel();
                    JLabel label3 = new JLabel();
                    JLabel label4 = new JLabel();
                    JLabel label5 = new JLabel();
                    JLabel label6 = new JLabel();
                    JLabel label7 = new JLabel();
                    JLabel label8 = new JLabel();
                    JLabel label9 = new JLabel();
                    JPanel panel1 = new JPanel();

                    panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
                    panel1.add(label11);
                    panel1.add(label21);
                    panel1.add(label3);
                    panel1.add(label4);
                    panel1.add(label5);
                    panel1.add(label6);
                    panel1.add(label7);
                    panel1.add(label8);
                    panel1.add(label9);

                    frame1.add(panel1);

                    for(int z=0; z<45;z++) {
                        if (check.accept(k, l, 1)) {
                                label11.setText(bundle.getString("1 is acceptable \n"));
                        }
                        if (check.accept(k, l, 2)) {
                            label21.setText(bundle.getString("2 is acceptable \n"));
                        }
                        if (check.accept(k, l, 3)) {
                            label3.setText(bundle.getString("3 is acceptable \n"));
                        }
                        if (check.accept(k, l, 4)) {
                            label4.setText(bundle.getString("4 is acceptable \n"));
                        }
                        if (check.accept(k, l, 5)) {
                            label5.setText(bundle.getString("5 is acceptable \n"));
                        }
                        if (check.accept(k, l, 6)) {
                            label6.setText(bundle.getString("6 is acceptable \n"));
                        }
                        if (check.accept(k, l, 7)) {
                            label7.setText(bundle.getString("7 is acceptable \n"));
                        }
                        if (check.accept(k, l, 8)) {
                            label8.setText(bundle.getString("8 is acceptable \n"));
                        }
                        if (check.accept(k, l, 9)) {
                            label9.setText(bundle.getString("9 is acceptable \n"));
                        }
                    }
                });
            });
        }
    /**
     * The buildMenu initializes all the menu items used and used the bundle.getString in every text to get the language of the system.
     * New Game item leads to another Killer Frame. It clears all numbers set and initializes with a random set of colors.
     * Load Game item doesn't work with the Killer Frame.
     * Statistics doesn't work in the DuidokuFrame.
     * Return leads back to the SecondWindow and the user can choose from the start another version.
     */
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu(bundle.getString("Menu"));
        JMenuItem newgame = new JMenuItem(bundle.getString("New Game"));
        JMenuItem loadgame= new JMenuItem(bundle.getString("Load Game"));
        JMenuItem statistics= new JMenuItem(bundle.getString("Statistics"));
        JMenuItem returnb = new JMenuItem(bundle.getString("Return"));

        newgame.addActionListener(actionEvent -> {
            f.dispose();
            new KillerFrame(9);
        });
        loadgame.addActionListener(actionEvent -> {
            f.dispose();
            new KillerFrame(9);

        });
        statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f = new JFrame(bundle.getString("Confirmation"));
                JLabel label = new JLabel(bundle.getString("Please confirm your username:"));
                JButton button = new JButton(bundle.getString("Submit"));
                textfield = new JTextField(16);
                JPanel panel = new JPanel();
                button.addActionListener(actionEvent1 -> {
                    MyDrawPanel draw;
                    String username1= textfield.getText();
                    JFrame frame = new JFrame(username1+"'s Statistics");
                    JPanel panel1 = new JPanel();
                    draw = new MyDrawPanel();

                    frame.getContentPane().add(BorderLayout.CENTER, draw);
                    frame.getContentPane().add(panel1, BorderLayout.NORTH);
                    frame.setSize(700, 400);

                    Toolkit t = Toolkit.getDefaultToolkit();
                    Dimension d = t.getScreenSize();
                    int x = (d.width - frame.getWidth()) / 2;
                    int y = (d.height - frame.getHeight()) / 2;
                    frame.setLocation(x, y);

                    //Set Image Icon
                    new ImageIcon();
                    try {
                        frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
                    } catch (IOException ex) {
                        System.out.println("When reading icon file: " + ex.getMessage());
                    }

                    JTextField field = new JTextField();
                    field.setSize(10, 10);
                    field.setEditable(false);
                    try {
                        String filename = username1 + "score.txt";
                        BufferedReader br = new BufferedReader(new FileReader(filename));
                        String st;
                        while ((st = br.readLine()) != null)
                            field.setText(st);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    JLabel label1 = new JLabel(username1 + "'s statistics: ");
                    panel1.add(label1);
                    panel1.add(field);
                    panel1.setBackground(Color.LIGHT_GRAY);

                    try {
                        String filename = username1 + "score.txt";
                        BufferedReader br = new BufferedReader(new FileReader(filename));
                        String st;
                        while ((st = br.readLine()) != null)
                            field.setText(st);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    frame.setVisible(true);

                });

                panel.add(label);
                panel.add(textfield);
                panel.add(button);

                f.add(panel);
                f.setSize(300, 100);
                f.setVisible(true);}

                class MyDrawPanel extends JPanel
                {
                    @Override
                    public void paintComponent(Graphics g)
                    {
                        Image image=new ImageIcon("3.jpg").getImage();
                        g.drawImage(image,90,20,500,200,this);
                    }
                }
        });
        returnb.addActionListener(actionEvent -> {
            f.dispose();
            new SecondWindow();
        });

        fileMenu.setText(bundle.getString("Menu"));
        fileMenu.add(newgame);
        fileMenu.add(loadgame);
        fileMenu.addSeparator();
        fileMenu.add(statistics);
        fileMenu.add(returnb);

        bar.add(fileMenu);

        f.setJMenuBar(bar);
    }
}
