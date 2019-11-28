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
            System.out.println("solution");
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

    boolean existsColumn(int numi, int numj) {
        for (int row = 0; row < 9; row++) {
            if(row!=numi) {
                if (matrix[numi][numj] == matrix[row][numj]) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsRow(int numi, int numj) {
        for (int col = 0; col < 9; col++) {
            if (col != numj) {
                if (matrix[numi][col] == matrix[numi][numj]) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsGrid(int numi, int numj){

        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                for(int pos=0;pos<8;pos++){
                    for(int pos2=pos+1;pos2<9; pos2++){
                        if(matrix2[row+pos%3][col+pos/3]==matrix2[row+pos2%3][col+pos2/3])
                            return false;
                    }
                }
            }
        }
    }

}
