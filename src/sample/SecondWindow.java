package sample;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SecondWindow {
    private JFrame frame= new JFrame();
    private JPanel first;
    private JPanel second;
    private JPanel third;
    private JPanel panel;
    private JCheckBox checkBox;
    private JButton sudokubutton= new JButton();
    private JButton killerbutton= new JButton();
    private JButton duidokubutton= new JButton();
    private JLabel label= new JLabel();
    private SudokuFrame obj;


    public SecondWindow(){
        makeFrame();
    }
    void makeFrame(){
        frame.setTitle("Sudoku Game");
        frame.setSize(400,300);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sudokubutton = new JButton();
        sudokubutton.setText("Sudoku");
        sudokubutton.setActionCommand("Like");
        sudokubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SudokuFrame f= new SudokuFrame();
            }
        });

        killerbutton = new JButton();
        killerbutton.setText("Killer Sudoku");
        killerbutton.setActionCommand("Like");
        killerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SudokuFrame f= new SudokuFrame();
            }
        });

        duidokubutton = new JButton();
        duidokubutton.setText("Duidoku");
        duidokubutton.setActionCommand("Like");
        duidokubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SudokuFrame f=new SudokuFrame();
            }
        });
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);


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
