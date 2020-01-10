package sample;

import javax.swing.*;
/**
 * This class performs the extra checks needed in Killer Sudoku game
 * The class extends to class Check and uses its methods
 * @author Paschalina lyssoudi
 */
public class CheckKiller extends Check {

    /**
     * The class's Constructor
     * Creates object super from Ckeck
     * Passes the dimension of the Sudoku version that asks for check to the class
     * @param Tf the JTextField matrix from the game
     * @param dimension the dimension of the type JTextField matrices
     */
    public CheckKiller(JTextField[][] Tf, int dimension) {
        super(Tf, dimension);
        init(Tf);
        changeInt();
    }
    /**
     * Checks if the group sum of values is less or equals the needed sum
     * @param team the team that the cell belongs to
     * @param startingKiller a matrix with all the teams of cells
     * @param mustSum the sum the values of the team cells must additionally equal to
     * @return true if sum is acceptable, false if not
     */
    boolean checkSum(int team, int[][] startingKiller, int mustSum){
        int[][] starting = new int[9][9];
        int counter = 0;
        boolean zero = false;
        for(int i = 0; i<9; i++){
            System.arraycopy(startingKiller[i], 0, starting[i], 0, 9);
        }
        int[] group = new int[15];

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(starting[i][j] == team){
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
            return add < mustSum;
        }else{
            return add == mustSum;
        }

    }

}
