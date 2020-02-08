#include <bits/stdc++.h>

using namespace std;

void print_vector(set<int> vect){

    set<int>::iterator it;

    for (it = vect.begin(); it != vect.end(); it++){

        if (it != vect.begin()) cout << " ";
        cout << *it; 

    }

    cout << endl;
    
}

int main(int argc, char* argv[]){

    int numeros;

    while(cin >> numeros){

        if (numeros == 0) break;
        int data[numeros];
        set<int> res;

        for (int i=0; i<numeros; i++){
            cin >> data[i];
        }

        sort(data, data+numeros);

        for (int i=1; i<numeros; i++){

            for (int j=i-1; j>=0; j--){

                res.insert(data[i]-data[j]);

            }

        }

        print_vector(res);

        // res.clear();

    }

    return 0;
}