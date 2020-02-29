#include <bits/stdc++.h>

using namespace std;

int main(){

    long long cases, num;
    cin >> cases;

    while (cases--){

        cin >> num;

        if (num % 3 == 0 || num % 3 == 2){
            cout << "SI" << endl;
        } else {
            cout << "NO" << endl;
        }

    }

    return 0;
}