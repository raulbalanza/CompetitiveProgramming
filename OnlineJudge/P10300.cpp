#include <bits/stdc++.h>

using namespace std;

int main(){

    int cases, farmers, size_farm, animals, coeff;
    cin >> cases;

    while (cases--){

        double result = 0;

        cin >> farmers;
        while (farmers--){

            cin >> size_farm >> animals >> coeff;

            result += (size_farm/(animals*1.0)) * animals * coeff;

        }

        cout << result << endl;


    }

    return 0;
}