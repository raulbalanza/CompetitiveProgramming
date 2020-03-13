#include <bits/stdc++.h>

using namespace std;

bool isUgly(long long int n){

    while (n%2 == 0) n/=2;
    while (n%3 == 0) n/=3;
    while (n%5 == 0) n/=5;

    return n == 1;

}

int main(){

    /* 
    int count = 0;
    long long int iter = 1;
    long long int last = -1;

    while (count < 1500){

        if (isUgly(iter++)){
            cout << "Found " << iter-1 << endl;
            last = iter-1;
            count++;
        }

    }

    cout << "The 1500'th ugly number is " << last << "." << endl; */
    cout << "The 1500'th ugly number is 859963392." << endl;

    return 0;

}