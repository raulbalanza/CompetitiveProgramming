#include <bits/stdc++.h>

using namespace std;

int BFS(int s, vector< vector<int> > adj) 
{ 
    set<int> places;

    // Mark all the vertices as not visited 
    bool *visited = new bool[adj.size()]; 
    for(int i = 0; i < adj.size(); i++) 
        visited[i] = false; 
  
    // Create a queue for BFS 
    list<int> queue; 
  
    // Mark the current node as visited and enqueue it 
    visited[s] = true; 
    queue.push_back(s); 
  
    // 'i' will be used to get all adjacent 
    // vertices of a vertex 
    vector<int>::iterator i; 
  
    while(!queue.empty()) 
    { 
        // Dequeue a vertex from queue and print it 
        s = queue.front(); 
        // cout << s << " "; 
        places.insert(s);
        queue.pop_front(); 
  
        // Get all adjacent vertices of the dequeued 
        // vertex s. If a adjacent has not been visited,  
        // then mark it visited and enqueue it 
        for (i = adj[s].begin(); i != adj[s].end(); ++i) 
        { 
            if (!visited[*i]) 
            { 
                visited[*i] = true; 
                queue.push_back(*i); 
            } 
        } 
    }

    return places.size();
}

int main(){

    int a, b, p, c;

    while (cin >> p >> c){

        vector< vector< int > > data(p);

        for (int i=0; i<c; i++){
            cin >> a >> b;
            a--; b--;
            data[a].push_back(b);
            data[b].push_back(a);
        }

        if (BFS(0, data) == p){
            cout << "BICI" << endl;
        } else {
            cout << "A PIE" << endl;
        }
        
    }

    return 0;
}