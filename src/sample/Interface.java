package sample;

import java.util.Random;
import java.util.Scanner;

public class Interface {
    int numi;
    int numj;
    int value;
    Tables tab = new Tables(9);
    Duidoku dui = new Duidoku();

    void start(){
        //sample.Welcome n=new sample.Welcome();

        int ver = chooseVersion();
        if (ver == 1){
            playSudoku();
        }
        else if(ver == 2){


        }
        else{
            playDuidoku();
        }
    }
    int chooseVersion(){
        System.out.println("Choose a version");
        Scanner vers = new Scanner(System.in);
        int ver = vers.nextInt();
        return ver;
    }

    void playSudoku(){
        tab.createMatrix();
        //tab.solutionMatrix();
        do{
            tab.displayMatrix();
            getCoords(9);
            if(isSudokuEmpty(numi, numj)){
                checkAccept();
            }
            else{
                System.out.println("Occupied cell");
            }
        }while(!endSudokuGame());
    }
    void checkAccept(){
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
    boolean isSudokuEmpty(int i, int j){
        int cell = tab.getCell(i, j);
        if(cell == 0){
            return true;
        }
        return false;
    }

    boolean endSudokuGame(){
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
            System.out.println("Game finished");
            return true;
        }
        return false;
    }

    void playDuidoku(){
        dui.createDuidoku();
        do{
            dui.displayMatrix();
            getCoords(4);
            if(isDuidokuEmpty(numi, numj)){
                boolean acpt = checkDuidokuAccept( getValue());
                if(acpt){
                    makeInactive();
                    dui.displayMatrix();
                    movePC(acpt);
                }
            }
            else{
                System.out.println("Occupied cell");
            }

        }while(!endDuidokuGame());

    }
    void getCoords(int dimension){
        do {
            System.out.println("Give x coordinate");
            Scanner scanneri = new Scanner(System.in);
            numi = scanneri.nextInt();
        }while(numi<0 || numi>dimension-1);
        do{
            System.out.println("Give y coordinate");
            Scanner scannerj = new Scanner(System.in);
            numj = scannerj.nextInt();
        }while(numj<0 || numj>dimension-1);

    }
    public int getValue(){
        do {
            System.out.println("Give value");
            Scanner v = new Scanner(System.in);
            value = v.nextInt();
        }while(value<1 || value>4);
        return value;
    }
    boolean checkDuidokuAccept(int value){
        if(!dui.existsColumn(numi, numj, value) && !dui.existsRow(numi, numj, value)&& !dui.existsGrid(numi, numj, value)){
            boolean done = dui.setCell(numi, numj, value);
            System.out.println("value set");
            return true;
        }
        else{
            System.out.println("check failed");
            return false;
        }
    }
    public boolean movePC(boolean done){
        if (done){
            boolean acpt;
            do {
                Random ran = new Random();
                do {
                    numi = ran.nextInt(4);
                    numj = ran.nextInt(4);
                }while (dui.getCell(numi, numj) != 0);
                int v = 1 + ran.nextInt(4);
                acpt = checkDuidokuAccept(v);
                if(acpt){
                    makeInactive();
                }
            }while(!acpt);
        }return true;
    }

    public void makeInactive(){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                if(isDuidokuEmpty(i, j)){
                    boolean flag = true;
                    for(int num = 1; num<=4; num++){
                        if(!dui.existsColumn(i, j, num) && !dui.existsRow(i, j, num) && !dui.existsGrid(i, j, num)){
                            flag = false;
                        }
                    }
                    if(flag == true){
                        dui.setCell(i, j, 9);
                    }
                }

            }
        }
    }
    boolean isDuidokuEmpty(int i, int j){
        int cell = dui.getCell(i, j);
        if(cell == 0){
            return true;
        }
        return false;
    }
    boolean endDuidokuGame(){
        int zeros=0;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                int cell = dui.getCell(i, j);
                if(cell == 0){
                    zeros++;
                }
            }
        }
        if(zeros == 0){
            System.out.println("Game finished");
            return true;
        }
        return false;
    }
}
