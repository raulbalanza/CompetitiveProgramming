#include <bits/stdc++.h>

using namespace std;

int main(){

    int i;
    cin >> i;

    while (i--){

        int max, min;
        scanf("%d / %d", &max, &min);

        if (max >= min){
            cout << "BIEN" << endl;
        } else {
            cout << "MAL" << endl;
        }

    }

    return 0;

}