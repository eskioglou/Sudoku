package sample;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("╔═══════════════════════╗" );
        System.out.println("      W E L C O M E     ");
        System.out.println("╚═══════════════════════╝");
        System.out.println("Registration: Press 1");
        System.out.println("Login: Press 2");
        System.out.println("Anonymous: Press 3");
        Scanner scanner1 = new Scanner(System.in);
        int number = scanner1.nextInt();


        //Registration
        if (number == 1) {
            System.out.println("Registration Page");
            PrintWriter pw = new PrintWriter(new FileWriter("login.txt", true));
            Scanner scanner = new Scanner(System.in);
            String text;
            System.out.println("Username: ");
            text = scanner.next();
            pw.write(text + ",");
            System.out.println("Password: ");
            text = scanner.next();
            pw.write(text);
            pw.println();
            pw.close();
            System.out.println("Registration Successful");
            new SecondWindow();
        }

        //Login
        if (number == 2) {
            Scanner scanner2= new Scanner(System.in);
            String filepath="login.txt";
            String username;
            String password;
            System.out.println("Login");
            System.out.println("Username: ");
            username= scanner2.next();
            System.out.println("Password: ");
            password= scanner2.next();
            new Login(username,password,filepath);

        }


        else if (number == 3) {
            System.out.println("You are logged in as Anonymous.");
            new SecondWindow();
        }
    }
}


