package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 *This class chooses a Killer Sudoku file and creates the unsolved and solved Killer tables according to that file
 *There are 10 new Sudoku game files, that are in a separate folder, out of the sample package
 *
 * @author Paschalina lyssoudi
 */
public class KillerReader {
    private int[][] unsolvedKiller;
    private int[][] solvedKiller;
    private int[] sums;
    /**
     * The Constructor of the class
     * Initializes the unsolved and solved Killer Sudoku matrices
     * Initializes a matrix with the team sums that the team cells must equal to if added
     * @param dimensions the dimension of the unsolved and solved matrices
     */
    public KillerReader(int dimensions){
        unsolvedKiller = new int[dimensions+1][dimensions+1];
        solvedKiller = new int[dimensions+1][dimensions+1];
        sums = new int[45];
        for (int i = 0; i<45; i++){
            sums[i] = 0;
        }
        ReadFile();
    }
    /**
     * Getter for the solved Killer Sudoku matrix
     * @return a matrix with the values of the solved Killer Sudoku
     */
    public int[][] getSolvedKiller() { return solvedKiller; }
    /**
     * Getter for the unsolved Killer Sudoku matrix
     * @return a matrix with the values of the unsolved Killer Sudoku
     */
    public int[][] getUnsolvedKiller() { return unsolvedKiller; }
    /**
     * Getter for the sum the given group must equal to
     * @param group the number of the group whose sum is needed
     * @return the number of the sum of the group
     */
    public int getSum(int group){
        return sums[group];
    }
    /**
     * Turns the folder killer into a directory
     * The folder contains 10 files with Killer Sudoku games and their solutions
     * It randomly chooses a file from the directory
     * @return the file containing the new Killer Sudoku game
     */
    File selectFile(){
        File file;
        file= new File("killer");
        file.mkdir();
        File[] s= file.listFiles();
        Random rand= new Random();
        assert s!=null;
        File file1;
        file1 = s[rand.nextInt(s.length -1)];
        return file1;
    }
    /**
     * Creates two matrixes, one for the unsolved and one for the solved Killer Sudoku, using the information from the file
     * First it creates the unsolved matrix by adding the first number to the sums array, and then recognising the cells that belong to a certain group
     * Then created the solved matrix
     */
    private void ReadFile(){
        Scanner fileScanner = null;
        try {
            File file = selectFile();
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileScanner != null;
        int group = 0;
        while (fileScanner.hasNextLine()) {
            String str = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(str);
            lineScanner.useDelimiter("[,\n]");
            int t = lineScanner.nextInt();
            if(t != 100) {
                String num ;
                sums[group] = t;
                while (lineScanner.hasNext()) {
                    num = lineScanner.next();
                    int i = Integer.parseInt(num);
                    num = lineScanner.next();
                    int j = Integer.parseInt(num);
                    unsolvedKiller[i][j] = group;
                }
                group++;
            }else{
                for(int a=0; a<9; a++){
                    String str2 = fileScanner.nextLine();
                    Scanner lineScanner2 = new Scanner(str2);
                    lineScanner2.useDelimiter("[,\n]");

                    for(int b=0; b<9; b++) {
                        int num = lineScanner2.nextInt();

                        solvedKiller[a][b] = num;
                    }
                }
                break;
            }
        }
    }
}
