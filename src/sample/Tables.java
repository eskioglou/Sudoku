package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Tables {
    public int dimension;
    int[] matrix[];
    int[] matrix2[];



    Tables(int dimension){
        matrix = new int[dimension][dimension];
        matrix2 = new int[dimension][dimension];
        this.dimension = dimension;
    }

    public int getDimension(){
        return dimension;
    }

    void createMatrix(){
        File file;
        file = new File("C:\\Users\\USER\\IdeaProjects\\sudoku-3237_311612\\src\\sample\\sudoku");
        //Creating the directory
        boolean bool = file.mkdir();

        File[] s = file.listFiles();
        Random rand = new Random();
        File file1 = s[rand.nextInt(s.length)];

        try{
            Scanner sc = new Scanner(file1);
            for(int i= 0; i<dimension; i++){
                for(int j= 0; j<dimension; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
    void displayMatrix(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
    void solutionMatrix(){
        File file = new File("C:\\Users\\USER\\Desktop\\here\\src\\sample\\s1.txt");
        try{
            Scanner sc = new Scanner(file);
            for(int i=0; i<=dimension; i++){            //it must equal the dimension so that it can read the extra line of the file
                sc.nextLine();
            }
            for(int i= 0; i<dimension; i++){
                for(int j= 0; j<dimension; j++){
                    matrix2[i][j] = sc.nextInt();
                }
            }
            sc.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    void displaySolution(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                System.out.print(matrix2[i][j] +" ");
            }
            System.out.println(" ");
        }
    }

    int getCell(int i, int j){
        return matrix[i][j];
    }

    boolean setCell(int i, int j, int value){
        matrix[i][j] = value;
        return true;
    }

    boolean existsColumn(int numi, int numj, int value) {
        for (int row = 0; row < dimension; row++) {
            if(row!=numi) {
                if (value == matrix[row][numj]) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsRow(int numi, int numj, int value) {
        for (int col = 0; col < dimension; col++) {
            if (col != numj) {
                if (matrix[numi][col] == value) {
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
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        else if(z==1){
            for(int j=numj-1; j<=numj+Math.sqrt(dimension)-2; j++){
               // System.out.println(" x and y " + i + j);
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        else{
            for(int j=numj-2; j<=numj; j++){
                //System.out.println(" x and y " + i + j);
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
