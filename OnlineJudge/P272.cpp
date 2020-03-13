#include <bits/stdc++.h>

using namespace std;

int main(){

    string line;
    bool open = true;

    while (getline(cin, line)){

        for (int i=0; i<line.length(); i++){

            if (line[i] == '\"'){

                if (open) { line[i] = '`'; line.insert(i, "`"); }
                else { line[i] = '\''; line.insert(i, "\'"); }

                open = !open;

            }

        }

        cout << line << endl;
        
    }

    return 0;
}