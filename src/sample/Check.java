package sample;

import javax.swing.*;
/**
 * This class performs the basic checks needed in all Sudoku, Killer Sudoku and Duidoku games.
 * @author Paschalina lyssoudi
 */
public class Check {
    JTextField[][] matrix;
    private int dimension;
    int[][] play;

    /**
     * The class's Constructor
     * Initializes the matrices used in the class
     * Passes the dimension of the Sudoku version that asks for check to the class
     * @param Tf the JTextField matrix from the game
     * @param dimension the dimension of the type JTextField matrices
     */
    public Check(JTextField[][] Tf, int dimension){
        this.dimension = dimension;
        matrix = new JTextField[Tf.length][Tf.length];
        play = new int[dimension][dimension];
        init(Tf);
        changeInt();
    }
    /**
     * Copies the type JTextField matrix used in the Sudoku to a type JTextField matrix in this class
     */
    void init(JTextField[][] Tf){
        for(int i = 1; i<=dimension; i++){
            if (dimension >= 0) System.arraycopy(Tf[i], 1, matrix[i], 1, dimension);
        }
    }
    /**
     * Changes the type of the matrix from JTextField to int
     */
    void changeInt(){
        for(int i = 1; i<=dimension; i++){
            for(int j = 1; j<=dimension; j++){
                String mes = matrix[i][j].getText();
                play[i-1][j-1] = Integer.parseInt(mes);
            }
        }
    }
    /**
     * Calls methods existsColumn, existsRow, existsGrid, to check if the value given is acceptable in general
     * @param i row number of cell to be evaluated
     * @param j column number of cell to be evaluated
     * @param value value of cell to be checked for acceptance
     * @return true if value is accepted, false if not
     */
    // i-1 and j-1 because the coordinates are from the JTextField matrix where we have bounds from 1 to 9, while here we have array from 0 to 8
    boolean accept(int i, int j, int value){
        i-=1;
        j-=1;
        return !existsColumn(i, j, value) && !existsRow(i, j, value) && !existsGrid(i, j, value);
    }
    /**
     * Checks if value given already exists in column numj
     * @param numi row number of cell to be evaluated
     * @param numj column number of cell to be evaluated
     * @param value value of cell to be checked for acceptance
     * @return true if value is accepted, false if not
     */
    boolean existsColumn(int numi, int numj, int value) {
        for (int row = 0; row < dimension; row++) {
            if(row!=numi) {
                if (value == play[row][numj]) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Checks if value given already exists in row numi
     * @param numi row number of cell to be evaluated
     * @param numj column number of cell to be evaluated
     * @param value value of cell to be checked for acceptance
     * @return true if value is accepted, false if not
     */
    boolean existsRow(int numi, int numj, int value) {
        for (int col = 0; col < dimension; col++) {
            if (col != numj) {
                if (play[numi][col] == value) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Checks if value given already exists in the smaller grid than the cell belongs to
     * @param numi row number of cell to be evaluated
     * @param numj column number of cell to be evaluated
     * @param value value of cell to be checked for acceptance
     * @return true if value is accepted, false if not
     */
    boolean existsGrid(int numi, int numj, int value){
        int w = (int) (numi% Math.sqrt(dimension));

        boolean flag = false;
        if(w==0){
            for(int i=numi; i<=numi+Math.sqrt(dimension)-1; i++){
                flag = insideLoop(i, numi, numj, value, flag);
            }
        }
        else if(w==1){
            for(int i=numi-1; i<=numi+Math.sqrt(dimension)-2; i++){
                flag = insideLoop(i, numi, numj, value, flag);
            }
        }
        else{
            for(int i=numi-2; i<=numi; i++){
                flag = insideLoop(i, numi, numj, value, flag);
            }
        }
        return flag;
    }
    /**
     * Inside loop for the smaller Grid check, performs the actual check that changes the boolean flag to true, if the value already exists
     * @param i the row that the existsGrid method checks at the moment
     * @param numi row number of cell to be evaluated
     * @param numj column number of cell to be evaluated
     * @param value value of cell to be checked for acceptance
     * @param flag the boolean that changes to true if the value is found
     * @return true if value is accepted, false if not
     */
    boolean insideLoop(int i, int numi, int numj, int value, boolean flag){
        int z = (int) (numj% Math.sqrt(dimension));
        if(z==0){
            for(int j=numj; j<=numj+Math.sqrt(dimension)-1; j++){
                // System.out.println(" x and y " + i + j);
                if(i!=numi || j!=numj){
                    if(value==play[i][j]){
                        flag = true;
                    }
                }
            }
        }
        else if(z==1){
            for(int j=numj-1; j<=numj+Math.sqrt(dimension)-2; j++){
                // System.out.println(" x and y " + i + j);
                if(i!=numi || j!=numj){
                    if(value==play[i][j]){
                        flag = true;
                    }
                }
            }
        }
        else{
            for(int j=numj-2; j<=numj; j++){
                //System.out.println(" x and y " + i + j);
                if(i!=numi || j!=numj){
                    if(value==play[i][j]){
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }


}
