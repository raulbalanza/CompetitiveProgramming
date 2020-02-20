#include <bits/stdc++.h>

using namespace std;

int main(){

    int eventos;

    while (cin >> eventos){

        vector<int> inicio(eventos), fin(eventos);

        while (eventos--){
            cin >> inicio[eventos] >> fin[eventos];
        }

        sort(inicio.begin(), inicio.end());
        sort(fin.begin(), fin.end());

        int n = inicio.size();
        int personas = 0;
        int cur = 0;
        int i = 0;
        int j = 0;
        int hAct = 0;

        while (i < n - 1){

            hAct = inicio[++i];
            cur++;
            if (fin[j] <= hAct){
                j++;
                cur--;
            }            

            personas = max(personas, cur);
        }

        cout << (personas) << endl;

    }

    return 0;
}