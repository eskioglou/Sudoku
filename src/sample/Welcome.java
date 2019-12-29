package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;

import static java.awt.Transparency.BITMASK;

public class Welcome {
    private JFrame frame;
    private JPanel panel;
    private JPanel sec;
    private JPanel third;
    private JButton signIn;
    private JButton signUp;
    private JButton anon;
    private JTextField textField;

    public Welcome(){ makeFrame();}
    private void makeFrame(){
        frame=new JFrame();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        FlowLayout f=new FlowLayout();
        textField= new JTextField(20);

        signIn= new JButton();
        signUp= new JButton();
        anon= new JButton();


        signIn.setText("Sign In");
        signIn.setActionCommand("Sign In");
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SecondWindow w= new SecondWindow();
            }
        });

        signUp.setText("Sign Up");
        signUp.setActionCommand("Sign In");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SecondWindow w= new SecondWindow();
            }
        });

        anon.setText("Anonymous");
        anon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                SecondWindow w= new SecondWindow();
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
            frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        }
        catch(IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }

        panel=new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2,3,2,3));
        sec = new JPanel(new GridBagLayout());
        sec.setBorder(new EmptyBorder(5,5,5,5));
        third = new JPanel(new GridLayout(1,3,20,20));

        textField.setText("Hello");

        third.add(signUp);
        third.add(signIn);
        third.add(anon);


        sec.add(third);
        panel.add(sec,BorderLayout.PAGE_END);


        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }

}
