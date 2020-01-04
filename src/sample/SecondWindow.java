package sample;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SecondWindow
{

    MyDrawPanel draw;
    public SecondWindow(){
        go();

    }
     public void go()
    {
        JFrame frame=new JFrame("Sudoku Game");
        //Center View
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);

        JPanel panel=new JPanel();
        draw=new MyDrawPanel();
        JButton sudoku = new JButton("Sudoku");
        sudoku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //frame.dispose();
                new SudokuFrame(9);
            }
        });
        JButton killer= new JButton("Killer Sudoku");
        killer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //frame.dispose();
                new SudokuFrame(9);
            }
        });
        JButton duidoku= new JButton("Duidoku");
        duidoku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //frame.dispose();
                new DuidokuFrame(4);
            }
        });



        //Set Image Icon
        ImageIcon icon= new ImageIcon();
        try {
            frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        }
        catch(IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }

        //Set Audio to help concentration.
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("Chopin - Spring Waltz.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }


        draw.add(sudoku);
        draw.add(killer);
        draw.add(duidoku);
        frame.getContentPane().add(BorderLayout.CENTER,draw);
        panel.add(sudoku);
        panel.add(killer);
        panel.add(duidoku);
        frame.getContentPane().add(panel,BorderLayout.NORTH);
        frame.setSize(600,500);
        frame.setVisible(true);
    }
    public class MyDrawPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Image image=new ImageIcon("src/sample/512x512bb.jpg").getImage();
            g.drawImage(image,90,0,400,400,this);

        }

    }


}
