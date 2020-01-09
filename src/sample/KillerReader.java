package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KillerReader {
    private int[][] unsolvedKiller;
    private int[][] solvedKiller;
    int dimension;
    int team = 1;

    public KillerReader(int dimensions){
        unsolvedKiller = new int[dimensions+1][dimensions+1];
        solvedKiller = new int[dimensions+1][dimensions+1];
        this.dimension = dimensions;

        ReadFile();
    }

    public int[][] getSolvedKiller() {
        return solvedKiller;
    }

    public int[][] getUnsolvedKiller() {
        return unsolvedKiller;
    }

    File selectFile(){
        File file;
        file= new File("C:\\Users\\USER\\Desktop\\sudoku-3237_3116\\src\\sample\\killer\\k1.txt");
        return file;
    }



    private void ReadFile(){
        Scanner fileScanner = null;
        ArrayList<Character> numbers = new ArrayList<>();
        try {
            File file = selectFile();
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileScanner != null;

        while (fileScanner.hasNextLine()) {
            String str = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(str);
            lineScanner.useDelimiter("[,\n]");
            int t = lineScanner.nextInt();

            if(t != 100) {
                //char sum = t.charAt(0);
                while (lineScanner.hasNext()) {
                    String num = lineScanner.next();
                    int i = Integer.parseInt(num);
                    num = lineScanner.next();
                    int j = Integer.parseInt(num);
                    int te = team;
                    unsolvedKiller[i][j] = (char)te;
                }
                team++;
            }else{


                for(int a=0; a<dimension; a++){
                    String str2 = fileScanner.nextLine();
                    Scanner lineScanner2 = new Scanner(str2);
                    lineScanner2.useDelimiter("[,\n]");

                    for(int b=0; b<dimension; b++) {
                        int num = lineScanner2.nextInt();

                        solvedKiller[a][b] = num;
                    }

                }
                for(int i=0; i<9; i++){
                    System.out.println(" ");
                    for(int j = 0; j<9; j++){
                        System.out.print(solvedKiller[i][j]+ " ");
                    }
                }
                break;}

        }


    }
}
