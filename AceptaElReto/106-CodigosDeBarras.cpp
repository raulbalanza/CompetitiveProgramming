#include <bits/stdc++.h>

using namespace std;

string code;

bool startswith(string pref){
    return code.rfind(pref, 0) == 0;
}

string pais(){

    if (code.size() <= 8) return "";

    string codigos[] = {"0", "380", "50", "539", "560", "70", "759", "850", "890"};
    string paises[] = {"EEUU", "Bulgaria", "Inglaterra", "Irlanda", "Portugal", "Noruega", "Venezuela", "Cuba", "India"};

    for (int i=0; i<9; i++){
        if (startswith(codigos[i])){
            return " " + paises[i];
        }
    }

    return " Desconocido";

}

int main(){

    while (cin >> code){

        if (code == "0") break;

        int size = code.size();

        if (size > 13) { 
            cout << "NO" << endl;
            continue;
        }

        if (size <= 8){

            while (size < 8){
                code = "0" + code;
                size++;
            }

        } else {

            while (size < 13){
                code = "0" + code;
                size++;
            }

        }    

        int suma = 0;

        for (int i=size-2, j=1; i>=0; i--, j++){
            if (j%2 != 0){
                suma += (code[i] - '0') * 3;
            } else {
                suma += (code[i] - '0');
            }
        }

        if ((suma%10) == 0){
            if (0 == (code[size-1] - '0')) cout << "SI" << pais() << endl;
            else cout << "NO" << endl;
        } else {
            if ((10-(suma%10) == (code[size-1] - '0'))) {
            cout << "SI" << pais() << endl;
            } else cout << "NO" << endl;
        }

    }

    return 0;
}