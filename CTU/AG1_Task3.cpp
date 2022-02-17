#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef int64_t weight_t;

int ** tableSolutionPath;
weight_t ** tablePeople;
weight_t ** tableSolutionAmount;

weight_t PeopleChecked(int start, int end, int stop){
    
    if (tablePeople[start][stop] != -1) return tablePeople[start][stop];
    return 0;

}

weight_t ComputeSolution(int start, int end, int inspectors){

    if (tableSolutionAmount[start][inspectors] != -1)
        return tableSolutionAmount[start][inspectors];

    pair<weight_t, int> curMax = make_pair(0, -1);
    if (inspectors == 0) return 0;

    for (int i = start; i <= end && (end-i+1) > inspectors; i++){
        
        weight_t res1 = PeopleChecked(start, end, i);
        weight_t res2 = 0;

        if (inspectors >= 2){ res2 = ComputeSolution(i+1, end, inspectors-1); }

        if ((res1 + res2) > curMax.first){
            curMax.first = res1 + res2;
            curMax.second = i;
        }

    }

    tableSolutionAmount[start][inspectors] = curMax.first;
    tableSolutionPath[start][inspectors] = curMax.second;
    return curMax.first;

}

int main(void){

    int res, inspectors, stops, measurements, from, to;
    weight_t count;
    res = scanf("%d %d %d", &inspectors, &stops, &measurements);
    if (res){}

    stops--;
    
    tablePeople = new weight_t*[stops+1];
    tableSolutionPath = new int*[stops+1];
    tableSolutionAmount = new weight_t*[stops+1];
    for (int i=0; i<=stops; i++){
        tablePeople[i] = new weight_t[stops+1];
        tableSolutionPath[i] = new int[inspectors+1];
        tableSolutionAmount[i] = new weight_t[inspectors+1];
        for (int j=0; j<=stops; j++){
            tablePeople[i][j] = -1;
        }
        for (int j=0; j<=inspectors; j++){
            tableSolutionPath[i][j] = -1;
            tableSolutionAmount[i][j] = -1;
        }
    }

    for (int i=0; i<measurements; i++){

        cin >> from >> to >> count;
        for (int j=from; j<to; j++){

            for (int k=0; k<=from; k++){
                if (tablePeople[k][j] == -1) tablePeople[k][j]++;
                tablePeople[k][j] += count;
            }

        }

    }

    int insp = (inspectors < stops) ? inspectors : stops;
    weight_t temp = ComputeSolution(0, stops, insp);

    cout << temp << endl;

    int cur = tableSolutionPath[0][insp];
    int printed = (cur != -1);
    while (cur != -1){
        cout << "[" << cur << ";" << (cur+1) << "]";
        cur = tableSolutionPath[cur+1][--insp];
        if (cur != -1) cout << ",";
    }
    if (printed) cout << endl;

    for (int i=0; i<=stops; i++){
        delete [] tablePeople[i];
        delete [] tableSolutionPath[i];
        delete [] tableSolutionAmount[i];
    }

    delete [] tablePeople;
    delete [] tableSolutionPath;
    delete [] tableSolutionAmount;

    return 0;
}