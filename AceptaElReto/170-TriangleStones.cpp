#include <bits/stdc++.h>

using namespace std;

int main() {
		
    int stones, size, stUsed;
    
    while (cin >> stones) {
        
        if (stones==0) break;
        
        size = (int) ((-1+sqrt(1+8.0*stones))/2.0);
        stUsed = (size*size + size)/2;
        
        cout << size << " " << (stones-stUsed) << endl;
        
        
    }
    
    return 0;
    
}