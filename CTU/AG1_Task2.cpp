#include <stdio.h>
#include <iostream>

#ifndef __PROGTEST__
#include <assert.h>
#endif /* __PROGTEST__ */

using namespace std;

typedef struct Politician Politician;
typedef struct BNHeap BNHeap;
typedef struct Coalition Coalition;

struct Coalition {
    uint32_t party;
    Coalition * next;
};

struct Politician {
    uint32_t id_party;
    uint32_t id_politician;
    string name;
    uint32_t popularity;
    uint8_t gender;
    long long int popularity_time;
};

struct Node {
    Politician * key;
    int degree;
    Node *child, *sibling, *parent;
};

void traverseCoalition(Coalition * c){

    if (c == nullptr) {cout << "ES NULO" << endl; return;}

    cout << "C: ";
    while (c != nullptr){
        cout << c->party << " ";
        c = c->next;
    }
    cout << endl;

}

void CONewCoalition(uint32_t p1, uint32_t p2, Coalition ** coals){ // Hacer traza
    Coalition * c = new Coalition;
    c->party = p1;
    c->next = new Coalition;
    c->next->party = p2;
    c->next->next = nullptr;

    coals[p1] = c;
    coals[p2] = c;
}

void COAddParty(Coalition * c, uint32_t party, Coalition ** coals){ // Hacer traza

    Coalition * nueva = new Coalition;
    nueva->party = c->party;
    nueva->next = c->next;

    c->party = party;
    c->next = nueva;

    coals[party] = c;

}

void CORemoveParty(Coalition * c, uint32_t party, Coalition ** coals){

    Coalition * prev = nullptr;
    Coalition * aux = c;
    while (aux->party != party){
        prev = aux;
        aux = aux->next;
    }

    if (prev == nullptr){ // El partido era el primero de la lista
        if (c->next != nullptr){ // El partido no era el unico
            aux = c->next;
            c->party = c->next->party;
            c->next = c->next->next;
            delete aux;
        } else { // El partido era el unico
            cout << "This should not happen" << endl;
        }
    } else { // El partido no era el primero de la lista
        if (aux->next == nullptr){ // El partido era el ultimo de la lista
            prev->next = nullptr;
            delete aux;
        } else { // El partido no era el ultimo de la lista
            prev->next = aux->next;
            delete aux;
        }

    }

    coals[party] = nullptr;
    if (c->next == nullptr){ // Si el penultimo habia abandonado, la coalicion se rompe
        coals[c->party] = nullptr;
        delete c;
    }

}

void COMergeCoalitions(Coalition * c1, Coalition * c2, Coalition ** coals){

    Coalition * aux1 = c1;
    Coalition * aux2 = c2;
    while (aux1->next != nullptr){
        if (aux2 != nullptr){
            coals[aux2->party] = c1;
            aux2 = aux2->next;
        }
        aux1 = aux1->next;
    }

    aux1->next = c2;

    while (aux2 != nullptr){
        coals[aux2->party] = c1;
        aux2 = aux2->next;
    }

}

int cmp(Politician * p1, Politician * p2){

    if (p1->popularity > p2->popularity){
        return 1;
    } else if (p1->popularity < p2->popularity){
        return -1;
    } else if (p1->popularity_time > p2->popularity_time){
        return 1;
    } else if (p1->popularity_time < p2->popularity_time){
        return -1;
    } else return 0;

}

Node * BHInit(Politician * p){
    Node * n = new Node;
    n->child = nullptr;
    n->degree = 0;
    n->key = p;
    n->parent = nullptr;
    n->sibling = nullptr;
    return n;
}

// Merge t1 (old tree) with t2 (new tree)
Node * BHLinkTree(Node * t1, Node * t2){

    if (cmp(t2->key, t1->key) >= 0){
        // t2 is root, t1 is child

        t1->parent = t2;
        t1->sibling = t2->child;
        t2->child = t1;
        t2->degree++;
        return t2;
    } else {
        // t1 is root, t2 child

        t2->parent = t1;
        t2->sibling = t1->child;
        t1->child = t2;
        t1->degree++;
        return t1;
    }

}

Node * BHMerge(Node * A, Node * B){

    Node * summands[3];
    Node * carry = nullptr;
    int nonempty = 2;
    int cur_order = 0;
    int count;
    Node * a, * b;
    Node * C = nullptr;
    Node * Cend = nullptr;

    while (nonempty >= 2){
        nonempty = 0;
        count = 0;

        if (A != nullptr){
            nonempty++;
            if (A->degree == cur_order){
                a = A;
                A = A->sibling;

                a->sibling = nullptr;

                summands[count++] = a;
            }
        }

        if (B != nullptr){
            nonempty++;
            if (B->degree == cur_order){
                b = B;
                B = B->sibling;

                b->sibling = nullptr;

                summands[count++] = b;
            }
        }

        if (carry != nullptr){
            nonempty++;
            summands[count++] = carry;
            carry = nullptr;
        }

        if (count == 3){
            if (C == nullptr){
                C = summands[2];
                Cend = C;
            } else {
                Cend->sibling = summands[2];
                Cend = Cend->sibling;
            }
            carry = BHLinkTree(summands[0], summands[1]);
        } else if (count == 2){
            carry = BHLinkTree(summands[0], summands[1]);
        } else if (count == 1){
            if (C == nullptr){
                C = summands[0];
                Cend = C;
            } else {
                Cend->sibling = summands[0];
                Cend = Cend->sibling;
            }
        }
        cur_order++;

    }

    if (A != nullptr){
        if (C == nullptr){
            C = A;
            Cend = C;
        } else {
            Cend->sibling = A;
            Cend = Cend->sibling;
        }
    } else if (B != nullptr){
        if (C == nullptr){
            C = B;
            Cend = C;
        } else {
            Cend->sibling = B;
            Cend = Cend->sibling;
        }
    }

    return C;
}

Node * BHInsert(Node * n, Politician * p, Node * & nuevo){
    nuevo = BHInit(p);
    return BHMerge(n, nuevo);
}

Node * BHGetMax(Node * n){

    Node * max = nullptr;

    while (n != nullptr){

        if (max == nullptr || cmp(n->key, max->key) > 0){
            max = n;
        }
        n = n->sibling;

    }

    return max;

}

void treeRootDegrees(Node * b){

    cout << "D: ";
    while (b != nullptr){
        cout << b->degree << " ";
        b = b->sibling;
    }
    cout << endl;

}

Node * BHExtractMax(Node * n, uint32_t &max_id){

    Node * prev_max = nullptr;
    Node * max = nullptr;

    Node * prev = nullptr;
    Node * cur = n;

    while (cur != nullptr){

        if (max == nullptr || cmp(cur->key, max->key) > 0){
            max = cur;
            prev_max = prev;
        }
        prev = cur;
        cur = cur->sibling;

    }

    uint32_t max_party = max->key->id_party;
    max_id = max->key->id_politician;

    Node * res = n;

    if (prev_max == nullptr){
        res = max->sibling;
    } else prev_max->sibling = max->sibling;

    if (max->child != nullptr){

        Node * nuevo = nullptr;
        Node * aux = max->child;

        while (aux != nullptr){
            aux->parent = nullptr;
            Node * temp = aux;
            aux = aux->sibling;
            temp->key->id_party = max_party;
            temp->sibling = nuevo;
            nuevo = temp;
        }

        res = BHMerge(res, nuevo);

    }

    return res;

}

void BHIncreaseKey(Node * n, Node ** pols, Node * heap, uint32_t popularity = UINT32_MAX){

    n->key->popularity = popularity;

    Node * y = n;
    Node * z = y->parent;

    uint32_t party = heap->key->id_party;

    while (z != nullptr && cmp(y->key, z->key) >= 0){

        uint32_t id_y = y->key->id_politician;
        uint32_t id_z = z->key->id_politician;

        y->key->id_party = party;
        z->key->id_party = party;

        Politician * p = y->key;
        y->key = z->key;
        z->key = p;

        pols[id_y] = z;
        pols[id_z] = y;

        y = z;
        z = y->parent;

    }

}

Node * BHDelete(Node * root, Node * n, Node ** pols){
    uint32_t p;
    BHIncreaseKey(n, pols, root);
    return BHExtractMax(root, p);
}

uint32_t GetPartyID(Node * p){

    while (p->parent != nullptr){
        p = p->parent;
    }

    return p->key->id_party;

}

class CPulitzer {
public:

    Node ** pols;
    Node ** parts;
    Coalition ** coals;
    long long int cur_time;

    CPulitzer ( size_t N, size_t P ){
        parts = new Node*[N]();
        coals = new Coalition*[N]();
        pols = new Node*[P]();
        cur_time = 0;
    }

    bool register_politician ( uint32_t id_party, uint32_t id_politician, const string & name, uint32_t popularity, uint8_t gender ){

        if (pols[id_politician] != nullptr) return false;

        Politician * p = new Politician;
        p->id_politician = id_politician;
        p->name = name;
        p->popularity = popularity;
        p->popularity_time = cur_time++;
        p->gender = gender;
        p->id_party = id_party;

        if (parts[id_party] == nullptr){
            parts[id_party] = BHInit(p);
            pols[id_politician] = parts[id_party];
        } else {
            Node * aux;
            parts[id_party] = BHInsert(parts[id_party], p, aux);
            pols[id_politician] = aux;
        }

        return true;

    }

    bool politician_name ( uint32_t id_politician, string & name ) const {

        if (pols[id_politician] == nullptr) return false;

        name = pols[id_politician]->key->name;

        return true;

    }

    bool politician_gender ( uint32_t id_politician, uint8_t & gender ) const {

        if (pols[id_politician] == nullptr) return false;

        gender = pols[id_politician]->key->gender;

        return true;

    }

    bool politician_popularity ( uint32_t id_politician, uint32_t & popularity ) const {

        if (pols[id_politician] == nullptr) return false;

        popularity = pols[id_politician]->key->popularity;

        return true;

    }

    bool deregister_politician ( uint32_t id_politician ){

        if (pols[id_politician] == nullptr) return false;

        uint32_t id_party = GetPartyID(pols[id_politician]);
        parts[id_party] = BHDelete(parts[id_party], pols[id_politician], pols);

        if (parts[id_party] == nullptr && coals[id_party] != nullptr){
            CORemoveParty(coals[id_party], id_party, coals);
        }

        delete pols[id_politician]->key;
        delete pols[id_politician];
        pols[id_politician] = nullptr;

        return true;

    }

    bool party_leader ( uint32_t id_party, uint32_t & id_leader ) const {

        if (parts[id_party] == nullptr) return false;

        id_leader = BHGetMax(parts[id_party])->key->id_politician;

        return true;

    }

    bool change_popularity ( uint32_t id_politician, uint32_t popularity ){

        if (pols[id_politician] == nullptr) return false;

        uint32_t id_party = GetPartyID(pols[id_politician]);
        parts[id_party] = BHDelete(parts[id_party], pols[id_politician], pols);

        if (parts[id_party] == nullptr){
            pols[id_politician]->key->popularity = popularity;
            pols[id_politician]->key->popularity_time = cur_time++;
            parts[id_party] = BHInit(pols[id_politician]->key);
            delete pols[id_politician];
            pols[id_politician] = parts[id_party];
        } else {
            Node * aux;
            pols[id_politician]->key->popularity = popularity;
            pols[id_politician]->key->popularity_time = cur_time++;
            parts[id_party] = BHInsert(parts[id_party], pols[id_politician]->key, aux);
            delete pols[id_politician];
            pols[id_politician] = aux;
        }

        return true;

    }

    bool sack_leader ( uint32_t id_party ){

        if (parts[id_party] == nullptr) return false;

        uint32_t leader_id;
        parts[id_party] = BHExtractMax(parts[id_party], leader_id);

        if (parts[id_party] == nullptr && coals[id_party] != nullptr){
            CORemoveParty(coals[id_party], id_party, coals);
        }

        delete pols[leader_id]->key;
        delete pols[leader_id];
        pols[leader_id] = nullptr;

        return true;

    }

    bool merge_parties ( uint32_t dest_party, uint32_t src_party ){

        if (parts[dest_party] == nullptr || parts[src_party] == nullptr) return false;
        if (dest_party == src_party) return true;

        parts[dest_party] = BHMerge(parts[dest_party], parts[src_party]);

        Node * aux = parts[dest_party];
        while (aux != nullptr){
            aux->key->id_party = dest_party;
            aux = aux->sibling;
        }


        if (coals[dest_party] != nullptr){ // Dest in coalition

            if (coals[src_party] == nullptr){ // Source not in coalition

                // Source: no, Destination: yes
                // Do nothing

            } else {

                // Source: yes, Destination: yes

                // Source leaves
                CORemoveParty(coals[src_party], src_party, coals);

            }

        } else { // Dest not in coalition

            if (coals[src_party] == nullptr){ // Source not in coalition

                // Source: no, Destination: no
                // Do nothing

            } else { // Source in coalition

                // Source: yes, Destination: no

                // Source leaves
                CORemoveParty(coals[src_party], src_party, coals);

            }

        }

        parts[src_party] = nullptr;

        return true;

    }

    bool create_coalition ( uint32_t id_party1, uint32_t id_party2 ){

        if (parts[id_party1] == nullptr || parts[id_party2] == nullptr) return false;
        if (id_party1 == id_party2) return true;

        if (coals[id_party1] != nullptr){

            if (coals[id_party2] == nullptr){
                COAddParty(coals[id_party1], id_party2, coals);
            } else { // coals[id_party2] != nullptr
                if (coals[id_party1] != coals[id_party2]) // Parties are not in the same coalition
                    COMergeCoalitions(coals[id_party1], coals[id_party2], coals);
            }

        } else { // coals[id_party1] == nullptr

            if (coals[id_party2] == nullptr){
                CONewCoalition(id_party1, id_party2, coals);
            } else { // coals[id_party2] != nullptr
                COAddParty(coals[id_party2], id_party1, coals);
            }

        }

        return true;
    }

    bool leave_coalition ( uint32_t id_party ){

        if (parts[id_party] == nullptr || coals[id_party] == nullptr) return false;

        CORemoveParty(coals[id_party], id_party, coals);

        return true;
    }

    bool coalition_leader ( uint32_t id_party, uint32_t & id_leader ) const {

        if (parts[id_party] == nullptr) return false;
        if (coals[id_party] == nullptr) {
            bool res = party_leader(id_party, id_leader);
            return res;
        }

        Politician * max = nullptr;
        Coalition * aux = coals[id_party];
        while (aux != nullptr){
            Politician * temp = BHGetMax(parts[aux->party])->key;
            if (max == nullptr || cmp(temp, max) > 0){ max = temp; }
            aux = aux->next;
        }

        id_leader = max->id_politician;

        return true;
    }

    bool scandal_occured ( uint32_t id_party ){

        if (parts[id_party] == nullptr) return false;
        if (coals[id_party] == nullptr) {
            bool res = sack_leader(id_party);
            return res;
        }

        uint32_t coal_leader, part_leader;
        party_leader(id_party, part_leader);
        coalition_leader(id_party, coal_leader);

        /*Coalition * aux = coals[id_party];
        while (aux->party == id_party){
            aux = aux->next;
        }
        uint32_t another_id = aux->party;*/

        sack_leader(id_party);

        if (coals[id_party] == nullptr){

            // The party is not in a coalition anymore

            // If the coalition still exists, remove leader
            //if ((coal_leader != part_leader) && (coals[another_id] != nullptr)){
            if (coal_leader != part_leader){
                deregister_politician(coal_leader);
            }

            // If the coalition no longer exists, do nothing

        } else {

            // The party is still in the coalition, now delete coalition leader
            if (coal_leader != part_leader)
                deregister_politician(coal_leader);

        }

        return true;
    }

};


#ifndef __PROGTEST__

void example1(){

    uint8_t gender;
    uint32_t popularity, id_leader;
    std::string name;

    CPulitzer bot( 3, 10 );
    assert( bot.party_leader( 1, id_leader ) == 0 ); // false
    assert( bot.register_politician( 1, 5, "VK", 1000, 77 ) == 1 ); // true
    assert( bot.register_politician( 2, 4, "MZ", 1000, 77 ) == 1 ); // true
    assert( bot.register_politician( 2, 7, "VS", 500, 77 ) == 1 ); // true
    assert( bot.party_leader( 1, id_leader ) == 1 && id_leader == 5 ); // true, 5
    assert( bot.party_leader( 2, id_leader ) == 1 && id_leader == 4 ); // true, 4
    assert( bot.change_popularity( 7, 2000 ) == 1 ); // true
    assert( bot.party_leader( 2, id_leader ) == 1 && id_leader == 7 ); // true, 7
    assert( bot.register_politician( 1, 2, "MT", 500, 77 ) == 1 ); // true
    assert( bot.register_politician( 2, 2, "JP", 500, 77 ) == 0 ); // false
    assert( bot.register_politician( 2, 9, "JP", 500, 77 ) == 1 ); // true
    assert( bot.deregister_politician( 5 ) == 1 ); // true
    assert( bot.party_leader( 1, id_leader ) == 1 && id_leader == 2 ); // true, 2
    assert( bot.sack_leader( 2 ) == 1 ); // true
    assert( bot.change_popularity( 9, 200 ) == 1 ); // true
    assert( bot.sack_leader( 1 ) == 1 ); // true

}

int main(void){

    example1();

    return 0;
}

#endif /* __PROGTEST__ */