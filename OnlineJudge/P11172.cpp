#include <bits/stdc++.h>

using namespace std;

int main(){

    int cases, n1, n2;
    cin >> cases;

    while (cases--){

        cin >> n1 >> n2;
        
        if (n1 == n2) cout << "=" << endl;
        else cout << (n1 > n2 ? ">" : "<") << endl;

    }

    return 0;
}