#include <stdio.h>

int main(){

    int rep;
    scanf("%d", &rep);

    int done = 0;

    while (done < rep){

        char greeting[4];
        scanf("%s", greeting);

        char name[101];
        scanf("%s", name);
        printf("Hola, %s.\n", name);

        done++;
    }

    return 0;
}