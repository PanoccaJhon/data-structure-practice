#include "arrayStack.h"


template<typename T>
void ArrayStack<T>::push(T e){
	int numElements = sp-data;
	if(numElements == size)
		resize();
	*sp = e;
	sp++;
}

template<typename T>
void ArrayStack<T>::pop(){
	if(empty())
		return;
	sp--;
}
template<typename T>
T& ArrayStack<T>::top(){
	return data[sp];
}

template<typename T>
bool ArrayStack<T>::isEmpty(){
	int numElem = sp-data;
	return numElem == 0;
}

template<typename T>
void ArrayStack<T>:: resize(){
	T newData[] = new T[size+FACTOR];
	for(int i= 0; i< size; i++){
		newData[i]= data[i];
	}
	delete[] data;
	data = newData;
	sp = data+size;
	size += FACTOR;
}
