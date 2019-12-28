package sample;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SecondWindow {
    private JFrame frame= new JFrame();
    private JPanel panel;
    private JButton sudokubutton= new JButton();
    private JButton killerbutton= new JButton();
    private JButton duidokubutton= new JButton();
    private JLabel label= new JLabel();


    public SecondWindow(){
        makeFrame();
    }
    void makeFrame(){
        frame.setTitle("Sudoku Game");
        frame.setSize(600,500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sudokubutton = new JButton();
        sudokubutton.setText("Sudoku");
        sudokubutton.setActionCommand("Like");
        sudokubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                int status = chooser.showOpenDialog(frame);

                if (status == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
            }
        }

        });

        killerbutton = new JButton();
        killerbutton.setText("Killer Sudoku");
        killerbutton.setActionCommand("Like");
        killerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SudokuFrame f= new SudokuFrame(9);
            }
        });

        duidokubutton = new JButton();
        duidokubutton.setText("Duidoku");
        duidokubutton.setActionCommand("Like");
        duidokubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SudokuFrame f=new SudokuFrame(4);
            }
        });
        //Center View
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);

        //Set Image Icon
        ImageIcon icon= new ImageIcon();
        try {
            frame.setIconImage(ImageIO.read(new File("C:\\Users\\Anastasia Kara\\Desktop\\512x512bb.jpg")));
        }
        catch(IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }


        label.setText("Choose a version: ");
        panel=new JPanel();
        panel.add(label);
        panel.add(sudokubutton);
        panel.add(killerbutton);
        panel.add(duidokubutton);




        frame.add(panel);

        frame.setVisible(true);
    }

}
