package sample;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Registration extends JFrame implements ActionListener {
    private JButton submit;
    private JButton reset;
    private JTextField getName;
    private JTextField getUsername;
    private JTextField getEmail;
    private JTextArea tout;
    private JCheckBox terms;
    private JLabel res;
    private JTextArea resadd;

    public Registration(){
        setTitle("Registration Form");
        setSize(800,500);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container g = getContentPane();
        g.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Registration Form");
        label.setSize(300,30);
        label.setFont(new Font("Calibri",Font.ITALIC , 30));
        label.setLocation(180,30);
        g.add(label);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Calibri", Font.ITALIC, 20));
        name.setSize(100, 20);
        name.setLocation(100,100);
        g.add(name);

        getName= new JTextField();
        getName.setFont(new Font("Calibri", Font.ITALIC, 20));
        getName.setSize(190,  20);
        getName.setLocation(200,100);
        g.add(getName);

        JLabel username = new JLabel("Username");
        username.setFont(new Font("Calibri", Font.ITALIC, 20));
        username.setSize(100,70);
        username.setLocation(100, 130);
        g.add(username);

        getUsername= new JTextField();
        getUsername.setFont(new Font("Calibri", Font.ITALIC, 20));
        getUsername.setSize(180,  20);
        getUsername.setLocation(200,150);
        g.add(getUsername);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Calibri", Font.ITALIC, 20));
        email.setSize(100,20);
        email.setLocation(100, 210);
        g.add(email);

        getEmail= new JTextField();
        getEmail.setFont(new Font("Calibri", Font.ITALIC, 20));
        getEmail.setSize(200,20);
        getEmail.setLocation(200,200);
        g.add(getEmail);

        terms = new JCheckBox("Accept Terms And Conditions");
        terms.setFont(new Font("Calibri", Font.ITALIC, 15));
        terms.setSize(250,20);
        terms.setLocation(150, 250);
        g.add(terms);

        submit= new JButton();
        submit.setText("Submit");
        submit.setSize(100,20);
        submit.setLocation(150, 280);
        submit.addActionListener(this);
        g.add(submit);

        reset= new JButton();
        reset.setText("Reset");
        reset.setSize(100,20);
        reset.setLocation(270, 280);
        reset.addActionListener(this);
        g.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        g.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        g.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        g.add(resadd);



        setVisible(true);
    }

    public static void main(String[] args) {


        new Registration();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
            if (terms.isSelected()) {
                String data1 = "Name : " + getName.getText() + "\n";
                String data2= "Email : " + getEmail.getText() +"\n";
                String data3 = "Username : " + getUsername.getText();
                tout.setText(data1 + data2 + data3);
                tout.setEditable(false);
                tout.setText("Registration Successfully..");
            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the" + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            getEmail.setText(def);
            getName.setText(def);
            getUsername.setText(def);

    }
}
    private Scanner x;
    private String user_name, password;
    public void openFile()
    {
        try
        {
            x = new Scanner(new File("src/sample/sudoku/s1.txt"));
        }
        catch(Exception e)
        {System.out.println("Couldn't find file"); System.exit(0);}
    }

    public boolean checklog(String username, String password)
    {
        String temp;
        String[] info;

        while(x.hasNext())
        {
            temp = x.nextLine();
            info = temp.split(" ");

            //info[0] = id, info[1] = username, info[2] = password, info[3] = age;
            //Right here that means the username and password is correct
            if(info[1].equals(username) && info[2].equals(password))
            {
                System.out.println("Login Successful");
                return true;
            }
        }
        System.out.println("Login failed wrong id or password");
        return false;
    }

}
