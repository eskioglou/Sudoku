package sample;

import javax.swing.*;
import java.util.concurrent.ThreadFactory;

public class WordokuChanges {
    JTextField[][] wtf;
    JTextField[][] Tf;
    int dimension;
    public WordokuChanges(int dimension, JTextField[][] Tf){
        this.dimension = dimension;
        wtf = new JTextField[dimension][dimension];
        Tf= new JTextField[dimension][dimension];
        this.Tf = Tf;
;    }

    void change1toA(int i, int j){
        if(Tf[i][j].getText() == "1"){
            wtf[i][j].setText("A");
        }
        if(Tf[i][j].getText() == "2"){
            wtf[i][j].setText("B");
        }
        if(Tf[i][j].getText() == "3"){
            wtf[i][j].setText("C");
        }
        if(Tf[i][j].getText() == "4"){
            wtf[i][j].setText("D");
        }
        if(Tf[i][j].getText() == "5"){
            wtf[i][j].setText("E");
        }
        if(Tf[i][j].getText() == "6"){
            wtf[i][j].setText("F");
        }
        if(Tf[i][j].getText() == "7"){
            wtf[i][j].setText("G");
        }
        if(Tf[i][j].getText() == "8"){
            wtf[i][j].setText("H");
        }
        if(Tf[i][j].getText() == "9"){
            wtf[i][j].setText("I");
        }
        if(Tf[i][j].getText() == "0"){
            wtf[i][j].setText("X");
        }
    }
    void changeA(){
        for(int i = 0; i<dimension; i++){
            for(int j = 0; j<dimension; j++){
                change1toA(i, j);
            }
        }
    }

    JTextField[][] getNumbers(){
        changeA();
        return wtf;
    }

    void changeAto1(int i, int j){
        if(Tf[i][j].getText() == "A"){
            wtf[i][j].setText("1");
        }
        if(Tf[i][j].getText() == "B"){
            wtf[i][j].setText("2");
        }
        if(Tf[i][j].getText() == "C"){
            wtf[i][j].setText("1");
        }
        if(Tf[i][j].getText() == "D"){
            wtf[i][j].setText("4");
        }
        if(Tf[i][j].getText() == "E"){
            wtf[i][j].setText("5");
        }
        if(Tf[i][j].getText() == "F"){
            wtf[i][j].setText("6");
        }
        if(Tf[i][j].getText() == "G"){
            wtf[i][j].setText("7");
        }
        if(Tf[i][j].getText() == "H"){
            wtf[i][j].setText("8");
        }
        if(Tf[i][j].getText() == "I"){
            wtf[i][j].setText("9");
        }
        if(Tf[i][j].getText() == "X"){
            wtf[i][j].setText("0");
        }
    }

    void change1(){
        for(int i = 0; i<dimension; i++){
            for(int j = 0; j<dimension; j++){
                changeAto1(i, j);
            }
        }
    }

    JTextField[][] getLetters(){
        change1();
        return wtf;
    }
}
