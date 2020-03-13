#include <bits/stdc++.h>

using namespace std;

vector<int> n(103);

void precalc(){

    n[0] = 0;

    for (int i = 1; i < 102; i+=2){
        n[i] = n[i-1] + i;
        n[i+1] = n[i];
    }

}

int main(){

    precalc();

    int cases, n1, n2;
    cin >> cases;

    int count = 1;

    while (cases--){

        cin >> n1 >> n2;
        cout << "Case " << (count++) << ": " << (n[n2]-n[n1-1]) << endl;

    }

    return 0;

}