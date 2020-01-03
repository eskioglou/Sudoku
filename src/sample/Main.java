package sample;


import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner s1, s2;
        //int number = 0;
        System.out.println("-----|Welcome|-----");
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
            String text = "";
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
            Scanner x;
            System.out.println("Username: ");
            Scanner scanner2= new Scanner(System.in);
            String n= scanner2.next();
            System.out.println("Password: ");
            Scanner scanner3= new Scanner(System.in);
            String m= scanner3.next();

                boolean found= false;
                String tempUsername= "";
                String tempPassword= "";

                try{
                    x= new Scanner(new File("login.txt"));
                    x.useDelimiter("[,\n]");

                    if (x.hasNext() && !found){
                        tempUsername=x.next();
                        tempPassword=x.next();

                        if(tempUsername.trim().equals(n.trim()) && tempPassword.trim().equals(m.trim())){
                            System.out.println("You are logged in.");
                            new SecondWindow();
                        }
                        else {
                            System.out.println("Invalid user or Wrong Password");
                        }
                    }
                    x.close();
                }
                catch (Exception e){
                    System.out.println("Invalid User or Wrong Password.");
                }
            }


        else if (number == 3) {
            System.out.println("You are logged in as Anonymous.");
            new SecondWindow();
        }
    }
}


