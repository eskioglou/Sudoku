package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*;
//--------LANGUAGE ADDITION-----------
import java.util.Locale;
import java.util.ResourceBundle;
//------------------------------------
import java.util.Scanner;

public class Welcome {
    SecondWindow.MyDrawPanel draw;
    JButton signIn;
    JButton signUp;
    JButton anon;

    public Welcome() {
//---------------LANGUAGE ADDITION------------------------
        Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
        ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------
        JFrame frame = new JFrame(bundle.getString("Sudoku Game"));
        JPanel panel = new JPanel();
        draw = new SecondWindow.MyDrawPanel();


        signIn = new JButton();
        signUp = new JButton();
        anon = new JButton();


        signIn.setText(bundle.getString("Sign In"));
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1;
                JLabel nameLabel = new JLabel(bundle.getString("Username:"));
                JLabel passwordLabel = new JLabel(bundle.getString("Password:"));
                JTextField nameTextField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                JButton login = new JButton(bundle.getString("Login"));

                frame1 = new JFrame();
                frame1.setTitle(bundle.getString("Login"));
                frame1.setBounds(40, 40, 380, 300);
                frame1.getContentPane().setBackground(Color.pink.darker());
                frame1.getContentPane().setLayout(null);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setResizable(false);

                Toolkit t = Toolkit.getDefaultToolkit();
                Dimension d = t.getScreenSize();
                int x = (d.width - frame1.getWidth()) / 2;
                int y = (d.height - frame1.getHeight()) / 2;
                frame1.setLocation(x, y);

                //Set Image Icon
                ImageIcon icon = new ImageIcon();
                try {
                    frame1.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
                } catch (IOException ex) {
                    System.out.println("When reading icon file: " + ex.getMessage());
                }

                nameLabel.setBounds(20, 10, 80, 70);
                passwordLabel.setBounds(20, 70, 100, 70);
                nameTextField.setBounds(180, 43, 165, 23);
                passwordField.setBounds(180, 93, 165, 23);
                login.setBounds(220, 150, 100, 35);

                frame1.add(nameLabel);
                frame1.add(passwordLabel);
                frame1.add(nameTextField);
                frame1.add(passwordField);
                frame1.add(login);

                login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        boolean found = false;
                        String tempUsername = "";
                        String tempPassword = "";

                        Scanner x;
                        String username = nameTextField.getText();
                        String password = passwordField.getText();
                        String filepath = "login.txt";
                        try {
                            x = new Scanner(new File(filepath));
                            x.useDelimiter("[,\n]");

                            while (x.hasNext() && !found) {
                                tempUsername = x.next();
                                tempPassword = x.next();

                                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                                    found = true;
                                    File file = new File(username + "score.txt");
                                    try {
                                        FileWriter myWriter = new FileWriter(file);
                                        myWriter.write("0");
                                        myWriter.close();
                                        frame.dispose();
                                        frame1.dispose();
                                        new SecondWindow();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(bundle.getString("Error"));
                        }
                    }
                });
            }
        });


        signUp.setText(bundle.getString("Sign Up"));
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1;
                JLabel nameLabel = new JLabel(bundle.getString("Username:"));
                JLabel passwordLabel = new JLabel(bundle.getString("Password:"));
                JTextField nameTextField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                JButton register = new JButton(bundle.getString("Register"));

                frame1 = new JFrame();
                frame1.setTitle(bundle.getString("Registration"));
                frame1.setBounds(40, 40, 380, 300);
                frame1.getContentPane().setBackground(Color.pink.darker());
                frame1.getContentPane().setLayout(null);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setResizable(false);

                Toolkit t = Toolkit.getDefaultToolkit();
                Dimension d = t.getScreenSize();
                int x = (d.width - frame1.getWidth()) / 2;
                int y = (d.height - frame1.getHeight()) / 2;
                frame1.setLocation(x, y);

                //Set Image Icon
                ImageIcon icon = new ImageIcon();
                try {
                    frame1.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
                } catch (IOException ex) {
                    System.out.println("When reading icon file: " + ex.getMessage());
                }

                nameLabel.setBounds(40, 20, 80, 70);
                passwordLabel.setBounds(40, 70, 100, 70);
                nameTextField.setBounds(180, 43, 165, 23);
                passwordField.setBounds(180, 93, 165, 23);
                register.setBounds(220, 150, 100, 35);

                frame1.add(nameLabel);
                frame1.add(passwordLabel);
                frame1.add(nameTextField);
                frame1.add(passwordField);
                frame1.add(register);

                register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        PrintWriter login = null;
                        try {
                            login = new PrintWriter(new FileWriter("login.txt", true));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String username = nameTextField.getText();
                        String password = passwordField.getText();
                        login.write(username + "," + password);
                        login.println();
                        login.close();
                        File file = new File(username + "score.txt");
                        try {
                            FileWriter myWriter = new FileWriter(file);
                            myWriter.write("0");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        frame1.dispose();
                        new SecondWindow();
                    }
                });

            }
        });

        anon.setText(bundle.getString("Anonymous"));
        anon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondWindow();
            }

        });


        draw.add(signIn);
        draw.add(signUp);
        draw.add(anon);
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        panel.add(signIn);
        panel.add(signUp);
        panel.add(anon);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setSize(600, 500);
        frame.setResizable(false);

        //Center View
        Toolkit t1 = Toolkit.getDefaultToolkit();
        Dimension d1 = t1.getScreenSize();
        int x1 = (d1.width - frame.getWidth()) / 2;
        int y1 = (d1.height - frame.getHeight()) / 2;
        frame.setLocation(x1, y1);

        //Set Image Icon
        new ImageIcon();
        try {
            frame.setIconImage(ImageIO.read(new File("src/sample/512x512bb.jpg")));
        } catch (IOException ex) {
            System.out.println("When reading icon file: " + ex.getMessage());
        }

        //Set Audio to help concentration.
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("Chopin - Spring Waltz.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

        frame.setVisible(true);
    }


    public static class MyDrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Image image = new ImageIcon("src/sample/512x512bb.jpg").getImage();
            g.drawImage(image, 90, 10, 400, 400, this);
        }


        public static void main(String[] args) {
            new Welcome();
        }
    }
}