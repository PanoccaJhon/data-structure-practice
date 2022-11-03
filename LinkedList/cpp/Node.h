
#ifndef NODE_H
#define NODE_H

template<class T>
class Node{
    public:
    Node(T dt):data{dt},next{nullptr}{};
    T data;
    Node& next;
};
#endif