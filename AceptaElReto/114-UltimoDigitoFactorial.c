#include <stdio.h>

int main() {
    
    int rep, num;
    scanf("%d", &rep);
    int nums = 0;

    while (rep > nums) {
        
        scanf("%d", &num);
        
        switch (num) {
            case 0:
            case 1:	
                num = 1;
                break;
            case 2:	
                num = 2;
                break;
            case 3:	
                num = 6;
                break;
            case 4:	
                num = 4;
                break;
            default: 
                num = 0;
        }

        printf("%d\n", num);
            
        nums++; 
    }

    return 0;
}