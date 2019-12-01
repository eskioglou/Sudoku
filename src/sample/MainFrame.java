package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    //private JTextArea textArea;
    private JButton button;

    public MainFrame(){
        super("Sudoku");

        setLayout(new BorderLayout());

        toolbar=new Toolbar();
        //textArea=new JTextArea();
        button=new JButton("Start");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //textArea.append("Hello \n"); //Here load a certain sudoku.txt to initiate game.

            }
        });
        add(toolbar,BorderLayout.CENTER);
        //add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.NORTH);

        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
