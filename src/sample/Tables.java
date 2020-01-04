package sample;


import java.io.File;


public class Tables {
    public int dimension;
    int[] matrix[];
    File file;


    Tables(int dimension){
        matrix = new int[dimension][dimension];
        this.dimension = dimension;
    }

    public int getDimension(){
        return dimension;
    }
    public File getFile(){ return file;}


    int getCell(int i, int j){
        return matrix[i][j];
    }

    boolean setCell(int i, int j, int value){
        matrix[i][j] = value;
        return true;
    }

    boolean existsColumn(int numi, int numj, int value) {
        for (int row = 0; row < dimension; row++) {
            if(row!=numi) {
                if (value == matrix[row][numj]) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsRow(int numi, int numj, int value) {
        for (int col = 0; col < dimension; col++) {
            if (col != numj) {
                if (matrix[numi][col] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean existsGrid(int numi, int numj, int value){
        int w = (int) (numi% Math.sqrt(dimension));


        boolean flag = false;
        if(w==0){
            for(int i=numi; i<=numi+Math.sqrt(dimension)-1; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        else if(w==1){
            for(int i=numi-1; i<=numi+Math.sqrt(dimension)-2; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        else{
            for(int i=numi-2; i<=numi; i++){
                flag = insideLoop(i, numj, value, flag);
            }
        }
        return flag;
    }

    boolean insideLoop(int i, int numj, int value, boolean flag){
        int z = (int) (numj% Math.sqrt(dimension));
        if(z==0){
            for(int j=numj; j<=numj+Math.sqrt(dimension)-1; j++){
               // System.out.println(" x and y " + i + j);
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        else if(z==1){
            for(int j=numj-1; j<=numj+Math.sqrt(dimension)-2; j++){
               // System.out.println(" x and y " + i + j);
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        else{
            for(int j=numj-2; j<=numj; j++){
                //System.out.println(" x and y " + i + j);
                if(value==matrix[i][j]){
                    flag = true;
                }
            }
        }
        return flag;
    }

}
