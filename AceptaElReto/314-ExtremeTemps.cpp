#include <bits/stdc++.h>

using namespace std;

int main(){

    int cases, temps, v1, v2, v3;
    cin >> cases;

    while (cases--){

        int picos = 0;
        int valles = 0;

        cin >> temps;

        if (temps < 3) {
            cout << "0 0" << endl;
            while (temps--) cin >> v1;
            continue;
        }

        cin >> v1 >> v2;
        temps-=2;

        while (temps > 0) {

            cin >> v3;

            // cout << "Test with " << v1 << " " << v2 << " " << v3 << endl;

            if (v2 < v1 && v2 < v3){ valles++; }
            else if (v2 > v1 && v2 > v3){ picos++; }

            v1 = v2;
            v2 = v3;

            temps--;

        }

        cout << picos << " " << valles << endl;

    }

    return 0;
}