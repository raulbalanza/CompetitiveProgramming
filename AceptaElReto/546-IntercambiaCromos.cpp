#include <bits/stdc++.h>

using namespace std;

int main(){

    int casos, nMateo, nAlex, c;
    map<int, int>::iterator it;
    cin >> casos;

    while (casos--){

        map<int, int> mateo, alex;
        cin >> nAlex;

        while (nAlex--){
            cin >> c;
            alex[c]++;
        }

        cin >> nMateo;

        while (nMateo--){
            cin >> c;
            mateo[c]++;
        }

        int repe = 0;
        bool primero = true;

        for (it = alex.begin(); it != alex.end(); it++){
            if (it->second > 1 && mateo[it->first] == 0){
                repe++;
                if (primero){
                    cout << it->first;
                    primero = false;
                } else {
                    cout << " " << it->first;
                }
            }
        }

        if (repe == 0) cout << "Nada que intercambiar";

        cout << endl;
        repe = 0;

        primero = true;

        for (it = mateo.begin(); it != mateo.end(); it++){
            if (it->second > 1 && alex[it->first] == 0){
                repe++;
                if (primero){
                    cout << it->first;
                    primero = false;
                } else {
                    cout << " " << it->first;
                }
            }
        }

        if (repe == 0) cout << "Nada que intercambiar";
        cout << endl;

    }

    return 0;
}