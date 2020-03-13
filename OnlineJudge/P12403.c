#include <stdio.h>

int main(){

    int operations;
    scanf("%d", &operations);

    long long int sum = 0;
    long long int value;
    char word[15];

    while (operations--){

        scanf("%s", word);

        if (word[0] == 'd'){
            scanf("%lld", &value);
            sum += value;
        } else {
            printf("%lld\n", sum);
        }

    }

    return 0;
}