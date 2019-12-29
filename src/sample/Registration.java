package sample;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Registration extends JFrame implements ActionListener {
    private JButton submit;
    private JButton reset;
    private JLabel label;
    private Container g;
    private JLabel name;
    private JTextField getName;
    private JLabel username;
    private JTextField getUsername;
    private JLabel email;
    private JTextField getEmail;
    private JCheckBox terms;
    private JTextArea area;
    private JButton finish;


    public Registration(){
        setTitle("Registration Form");
        setSize(800,500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        g = getContentPane();
        g.setLayout(null);

        label= new JLabel();
        label.setText("Registration Form");
        label.setSize(300,30);
        label.setFont(new Font("Calibri",Font.ITALIC , 30));
        label.setLocation(180,30);
        g.add(label);

        name= new JLabel("Name");
        name.setFont(new Font("Calibri", Font.ITALIC, 20));
        name.setSize(100, 20);
        name.setLocation(100,100);
        g.add(name);

        getName= new JTextField();
        getName.setFont(new Font("Calibri", Font.ITALIC, 20));
        getName.setSize(190,  20);
        getName.setLocation(200,100);
        g.add(getName);

        username= new JLabel("Username");
        username.setFont(new Font("Calibri", Font.ITALIC, 20));
        username.setSize(100,70);
        username.setLocation(100, 130);
        g.add(username);

        getUsername= new JTextField();
        getUsername.setFont(new Font("Calibri", Font.ITALIC, 20));
        getUsername.setSize(180,  20);
        getUsername.setLocation(200,150);
        g.add(getUsername);

        email= new JLabel("Email");
        email.setFont(new Font("Calibri", Font.ITALIC, 20));
        email.setSize(100,20);
        email.setLocation(100, 210);
        g.add(email);

        getEmail= new JTextField();
        getEmail.setFont(new Font("Calibri", Font.ITALIC, 20));
        getEmail.setSize(200,20);
        getEmail.setLocation(200,200);
        g.add(getEmail);

        terms= new JCheckBox("Accept Terms And Conditions");
        terms.setFont(new Font("Calibri", Font.ITALIC, 15));
        terms.setSize(250,20);
        terms.setLocation(150, 250);
        g.add(terms);

        submit= new JButton();
        submit.setText("Submit");
        submit.setSize(100,20);
        submit.setLocation(150, 280);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        g.add(submit);

        reset= new JButton();
        reset.setText("Reset");
        reset.setSize(100,20);
        reset.setLocation(270, 280);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        g.add(reset);

        area= new JTextArea();
        area.setFont(new Font("Calibri", Font.ITALIC, 15));
        area.setSize(300,200);
        area.setLocation(450,100);
        area.setLineWrap(true);
        area.setEditable(false);
        g.add(area);


        setVisible(true);
    }

    public static void main(String[] args) {
        Registration r = new Registration();
    }

    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getActionCommand().equals("Submit")) {
                area.setVisible(true);
                //concatnating the collected data to be written.
                String toBewrite = getName.getText() + "," + getEmail.getText();
                writeToFile(toBewrite);
                ////
                submit.removeActionListener(this);
                reset.removeActionListener(this);
            }
            if (event.getActionCommand().equals("Clear")) {
                getName.setText("");
                getUsername.setText("");
                getEmail.setText("");
            }
            //Newly added event for Show Records button.
            if (event.getActionCommand().equals("Show Records")) {
                readFile();
            }
        } catch (Exception e) {
        }
    }


    private void writeToFile(String list) throws IOException{
///
        File f = new File("E:\\test1.txt");
        System.out.println(f);
        FileWriter fw = new FileWriter(f,true);
        System.out.println(fw);
        try{
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(bw);
            bw.newLine();
            bw.write(list);
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        ///
    }
    private void readFile(){

        File f = new File("E:\\test1.txt");
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                System.out.println(br.readLine());
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
