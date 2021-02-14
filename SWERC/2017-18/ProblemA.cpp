#include <bits/stdc++.h>

using namespace std;

#define MAXIMO 1000000001

int main(int argc, char** argv)
{

    int n, m, aux;
    cin >> n >> m;

    set<int> in, out;

    while (n--)
    {
        cin >> aux;
        in.insert(aux);
    }

    while (m--)
    {
        cin >> aux;
        out.insert(aux);
    }

    map<int, int> diffs;
    pair<int, int> max = make_pair(MAXIMO, -1);

    for (auto it = out.begin(); it != out.end(); it++)
    {

        for (auto it2 = in.begin(); it2 != in.end() && (*it2 < *it); it2++)
        {

            int diff = ((*it) - (*it2));

            if (diffs.find(diff) != diffs.end())
                diffs[diff]++;
            else
                diffs[diff] = 1;

            if (max.second < diffs[diff] || (max.second == diffs[diff] && max.first > diff)){
                max.second = diffs[diff];
                max.first = diff;
            }

        }

    }

    if (max.first == MAXIMO){
        cout << 0 << endl;
    } else cout << max.first << endl;

    return 0;
}