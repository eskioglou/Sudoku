package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoadGame {

    private int[][] unsolvedSudoku;
    private int[][] solvedSudoku;
    public LoadGame (int dimensions){
        unsolvedSudoku = new int[dimensions+1][dimensions+1];
        solvedSudoku = new int[dimensions+1][dimensions+1];
        ReadFile();
    }


    public int[][] getSolvedSudoku() {
        return solvedSudoku;
    }

    public int[][] getUnsolvedSudoku() {
        return unsolvedSudoku;
    }

    File selectFile(){
        System.out.println("Please confirm your username: ");
        Scanner x= new Scanner(System.in);
        String username=x.next();
        String pathname= username+".txt";
        File file= new File(pathname);
        return file;
    }

    private void ReadFile(){
        Scanner fileScanner = null;
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            File file = selectFile();
            fileScanner = new Scanner(file);
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
        int l=0;
        for(int i=1; i<solvedSudoku.length; i++){
            for(int j=1; j<solvedSudoku.length; j++) {
                solvedSudoku[i][j] = numbers.get(l);
                l++;
            }
        }

    }
}