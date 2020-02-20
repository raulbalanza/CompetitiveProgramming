#include <bits/stdc++.h>

using namespace std;

int main() {

    int col, row, a;

    while (cin >> col >> row){

        vector< vector<int> > mat(row);

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                cin >> a;
                mat[i].push_back(a);
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

                    int minV = min(mat[fila+1][columna], mat[fila][columna+1]);
                    mat[fila][columna] = max(minV - mat[fila][columna], 2);

                }

            }

        }

        cout << mat[0][0] << endl;

    }

}