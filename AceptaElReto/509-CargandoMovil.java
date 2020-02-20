import java.util.*;

public class CargandoMovil {

    public static int max(int a, int b){ return a > b ? a : b; }
    public static int min(int a, int b){ return a > b ? b : a; }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){

            int col = s.nextInt();
            int row = s.nextInt();

            int [][] mat = new int [row][col];

            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){
                    mat[i][j] = s.nextInt();
                }
            }
            
            for (int fila = row-1; fila >= 0; fila--){

                for (int columna = col-1; columna >= 0; columna--) {
                    
                    if (fila == (row-1) && columna == (col-1)){ // Lugar: esquina inferior derecha, ningún test

                        mat[fila][columna] = 2;

                    } else if (columna == (col-1)){ // Lugar: derecha, test solo abajo
                        
                        mat[fila][columna] = max(mat[fila+1][columna] - mat[fila][columna], 2);

                    } else if (fila == (row-1)){ // Lugar: abajo, test solo derecha
                        
                        mat[fila][columna] = max(mat[fila][columna+1] - mat[fila][columna], 2);

                    } else { // Lugar: centro, test derecha y abajo

                        int min = min(mat[fila+1][columna], mat[fila][columna+1]);
                        mat[fila][columna] = max(min - mat[fila][columna], 2);

                    }

                }

            }

            System.out.println(mat[0][0]);

        }

    }
    
}