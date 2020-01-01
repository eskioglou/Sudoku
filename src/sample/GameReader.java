package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameReader {

    private int[][] unsolvedSudoku;
    private int[][] solvedSudoku;

    public GameReader(int dimensions, String pathName){
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];
        ReadFile(pathName);
    }

    public int[][] getSolvedSudoku() {
        return solvedSudoku;
    }

    public int[][] getUnsolvedSudoku() {
        return unsolvedSudoku;
    }

    private void ReadFile(String pathName){
        Scanner fileScanner = null;
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            fileScanner = new Scanner(new File("src/sample/sudoku/s1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileScanner != null;
        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            while (lineScanner.hasNext()) {
                String num = lineScanner.next();
                int number = Integer.parseInt(num);
                numbers.add(number);
            }
        }
        int k=0;
        for(int i=1; i<unsolvedSudoku.length; i++){
            for(int j=1; j<unsolvedSudoku.length; j++) {
                unsolvedSudoku[i][j] = numbers.get(k);
                k++;
            }
        }
        for(int i=1; i<solvedSudoku.length; i++){
            for(int j=1; j<solvedSudoku.length; j++) {
                solvedSudoku[i][j] = numbers.get(k);
                k++;
            }
        }
    }

}
