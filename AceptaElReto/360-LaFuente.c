#include <stdio.h>

void getCase(){

    int inicial, minima;
    scanf("%d %d", &inicial, &minima);

    int actual = inicial;
    int rellenar = 0;

    while (1){

        int resta;
        scanf("%d", &resta);

        if (resta == -1){ break; }
        else {

            actual -= resta;

            if (actual < minima){
                rellenar++;
                actual = inicial;
            }

        }

    }

    printf("%d\n", rellenar);

}

int main(){

    int cases;
    scanf("%d", &cases);

    int i;
    for (i=0; i<cases; i++){ getCase(); }

    return 0;

}