#ifndef ARRAY_STACK_H
#define ARRAY_STACK_H
#include "Stack.h"
#define FACTOR 10
template<class T>
class ArrayStack: public Stack<T>{
	private:
		T data[];
		int size;
		T* sp;
		void resize();
	public:
		ArrayStack(int sz):size{sz}, data{new T[size]},sp{data}{}
		void push(T);
		void pop();
		T top();
		bool isEmpty();
};
#endif
