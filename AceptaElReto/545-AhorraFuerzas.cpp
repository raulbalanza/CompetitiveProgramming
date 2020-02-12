#include <bits/stdc++.h>

using namespace std;

int main(){

    int final, coches, minT, tiempo, vel;

    while (cin >> final){

        cin >> coches;

        minT = INT_MAX;

        for (int i=0; i < coches; i++){
            cin >> tiempo >> vel;

            int tarda = ((final/vel) + tiempo);

            if (tiempo >= 0 && tarda < minT){
                minT = tarda;
            }
        }

        cout << minT << endl;

    }

    return 0;
}