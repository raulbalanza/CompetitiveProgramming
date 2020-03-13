#include <bits/stdc++.h>

using namespace std;

int main(){

    string keys = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
    string line;

    while (getline(cin, line)){

        for (int i=0; i<line.size(); i++){
            if (line[i] != ' ') line[i] = keys[keys.find(line[i])-1];
        }

        cout << line << endl;

    }

    return 0;
}