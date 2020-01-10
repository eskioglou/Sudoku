package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *This class chooses a Sudoku file and creates the unsolved and solved Sudoku tables according to that file
 *There are 10 new Sudoku game files, that are in a separate folder, out of the sample package
 *
 * @author Paschalina lyssoudi
 * @author Maria Eskioglou
 */
public class SudokuReader {

    private int[][] unsolvedSudoku;
    private int[][] solvedSudoku;
    /**
     * First Constructor
     * Is used to load a specific game file
     * The previous game is saved in a file, which is given to the Constructor as a parameter
     * @param dimensions the dimension of the matrix to me made
     * @param file the file containing the previous game to be loaded
     */
    public SudokuReader(int dimensions,File file) throws IOException {
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];
        ReadFile(file);
    }
    /**
     * Second Constructor
     * Is used to create a new game
     * Gets the file to be loaded from method selectFile
     * @param dimensions the dimension of the matrix to me made
     */
    public SudokuReader(int dimensions) throws FileNotFoundException {
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];

        ReadFile(selectFile());
    }
    /**
     * Third Constructor
     * Is used to load previously played games from a user
     * The previous game is saved in a file, which is given to the Constructor as a parameter
     * This file has different structure, so it is handled by method ReadFile1
     * @param dimensions the dimension of the matrix to me made
     * @param file the file containing the previous game to be loaded
     * @param number a number with no actual use, given only to create object using this Constructor
     */
    public SudokuReader(int dimensions,File file,int number) throws FileNotFoundException {
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];

        ReadFile1(file);
    }
    /**
     * Getter for the solved Sudoku matrix
     * @return a matrix with the values of the solved Sudoku
     */
    public int[][] getSolvedSudoku() {
        return solvedSudoku;
    }
    /**
     * Getter for the unsolved Sudoku matrix
     * @return a matrix with the values of the unsolved Sudoku
     */
    public int[][] getUnsolvedSudoku() {
        return unsolvedSudoku;
    }
    /**
     * Turns the folder sudoku into a directory
     * The folder contains 10 files with Sudoku games and their solutions
     * It randomly chooses a file from the directory
     * @return the file containing the new Sudoku game
     */
    File selectFile(){
        File file;
        file= new File("sudoku");
        file.mkdir();
        File[] s= file.listFiles();
        Random rand= new Random();
        assert s!=null;
        File file1;
        file1 = s[rand.nextInt(s.length -1)];
        return file1;
    }
    /**
     * Creates two matrixes, one for the unsolved and one for the solved Sudoku, using the information from the file
     * First it reads the numbers for the unsolved, and afterwards for the solved game
     * @param file the file it scans to get the information for the matrices
     */
    private void ReadFile(File file) throws FileNotFoundException {
        Scanner fileScanner;
        ArrayList<Integer> numbers = new ArrayList<>();
        fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            while (lineScanner.hasNext()) {
                String num = lineScanner.next();
                int number = Integer.parseInt(num);
                numbers.add(number);
            }
        }
        int k = 0;
        for (int i = 1; i < unsolvedSudoku.length; i++) {
            for (int j = 1; j < unsolvedSudoku.length; j++) {
                unsolvedSudoku[i][j] = numbers.get(k);
                k++;
            }
        }

        for (int i = 1; i < solvedSudoku.length; i++) {
            for (int j = 1; j < solvedSudoku.length; j++) {
                solvedSudoku[i][j] = numbers.get(k);
                k++;
            }
        }
    }
    /**
     * Creates two matrixes, one for the unsolved and one for the solved Dudoku, using the information from the file
     * The file has different structure, because ita comes from the saved games already played to some point by a certain user
     * @param file the file it scans to get the information for the matrices
     */
    private void ReadFile1(File file) throws FileNotFoundException {
        Scanner fileScanner;
        ArrayList<Integer> numbers = new ArrayList<>();
        fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            while (lineScanner.hasNext()) {
                String num = lineScanner.next();
                int number = Integer.parseInt(num);
                numbers.add(number);
            }
        }
        int k = 0;
        for (int i = 1; i < unsolvedSudoku.length; i++) {
            for (int j = 1; j < unsolvedSudoku.length; j++) {
                unsolvedSudoku[i][j] = numbers.get(k);
                k++;
            }
        }
    }
}
