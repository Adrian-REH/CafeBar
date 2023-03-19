package clases;

public class PuntoDos {
    public static void main(String[] args) {

        int[][] arrayInt= new int[2][3];

        for (int i = 0 ;i < arrayInt.length;i++){
            for (int j = 0; j<arrayInt[i].length;j++){
                //Lleno
                arrayInt[i][j]=2*j +1+i*3;
                //Imprimo
                System.out.println("["+i+"]["+j+"]: "+arrayInt[i][j]);
            }
        }


    }
}
