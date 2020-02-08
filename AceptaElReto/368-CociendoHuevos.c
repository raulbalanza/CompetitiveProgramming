#include <stdio.h>
#include <math.h>

int main(){

    int run = 1;
    while (run == 1){

        int h, c;
        scanf("%d %d", &h, &c);

        if (h == 0 && c == 0){
            run = 0;
        } else {

            int res = ((int) ceil(h / (c*1.0)))*10;
            printf("%d\n", res);

        }


    }

    return 0;
}