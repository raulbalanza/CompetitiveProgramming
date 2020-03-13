#include <bits/stdc++.h>

using namespace std;

int main(){

    int n, val, prev;

    while (cin >> n){

        if (n == 1){
            cin >> prev;
            cout << "Jolly" << endl;
            continue;
        }

        set<int> difs;
        cin >> prev;

        for (int i=1; i<n; i++){
            cin >> val;
            int cur = abs(val-prev);
            if (cur < n) difs.insert(cur);
            prev = val;
        }

        if (difs.size() == n-1) cout << "Jolly" << endl;
        else cout << "Not jolly" << endl;

    }    

    return 0;
}