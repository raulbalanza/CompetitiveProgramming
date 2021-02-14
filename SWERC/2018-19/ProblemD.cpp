#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(){

    ll x, y, cols, rows, N;
    cin >> cols >> rows >> N;

    vector<ll> y_coords;
    map<ll, set<ll>> monuments;

    for (ll i=0; i<N; i++){
        cin >> x >> y;
        monuments[x].insert(y);
    }

    for (auto x0 = monuments.begin(); x0 != monuments.end(); x0++){

        ll maxY = *(x0->second.begin());
        ll minY = *(x0->second.rbegin());

        y_coords.push_back(maxY);
        y_coords.push_back(minY);

    }

    sort(y_coords.begin(), y_coords.end());

    ll distance = cols-1;
    ll median = y_coords[y_coords.size()/2];

    for (auto x0 = monuments.begin(); x0 != monuments.end(); x0++){

        ll minY = *((x0->second).begin());
        ll maxY = *((x0->second).rbegin());

        if (maxY != minY){

            if (maxY > median && minY > median)
                distance += 2*abs(median-maxY);
            else if (maxY < median && minY < median)
                distance += 2*abs(median-minY);
            else {
                distance += 2*abs(median-maxY);
                distance += 2*abs(median-minY);
            }

        } else distance += 2*abs(median-maxY);

    }

    cout << distance << endl;

    return 0;
}