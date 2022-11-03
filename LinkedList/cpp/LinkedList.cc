#include <assert.h>
#include "LinkedList.h"

template <typename T>
void LinkedList<T>::insert(T data)
{
    Node newNode = new Data(data);
    *lp.next = newNode;
    lp = &newNode;
    size++;
}

template <typename T>
void LinkedList<T>::insert(T data, int index)
{
    assert(index < size);
    Node newNode = new Node(data);
    if (index == 0)
    {
        newNode.next = head;
        head = &newNode;
    }
    else
    {
        Node &tmp = head;
        for (size_t i = 0; i < index - 1; i++)
            tmp = tmp.next;
        newNode.next = tmp.next;
        tmp.next = &newNode;
    }
    size++;
}

template <typename T>
bool LinkedList<T>::search(T data)
{
    return 0;
}

template <typename T>
bool LinkedList<T>::remove(T data)
{
    return 0;
}

template <typename T>
bool LinkedList<T>::isEmpty()
{
    assert(size > 0);
    return this->head == nullptr;
}