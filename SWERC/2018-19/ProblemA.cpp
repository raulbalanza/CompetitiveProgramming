#include <bits/stdc++.h>

using namespace std;

int main() {

    int N, k, i, off, maxOff = 0, found = 0;
    cin >> N >> k;

    N++;

    int lights[N];
    fill(lights, lights+N, 1);

    while (k--){
        off = 0;
        cin >> i;
        for(int j=1; (j*i)<N; j++){ // First light is number one
            if (lights[j*i] == 1)   lights[j*i] = 0;
            else                    lights[j*i] = 1;
        }

        for (int j=1; j<N; j++){
            if (lights[j] == 0){
                off++;
            }
        }

        if (off == N){
            cout << N << endl;
            found = 1;
        } else if (off > maxOff){
            maxOff = off;
        }
    }

    if (!found) cout << maxOff << endl;

}