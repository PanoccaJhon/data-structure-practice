
#include "List.h"
#include "Node.h"

#ifndef LINKED_LIST_H
#define LINKED_LIST_H
template <class T>
class LinkedList : public List
{
private:
    Node &head;
    int size;
    Node *lp; // last ptr

public:
    LinkedList() : head{nullptr}, size{0}, lp{nullptr} {};
    void insert(T);
    void insert(T, int);
    bool search(T);
    bool remove(T);
    bool isEmpty();
    int size();
};
#endif