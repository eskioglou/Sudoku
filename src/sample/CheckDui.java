package sample;

import javax.swing.*;
import java.util.Random;

public class CheckDui extends Check{
    private int numi;
    private int numj;
    private int numi2;
    private int numj2;
    private int val;


    public CheckDui(JTextField[][] Tf, int dimension) {
        super(Tf, dimension);
        changeInt();
    }

    void movePC(){
        boolean acpt= true;
        int v;
        do {
            Random ran = new Random();
            do {
                numi = ran.nextInt(4);
                numj = ran.nextInt(4);
            }while (play[numi][numj] != 0);
            System.out.println("outside " +numi +", " +numj);
            v = 1 + ran.nextInt(4);
            acpt = super.accept(numi+1, numj+1, v);
            if(acpt){
                System.out.println("accepted " +numi +", " +numj);
                numi2 = numi;
                numj2 = numj;
                val = v;
            }

        }while(!acpt);
        return;
    }
    int getNumi(){
        return numi2;
    }
    int getNumj(){
        return numj2;
    }
    int getVal(){
        return val;
    }

    public boolean makeInactive(int i, int j){
        boolean flag = false;
        if(isDuidokuEmpty(i, j)){
            flag = true;
            for(int num = 1; num<=4; num++){
                if(super.accept(i+1, j+1, num)){
                    flag = false;
                }
            }
            if(flag){
                numi2 = i;
                numj2 = j;
                val = 9;
            }
        }
        return flag;
    }

    private boolean isDuidokuEmpty(int i, int j){
        int cell = play[i][j];
        return cell == 0;
    }

}
