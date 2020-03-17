#include <bits/stdc++.h>

using namespace std;

long long int sumOfDigits(long long int n){

    long long int sum = 0;

    while (n > 0){
        sum += n%10;
        n/=10;
    }

    return sum;

}

int main(){

    long long int num;

    while (cin >> num){

        if (num == 0) break;

        while (num/10 != 0){
            num = sumOfDigits(num);
        }

        cout << num << endl;

    }

    return 0;

}