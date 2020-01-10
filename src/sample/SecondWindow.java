package sample;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class SecondWindow
{
    //---------------LANGUAGE ADDITION------------------------
    Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
    ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

    MyDrawPanel draw;

    public SecondWindow()
    {
        JFrame frame=new JFrame(bundle.getString("Sudoku Game"));
        JPanel panel=new JPanel();
        draw= new MyDrawPanel();

        JButton sudoku= new JButton("Sudoku");
        sudoku.addActionListener(actionEvent -> {
            //frame.dispose();
            try {
                new SudokuFrame(9);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        JButton killer= new JButton("Killer Sudoku");
        killer.addActionListener(actionEvent -> {
            //frame.dispose();
            new KillerFrame(9);
        });
        JButton duidoku= new JButton("Duidoku");
        duidoku.addActionListener(actionEvent -> {
            //frame.dispose();
            new DuidokuFrame(4);
        });


        draw.add(sudoku);
        draw.add(killer);
        draw.add(duidoku);
        frame.getContentPane().add(BorderLayout.CENTER,draw);
        panel.add(sudoku);
        panel.add(killer);
        panel.add(duidoku);
        frame.getContentPane().add(panel,BorderLayout.NORTH);
        frame.setSize(600,500);
        frame.setResizable(false);

        //Center View
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width-frame.getWidth())/2;
        int y = (d.height-frame.getHeight())/2;
        frame.setLocation(x, y);

        //Set Image Icon
        new ImageIcon();
        try {
            frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        }
        catch(IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }

        frame.setVisible(true);
    }
    public static class MyDrawPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            Image image=new ImageIcon("src/sample/512x512bb.jpg").getImage();
            g.drawImage(image,90,10,400,400,this);
        }
    }
}
