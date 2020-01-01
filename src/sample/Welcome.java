package sample;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.IOException;

public class Welcome {
    private JFrame frame;

    public Welcome(){ makeFrame();}
    private void makeFrame(){
        frame=new JFrame();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JButton signIn = new JButton();
        JButton signUp = new JButton();
        JButton anon = new JButton();

        signIn.setText("Sign In");
        signIn.setActionCommand("Sign In");
        signIn.addActionListener(actionEvent -> {
            frame.dispose();
            new Registration();
        });

        signUp.setText("Sign Up");
        signUp.setActionCommand("Sign Up");
        signUp.addActionListener(actionEvent -> frame.dispose());

        //If the player doesn't want to sign Up or sign In, they will immediately go to the second frame and begin the game.
        anon.setText("Anonymous");
        anon.addActionListener(actionEvent -> {
            frame.dispose();
            new SecondWindow();
        });

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

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(signIn);
        panel.add(signUp);
        panel.add(anon);

        panel.setLocation(20,20);

        frame.add(panel);
        frame.setVisible(true);

    }

}
