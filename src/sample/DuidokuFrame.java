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
 * @author Maria Eskioglou
 */
public class DuidokuFrame extends JPanel {
    private JFrame f;

    //---------------LANGUAGE ADDITION------------------------
    Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

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
        b.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,bundle.getString("You can't solve Duidoku. \n Please check Hint for help."));
        });

        JButton save= new JButton(bundle.getString("Save"));
        f.add(save);
        save.addActionListener(e -> {
            Confirmation confirmation= new Confirmation();
            String username= null;
            try {
                username = confirmation.getUsername();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
                OK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JFrame frame1= new JFrame();
                        frame1.setSize(300,200);
                        frame1.setTitle(bundle.getString("Acceptable Numbers"));
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

                        JPanel panel= new JPanel();

                        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                        panel.add(label1);
                        panel.add(label2);
                        panel.add(label3);
                        panel.add(label4);

                        frame1.add(panel);

                        CheckDui check= new CheckDui(Tf,4);

                        if (check.accept(k, l, 1)) {
                            label1.setText(bundle.getString("1 is acceptable \n"));
                        }
                        if (check.accept(k, l, 2)) {
                            label2.setText(bundle.getString("2 is acceptable \n"));
                        }
                        if (check.accept(k, l, 3)) {
                            label3.setText(bundle.getString("3 is acceptable \n"));
                        }
                        if (check.accept(k, l, 4)) {
                            label4.setText(bundle.getString("4 is acceptable \n"));
                        }
                    }
                });
            });
    }
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu(bundle.getString("Menu"));
        JMenuItem newgame = new JMenuItem(bundle.getString("New Game"));
        JMenuItem loadgame= new JMenuItem(bundle.getString("Load Game"));
        JMenuItem statistics= new JMenuItem(bundle.getString("Statistics"));
        JMenuItem returnb = new JMenuItem(bundle.getString("Return"));

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
                try {
                    new DuidokuFrame1(4);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
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