package sample;

import javax.swing.*;

public class CheckKiller extends Check {



    public CheckKiller(JTextField[][] Tf, int dimension) {
        super(Tf, dimension);
        init(Tf);
        changeInt();
    }

    boolean checkSum(int team, int[][] startingKiller, int mustSum){
        int[][] starting = new int[9][9];
        int counter = 0;
        int gr = team;
        boolean zero = false;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                starting[i][j] = startingKiller[i][j];
            }
        }
        int[] group = new int[15];

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(starting[i][j] == gr){
                    group[counter] = play[i][j];
                    if(group[counter] == 0){
                        zero = true;
                    }
                    counter++;
                }
            }
        }
        int add = 0;
        for(int i = 0; i<counter; i++){
            add+= group[i];
        }
        System.out.println(add);
        if(zero){
            if(add < mustSum){
                return true;
            }
        }else{
            if(add == mustSum){
                return true;
            }
        }

        return false;
    }

}
