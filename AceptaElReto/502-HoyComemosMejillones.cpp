#include <bits/stdc++.h>

using namespace std;

int main(){

    int num, mejillon;
    vector<int> montones;

    while(cin >> num){

        montones.clear();

        for (int i=0; i<num; i++){
            
            cin >> mejillon;

            vector<int>::iterator it = upper_bound(montones.begin(), montones.end(), mejillon);
            if (it != montones.end()) *it = mejillon;
            else montones.push_back(mejillon);

        }

        cout << montones.size() << endl;

    }

    return 0;
}