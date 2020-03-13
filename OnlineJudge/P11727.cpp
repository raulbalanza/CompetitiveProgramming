#include <bits/stdc++.h>

using namespace std;

int main(){

    int cases;
    cin >> cases;
    int count = 1;

    while (cases--){

        int salaries[3];
        scanf("%d %d %d", &salaries[0], &salaries[1], &salaries[2]);
        sort(salaries, salaries+3);

        cout << "Case " << count++ << ": " << salaries[1] << endl;

    }

    return 0;

}