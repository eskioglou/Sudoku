package sample;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * This class is used in several occasions to confirm the username. It extends the JFrame and contains a button, which takes the text from the
 * Text Field and uses it to store it into the confirmation.txt file.
 * @author  Maria Eskioglou
 */
    class Confirmation extends JFrame  {
        static JTextField textfield;
        static JFrame f;
        static JButton button;
        static JLabel label;
        static String user;

        //---------------LANGUAGE ADDITION------------------------
        Locale loc = new Locale(Locale.getDefault().getDisplayLanguage(), Locale.getDefault().getDisplayCountry());
        ResourceBundle bundle = ResourceBundle.getBundle("Languages", loc);
//--------------------------------------------------------

        Confirmation(){
            f = new JFrame(bundle.getString("Confirmation"));
            label = new JLabel(bundle.getString("Please confirm your username:"));
            button = new JButton(bundle.getString("OK"));
            textfield = new JTextField(16);
            user=textfield.getText();
            JPanel panel = new JPanel();
            button.addActionListener(actionEvent -> {
                String username=textfield.getText();
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("confirmation.txt");
                    writer.println(username);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                assert writer != null;
                writer.close();
                File file = new File("confirmation.txt");
                Scanner sc = null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                assert sc != null;
                while (sc.hasNextLine()) {
                    sc.nextLine();
                }
            });

            panel.add(label);
            panel.add(textfield);
            panel.add(button);

            f.add(panel);
            f.setSize(300, 100);
            f.setVisible(true);}

        /**
         * This method returns the username given from the 'confirmation.txt' and uses it in other occassions when necessary.
         * @return username1
         */


        String getUsername() {
            File file = new File("confirmation.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String username1 = null;
            assert sc != null;
            while (sc.hasNextLine()) {
                username1 = sc.nextLine();
            }
            return username1;
        }


}