#include <bits/stdc++.h>

using namespace std;

int BFS(vector< vector<int> > graph, int s) 
{ 

    // Number of nodes reached
    int amount = 0;

    // Mark all the vertices as not visited 
    bool *visited = new bool[graph.size()]; 
    for(int i = 0; i < graph.size(); i++) 
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
        amount++;
        queue.pop_front(); 
  
        // Get all adjacent vertices of the dequeued 
        // vertex s. If a adjacent has not been visited,  
        // then mark it visited and enqueue it 
        for (i = graph[s].begin(); i != graph[s].end(); ++i) 
        { 
            if (!visited[*i]) 
            { 
                visited[*i] = true; 
                queue.push_back(*i); 
            } 
        } 
    }

    return amount; 
}

int main(){

    int especies, relaciones;

    while (cin >> especies){

        if (especies == 0) break;

        vector< vector<int> > data(especies+1);

        int relaciones;
        cin >> relaciones;

        for (int i = 0; i < relaciones; i++){
            
            int p, e;
            cin >> p >> e;
            
            data[p].push_back(e);
            data[e].push_back(p);
            
        }

        if (BFS(data, 1) == especies){
            cout << "TODAS" << endl;
        } else {
            cout << "FALTA ALGUNA" << endl;
        }

    }

    return 0;
}