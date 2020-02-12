#include <stdio.h>

int main(){

    int i, aux, n, total;

    while(scanf("%d", &n) == 1){

        if (n == 0) break;
        total = 0;

        for (i = 0; i < n; i++){

            scanf("%d", &aux);
            total += aux;

        }

        printf("%d\n", total);

    }

    return 0;
}