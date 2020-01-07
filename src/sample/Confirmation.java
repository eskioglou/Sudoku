package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class Confirmation extends JFrame  {
    static JTextField textfield;
    static JFrame f;
    static JButton button;
    static JLabel label;
    Confirmation(){

        f = new JFrame("Confirmation");
        label = new JLabel("Please confirm your username: ");
        button = new JButton("submit");
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
            BufferedReader br = new BufferedReader(new FileReader(file));

            String username;
            while ((username = br.readLine()) != null)
                System.out.println(username);
            return username;
        }

        public static void main(String[] args){
        new Confirmation();
        }
}
