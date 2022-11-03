
#ifndef LIST_H
#define LIST_H

template<class T>
class List{
    public:
    virtual void insert(T) = 0;
    virtual void insert(T,int) = 0;
    virtual bool search(T) = 0;
    virtual bool remove(T) = 0;
    virtual bool isEmpty() = 0;
    virtual int size() = 0;
};
#endif