package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

    class Confirmation extends JFrame  {
        static JTextField textfield;
        static JFrame f;
        static JButton button;
        static JLabel label;

        //---------------LANGUAGE ADDITION------------------------
        Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
        ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

        Confirmation(){
            f = new JFrame(bundle.getString("Confirmation"));
            label = new JLabel(bundle.getString("Please confirm your username:"));
            button = new JButton(bundle.getString("Submit"));
            textfield = new JTextField(16);
            JPanel panel = new JPanel();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String username=textfield.getText();
                    PrintWriter writer = null;
                    try {
                        writer = new PrintWriter("confirmation.txt");
                        writer.println(username);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    writer.close();
                    File file = new File("confirmation.txt");
                    Scanner sc = null;
                    try {
                        sc = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    while (sc.hasNextLine()) {
                        String username1=sc.nextLine();
                    }
                }
            });

            panel.add(label);
            panel.add(textfield);
            panel.add(button);

            f.add(panel);
            f.setSize(300, 100);
            f.show();}

        String getUsername() throws IOException {
            File file = new File("confirmation.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String username1 = null;
            while (sc.hasNextLine()) {
                username1 = sc.nextLine();
            }
            return username1;
        }
    }