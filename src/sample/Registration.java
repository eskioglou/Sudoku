package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Registration {
    String text1,text;

    public Registration() throws IOException {
        System.out.println("Registration Page");

        PrintWriter login = new PrintWriter(new FileWriter("login.txt", true));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        text1 = scanner.next();
        login.write(text1 + ",");
        System.out.println("Password: ");
        text = scanner.next();
        login.write(text);
        login.println();
        login.close();
        System.out.println("Registration Successful");
        new SecondWindow();

    }

    public String takeUser() {
        return text1;
    }

}