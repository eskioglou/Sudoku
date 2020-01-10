package sample;

import javax.swing.*;
import java.util.Random;
/**
 * This class performs the extra checks needed in Duidoku game
 * The class extends to class Check and uses its methods
 * @author Paschalina lyssoudi
 */
public class CheckDui extends Check{
    private int numi2;
    private int numj2;
    private int val;
    /**
     * The class's Constructor
     * Creates object super from Ckeck
     * Passes the dimension of the Sudoku version that asks for check to the class
     * @param Tf the JTextField matrix from the game
     * @param dimension the dimension of the type JTextField matrices
     */
    public CheckDui(JTextField[][] Tf, int dimension) {
        super(Tf, dimension);
        changeInt();
    }
    /**
     * Performs the Computer's move after the player's move is completed
     * Selects a random row and column, and if they are changeable, selects an acceptable value and places it
     */
    void movePC(){
        boolean acpt;
        int v;
        do {
            Random ran = new Random();
            int numj;
            int numi;
            do {
                numi = ran.nextInt(4);
                numj = ran.nextInt(4);
            }while (play[numi][numj] != 0);
            System.out.println("outside " + numi +", " + numj);
            v = 1 + ran.nextInt(4);
            acpt = super.accept(numi +1, numj +1, v);
            if(acpt){
                System.out.println("accepted " + numi +", " + numj);
                numi2 = numi;
                numj2 = numj;
                val = v;
            }

        }while(!acpt);
    }
    /**
     * Returns number of row chosen by the computer
     * @return the row number
     */
    int getNumi(){
        return numi2;
    }
    /**
     * Returns number of column chosen by the computer
     * @return the column number
     */
    int getNumj(){
        return numj2;
    }
    /**
     * Returns value chosen by the computer
     * @return the value
     */
    int getVal(){
        return val;
    }
    /**
     * Called after a move
     * Checks if the cell with row number i and column number j is empty, an if it is checks if any values are acceptable
     * @param i row number of the cell
     * @param j column number of the cell
     * @return true if the there are not acceptable values, false if there is at least one
     */
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
    /**
     * Checks if the cell is empty
     * A cell is empty if it has value 0
     * @param i row number of cell
     * @param j column number of cell
     * @return the row number
     */
    private boolean isDuidokuEmpty(int i, int j){
        int cell = play[i][j];
        return cell == 0;
    }

}
