package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    static Scanner x;

    public Login(String username, String password, String filepath){
        boolean found= false;
        String tempUsername= "";
        String tempPassword= "";


        try{
            x= new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found){
                tempUsername=x.next();
                tempPassword=x.next();

                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found= true;
                }

            }
            x.close();
            System.out.println(found);
            new SecondWindow();
        }
        catch (Exception e){
            System.out.println("Error");
        }
        File file = new File(username+"score.txt");
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("0");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}