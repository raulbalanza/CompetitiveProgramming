#include <bits/stdc++.h>

using namespace std;

int main(){

    int gruposA, gruposB, q, x;
    long long paso, producto;

    while (cin >> gruposA){

        cin >> gruposB;

        vector< pair<int, int> > vectA, vectB;
        vector< pair<int, int> >::iterator itA, itB;

        producto = 0;

        while (gruposA--){
            cin >> q >> x;
            vectA.push_back(make_pair(q, x));
        }

        while (gruposB--){
            cin >> q >> x;
            vectB.push_back(make_pair(q, x));
        }

        itA = vectA.begin();
        itB = vectB.begin();

        while (itA != vectA.end() && itB != vectB.end()){
            paso = min(itA->first, itB->first);
            producto += paso * itA->second * itB->second;
            itA->first-=paso; itB->first-=paso;
            if (itA->first == 0) itA++;
            if (itB->first == 0) itB++;
        }

        cout << producto << endl;

    }

    return 0;
}