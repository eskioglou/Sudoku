package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class opens the Duidoku game with graphics.
 *
 *
 * Initialization and ActionListener for the JTextField cells of the Duidoku matrix by Paschalina Lyssoudi
 * @author Paschalina lyssoudi
 * Frame, all buttons, menu and graphic interfaces with their ActionListeners by Maria Eskioglou
 * This class creates the frame for the Duidoku window. There is also the Language Addition that initializes the Locale using the language of the
 * system. If the computer's language is Greek, it accesses the Languages_Ελληνικά and transforms the words. Same goes if the computer's
 * language is English. The frame is located in the center, it includes an icon and contains 3 buttons Solve, Save and Hint. The Solve button
 * shows a message that you can't solve Duidoku. The Save button opens a confirmation window and once you enter the username it stores the value
 * of the matrix at the given time in a txt file with the name username+".txt". The Hint button opens another window in which you give the number
 * of the row and the column you want to check and shows a list of all the acceptable numbers using checks from the CheckDui. The DuidokuFrame also
 * has a method that returns the menu. The buildmenu method is described below.
 * @author Maria Eskioglou
 */
public class DuidokuFrame extends JPanel {
    private JFrame f;

    //---------------LANGUAGE ADDITION------------------------
    Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

    /**
     * DuidokuFrame's Constructor.
     * It initializes all the swing elements used to build the frame and contains the buildMenu method.
     * @param dimension In the specific case it's always 4.
     */
    DuidokuFrame(int dimension) {
        f = new JFrame(bundle.getString("Duidoku Game"));
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

        /**
         * Creates the type JTextField matrix Tf With dimension 4 and initializes it with text 0
         * Adds each cell to the Frame
         */
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                Tf[i][j] = new JTextField();
                Tf[i][j].setText("0");
                f.add(Tf[i][j]);
            }
        }

        /**
         * Adds ActionListener to each type JTextField cell of the matrix
         * Reads the value the player types, and performs needed Checks using a class DuiCheck object
         * If acceptance tests pass, inactivates cells that have no acceptable values using method makeInactive of object from class DuiCheck
         * Continues with a computer move and its acceptance checks using movePC of object from class DuiCheck
         * Shows pop-up messages for acceptable or unacceptable values given, and whether it is player's time to make a move
         */
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
                                bundle.getString("Error: Please enter number from 1 to 4"), bundle.getString("Error Message"),
                                JOptionPane.ERROR_MESSAGE);
                    }else{
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
                            JOptionPane.showMessageDialog(null, bundle.getString("Value set"));
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
                            JOptionPane.showMessageDialog(null, bundle.getString("Your turn to play"));
                        }else{
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
        b.addActionListener(e -> JOptionPane.showMessageDialog(null,bundle.getString("You can't solve Duidoku. \n Please check Hint for help.")));

        JButton save= new JButton(bundle.getString("Save"));
        f.add(save);
        save.addActionListener(e -> {
            Confirmation confirmation= new Confirmation();
            String username;
            username = confirmation.getUsername();
            String filename= username+".txt";

            FileWriter fileWriter;
            try {
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

            JButton hint= new JButton(bundle.getString("Hint"));
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
                    JFrame frame1= new JFrame();
                    frame1.setSize(300,200);
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
                    int k=Integer.parseInt(row);
                    int l= Integer.parseInt(column);

                    JLabel label11 = new JLabel();
                    JLabel label21 = new JLabel();
                    JLabel label3= new JLabel();
                    JLabel label4= new JLabel();

                    JPanel panel1 = new JPanel();

                    panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
                    panel1.add(label11);
                    panel1.add(label21);
                    panel1.add(label3);
                    panel1.add(label4);

                    frame1.add(panel1);

                    CheckDui check= new CheckDui(Tf,4);

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
                });
            });
    }

    /**
     * The buildMenu initializes all the menu items used and used the bundle.getString in every text to get the language of the system.
     * New Game item leads to another Duidoku Frame. It clears all numbes set.
     * Load Game item leads to DuidokuFrame1, which is identical with the DuidokuFrame with the exception that it loads a file.
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
            new DuidokuFrame(4);
        });
        loadgame.addActionListener(actionEvent -> {
            f.dispose();
            try {
                new DuidokuFrame1(4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        statistics.addActionListener(actionEvent -> f.dispose());
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