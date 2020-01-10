package sample;

import javax.swing.*;
import java.util.concurrent.ThreadFactory;
/**
 * Used in button Wordoku tp change letters
 * author Paschalina Lyssoudi
 */
public class WordokuChanges {
    JTextField[][] wtf;
    JTextField[][] Tf;
    int dimension;
    public WordokuChanges(int dimension, JTextField[][] Tf1){
        this.dimension = dimension;
        wtf = new JTextField[dimension][dimension];
        Tf= new JTextField[dimension][dimension];
        Tf = Tf1;
        wtf = Tf1;
        ;    }

    void change1toA(int i, int j){
        if(Tf[i][j].getText().equals("1")){
            Tf[i][j].setText("A");
        }
        if(Tf[i][j].getText().equals("2")){
            Tf[i][j].setText("B");
        }
        if(Tf[i][j].getText().equals("3")){
            Tf[i][j].setText("C");
        }
        if(Tf[i][j].getText().equals("4")){
            Tf[i][j].setText("D");
        }
        if(Tf[i][j].getText().equals("5")){
            Tf[i][j].setText("E");
        }
        if(Tf[i][j].getText().equals("6")){
            Tf[i][j].setText("F");
        }
        if(Tf[i][j].getText().equals("7")){
            Tf[i][j].setText("G");
        }
        if(Tf[i][j].getText().equals("8")){
            Tf[i][j].setText("H");
        }
        if(Tf[i][j].getText().equals("9")){
            Tf[i][j].setText("I");
        }
        if(Tf[i][j].getText().equals("0")){
            Tf[i][j].setText("X");
        }

    }
    void changeA(){
        for(int i = 1; i<=dimension; i++){
            for(int j = 1; j<=dimension; j++){
                change1toA(i, j);
            }
        }
    }

    JTextField getNumbers(int i, int j){
        changeA();
        return Tf[i][j];
    }

    void changeAto1(int i, int j){
        if(Tf[i][j].getText().equals("A")){
            Tf[i][j].setText("1");
        }
        if(Tf[i][j].getText().equals("B")){
            Tf[i][j].setText("2");
        }
        if(Tf[i][j].getText().equals("C")){
            Tf[i][j].setText("1");
        }
        if(Tf[i][j].getText().equals("D")){
            Tf[i][j].setText("4");
        }
        if(Tf[i][j].getText().equals("E")){
            Tf[i][j].setText("5");
        }
        if(Tf[i][j].getText().equals("F")){
            Tf[i][j].setText("6");
        }
        if(Tf[i][j].getText().equals("G")){
            Tf[i][j].setText("7");
        }
        if(Tf[i][j].getText().equals("H")){
            Tf[i][j].setText("8");
        }
        if(Tf[i][j].getText().equals("I")){
            Tf[i][j].setText("9");
        }
        if(Tf[i][j].getText().equals("X")){
            Tf[i][j].setText("0");
        }
    }

    void change1(){
        for(int i = 1; i<=dimension; i++){
            for(int j = 1; j<=dimension; j++){
                changeAto1(i, j);
            }
        }
    }

}
