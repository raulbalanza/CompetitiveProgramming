#include <bits/stdc++.h>

using namespace std;

int main(int argc, char* argv[]){

    while (true){

        int equipos, globos;
        cin >> equipos >> globos;
        
        if (equipos == 0 && globos == 0) break;

        int res[equipos];

        for (int i = 0; i<equipos; i++){
            res[i] = 0;
        }

        for (int i=0; i<globos; i++){
        
            int cur;
            cin >> cur;
            res[cur-1] += 1;

            // cout << "Equipo " << cur << " tiene " << res[cur] << endl; 

            string t;
            cin >> t;

        }

        int pos = 0;
        int max = res[0];

        bool found = false;

        for (int i=1; i<equipos; i++){

            if (res[i] > max){
                max = res[i];
                pos = i;
            }

        }

        for(int i=pos+1; i<equipos && !found; i++){

            if (res[i] == max) {
                found = true;
            }

        }

        if (!found) cout << (pos+1) << endl;
        else cout << "EMPATE" << endl;

    }

    return 0;
}