package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameReader {

    private int[][] unsolvedSudoku;
    private int[][] solvedSudoku;

    public GameReader(int dimensions,File file) throws IOException {
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];
        ReadFile(file);
    }

    public GameReader(int dimensions) throws FileNotFoundException {
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];

        ReadFile(selectFile());
    }

    public GameReader(int dimensions,File file,int number) throws FileNotFoundException {
        int random=0;
        number=random;
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];

        ReadFile1(file);
    }
    public int[][] getSolvedSudoku() {
        return solvedSudoku;
    }

    public int[][] getUnsolvedSudoku() {
        return unsolvedSudoku;
    }

    File selectFile(){
        File file;
        file= new File("C:\\Users\\Anastasia Kara\\Desktop\\sudoku-3237_3116v12\\src\\sample\\sudoku");
        file.mkdir();
        File[] s= file.listFiles();
        Random rand= new Random();
        assert s!=null;
        File file1;
        file1 = s[rand.nextInt(s.length -1)];
        return file1;
    }


    private void ReadFile(File file) throws FileNotFoundException {
        Scanner fileScanner = null;
        ArrayList<Integer> numbers = new ArrayList<>();
        fileScanner = new Scanner(file);

        assert fileScanner != null;
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
    private void ReadFile1(File file) throws FileNotFoundException {
        Scanner fileScanner = null;
        ArrayList<Integer> numbers = new ArrayList<>();
        fileScanner = new Scanner(file);

        assert fileScanner != null;
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
