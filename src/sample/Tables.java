package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Tables {
    private int dimension = 9;
    int[] matrix[];
    int[] matrix2[];



    Tables(){
        matrix = new int[dimension][dimension];
        matrix2 = new int[dimension][dimension];
    }


    void createMatrix(){
        File file = new File("C:\\Users\\USER\\Desktop\\Σχολή\\sudoku\\src\\sample\\s1.txt");
        try{
            Scanner sc = new Scanner(file);
            for(int i= 0; i<9; i++){
                for(int j= 0; j<9; j++){
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
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println(" ");
        }
    }
    void solutionMatrix(){
        File file = new File("C:\\Users\\USER\\Desktop\\Σχολή\\sudoku\\src\\sample\\s1.txt");
        try{
            Scanner sc = new Scanner(file);
            for(int i=0; i<10; i++){
                sc.nextLine();
            }
            for(int i= 0; i<9; i++){
                for(int j= 0; j<9; j++){
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
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(matrix2[i][j] +" ");
            }
            System.out.println(" ");
        }
    }

    int getCell(int i, int j){
        return matrix[i][j];
    }

    void setCell(int i, int j, int value){
        matrix[i][j] = value;
    }

    boolean existsColumn(int numi, int numj, int value) {
        for (int row = 0; row < 9; row++) {
            if(row!=numi) {
                if (value == matrix[row][numj]) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsRow(int numi, int numj, int value) {
        for (int col = 0; col < 9; col++) {
            if (col != numj) {
                if (matrix[numi][col] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsGrid(int numi, int numj, int value){

        int w = numi%3;
        int z = numj%3;
        boolean flag = false;
        if(w==0){
            for(int i=w; i<=w+2; i++){
                if(z==0){
                    for(int j=z; j<=z+2; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else if(z==1){
                    for(int j=z-1; j<=z+1; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else{
                    for(int j=z-2; j<=z; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
            }
        }
        else if(w==1){
            for(int i=w-1; i<=w+1; i++){
                if(z==0){
                    for(int j=z; j<=z+2; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else if(z==1){
                    for(int j=z-1; j<=z+1; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else{
                    for(int j=z-2; j<=z; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
            }
        }
        else{
            for(int i=w-2; i<=w; i++){
                if(z==0){
                    for(int j=z; j<=z+2; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else if(z==1){
                    for(int j=z-1; j<=z+1; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
                else{
                    for(int j=z-2; j<=z; j++){
                        if(value==matrix[i][j]){
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

}
