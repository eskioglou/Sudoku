package sample;

import java.util.Scanner;

public class Interface {
    int numi;
    int numj;
    int value;
    Tables tab = new Tables();

    public Interface(){

    }

    void start(){
        tab.createMatrix();
        tab.solutionMatrix();
        do{
            do {
                tab.displayMatrix();
                System.out.println("Give x coordinate");
                Scanner scanneri = new Scanner(System.in);
                numi = scanneri.nextInt();
            }while(numi<0 || numi>8);
            do{
                System.out.println("Give y coordinate");
                Scanner scannerj = new Scanner(System.in);
                numj = scannerj.nextInt();
            }while(numj<0 || numj>8);
            if(isEmpty(numi, numj)){
                do {
                    System.out.println("Give value");
                    Scanner v = new Scanner(System.in);
                    value = v.nextInt();
                }while(value<1 || value>9);
                if(!tab.existsColumn(numi, numj, value) && !tab.existsRow(numi, numj, value)&& !tab.existsGrid(numi, numj, value)){
                    tab.setCell(numi, numj, value);
                    System.out.println("value set");
                }
                else{
                    System.out.println("check failed");
                }

            }
            else{
                System.out.println("Occupied cell");
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
