
#include <stdio.h>
#include <math.h>

int main()
{

    int v, t;
    while (scanf("%d %d", &v, &t)==2){

        if (t==0){

            printf("0\n");


        } else {

            double a = v/(t*1.0);
            double pos = (a*(2*t)*(2*t))/2;

            int res = (int)(pos < 0 ? (pos - 0.5) : (pos + 0.5));;

            printf("%d\n", res);

        }

    }

    return 0;

}