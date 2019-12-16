package sample;

public class Duidoku extends Tables{
    public int numi;
    public int numj;



    public Duidoku(){
        super(4);
    }

    public void createDuidoku(){
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                matrix[i][j] = 0;
            }
        }
    }



}
