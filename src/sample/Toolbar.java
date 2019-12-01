package sample;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
    private JButton classicSudoku;
    private JButton killerSudoku;
    //private JButton duoSudoku;

    public Toolbar(){
        classicSudoku=new JButton("Classic Sudoku");
        killerSudoku=new JButton("Killer Sudoku");
        //duoSudoku=new JButton("Duo Sudoku");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(classicSudoku);
        add(killerSudoku);
        //add(duoSudoku);
    }
}
