package sample;

import java.util.Scanner;

public class Interface {
    int numi;
    int numj;
    int value;
    Tables tab = new Tables();

    public Interface(int numi, int numj){
        this.numi = numi;


    }

    void start(){
        do{
            do {
                System.out.println("Give x coordinate");
                Scanner scanneri = new Scanner(System.in);
                numi = scanneri.nextInt();
            }while(numi<1 || numi>9);
            do{
                System.out.println("Give y coordinate");
                Scanner scannerj = new Scanner(System.in);
                numj = scannerj.nextInt();
            }while(numj<1 || numj>9);
            if(isEmpty(numi, numj)){
                do {
                    System.out.println("Give value");
                    Scanner value = new Scanner(System.in);
                    value.nextInt();
                }while(numi<1 || numi>9);
                tab.setCell(numi, numj, value);
            }
        }while(!endGame());



    }






    boolean endGame(){
        int zeros=0;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                int cell = tab.getCell(i, j);
                if(cell == 0){
                    zeros++;
                }
            }
        }
        if(zeros == 0){
            return true;
        }
        return false;
    }

    boolean isEmpty(int i, int j){
        int cell = tab.getCell(i, j);
        if(cell == 0){
            return true;
        }
        return false;
    }







}
