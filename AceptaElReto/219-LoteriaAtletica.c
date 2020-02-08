
#include <stdio.h>

int main(int argc, char *argv[])
{

    int count, proc = 0;
    scanf("%d", &count);

    while (proc < count){

        int decimos, i, total = 0;
        scanf("%d", &decimos);

        for (i=0; i<decimos; i++){
            int value;
            scanf("%d", &value);
            if (value%2==0) total++;
        }

        printf("%d\n", total);

        proc++;

    }

    return 0;

}