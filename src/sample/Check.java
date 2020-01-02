package sample;

import javax.swing.*;

public class Check {
    JTextField[][] matrix;
    private int dimension;
    int[][] play;

    public Check(JTextField[][] Tf, int dimension){
        this.dimension = dimension;
        matrix = new JTextField[Tf.length][Tf.length];
        play = new int[dimension][dimension];
        init(Tf);
        changeInt();
    }
    void init(JTextField[][] Tf){
        for(int i = 1; i<=dimension; i++){
            for(int j = 1; j<=dimension; j++){
                matrix[i][j] = Tf[i][j];
            }
        }
    }
    void changeInt(){
        for(int i = 1; i<=dimension; i++){
            for(int j = 1; j<=dimension; j++){
                String mes = matrix[i][j].getText();
                play[i-1][j-1] = Integer.parseInt(mes);
            }
        }
    }
    // i-1 and j-1 because the coordinates are from the JTextField matrix where we have bounds from 1 to 9, while here we have array from 0 to 8
    boolean accept(int i, int j, int value){
        i-=1;
        j-=1;
        return !existsColumn(i, j, value) && !existsRow(i, j, value) && !existsGrid(i, j, value);
    }

    boolean existsColumn(int numi, int numj, int value) {
        for (int row = 0; row < dimension; row++) {
            if(row!=numi) {
                if (value == play[row][numj]) {
                    System.out.println("1");
                    return true;
                }
            }
        }
        return false;
    }
    boolean existsRow(int numi, int numj, int value) {
        for (int col = 0; col < dimension; col++) {
            if (col != numj) {
                if (play[numi][col] == value) {
                    System.out.println("2");
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsGrid(int numi, int numj, int value){
        int w = (int) (numi% Math.sqrt(dimension));

        boolean flag = false;
        if(w==0){
            for(int i=numi; i<=numi+Math.sqrt(dimension)-1; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        else if(w==1){
            for(int i=numi-1; i<=numi+Math.sqrt(dimension)-2; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        else{
            for(int i=numi-2; i<=numi; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        return flag;
    }

    boolean insideLoop(int i, int numj, int value, boolean flag){
        int z = (int) (numj% Math.sqrt(dimension));
        if(z==0){
            for(int j=numj; j<=numj+Math.sqrt(dimension)-1; j++){
                // System.out.println(" x and y " + i + j);
                if(value==play[i][j]){
                    System.out.println("3");
                    flag = true;
                }
            }
        }
        else if(z==1){
            for(int j=numj-1; j<=numj+Math.sqrt(dimension)-2; j++){
                // System.out.println(" x and y " + i + j);
                if(value==play[i][j]){
                    System.out.println("4");
                    flag = true;
                }
            }
        }
        else{
            for(int j=numj-2; j<=numj; j++){
                //System.out.println(" x and y " + i + j);
                if(value==play[i][j]){
                    System.out.println("5");
                    flag = true;
                }
            }
        }
        return flag;
    }


}
