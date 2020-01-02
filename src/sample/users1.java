package sample;


import java.util.Scanner;

public class users1 {

    private String username;
    private String password;
    private String[][] accounts = {{"anthony", "supernova"}, {"steve", "java1"}};

    public users1(String username, String password) {
        this.username = username;
        this.password = password;
        boolean active;
    }

    public boolean checkPassword() {

        if ((username.equals(accounts[0][0])) && (password.equals(accounts[0][0])))
            return true;
        else
            return false;
    }

    public void deactivateAccount() {
        boolean active = false;
    }


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        String username;
        String password;


        System.out.println("Welcome to your Social network site!");
        System.out.println("\nEnter your username and password to login to your account.");

        System.out.println("Username: ");
        username = input.nextLine();

        System.out.println("Password: ");
        password = input.nextLine();

        users1 login = new users1(username, password);

        if(login.checkPassword())
            System.out.println("You are logged in!");
        else
            System.out.println("The username and password you entered are incorrect.");


}

}