#include <bits/stdc++.h>

using namespace std;

void print_vector(vector<int> vect){

    for(int i=0; i<vect.size(); i++){

        cout << vect[i];
        if (i != vect.size()-1) cout << " ";

    }

    cout << endl;

}

int main(){

    int perla;
    vector<int> dat;

    while (cin >> perla){

        if (perla == 0) break;
        dat.push_back(perla);
        
        while (cin >> perla){

            if (perla == 0) break;
            dat.push_back(perla);

        }

        int size = dat.size();
        vector<int> res(size);

        if (size % 2 == 0){
            cout << "NO" << endl;
        } else {

            bool found = true;

            sort(dat.begin(), dat.end());

            for (int i=0, j=0; i<size-1 && found; i+=2, j++){

                if(dat[i] == dat[i+1]){

                    res[j] = dat[i];
                    res[size-j-1] = dat[i];

                } else {
                    found = false;
                }

            }

            if (!found){
                cout << "NO" << endl;
            } else {
                res[size/2] = dat[size-1];
                print_vector(res);
            }

        }

        dat.clear();

    }

    return 0;
}