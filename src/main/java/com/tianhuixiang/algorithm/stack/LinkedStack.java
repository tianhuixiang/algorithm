package com.tianhuixiang.algorithm.stack;

import com.tianhuixiang.algorithm.entity.Node;

public class LinkedStack<E> implements SStack<E> {

    private Node<E> top;

    public LinkedStack(){
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean push(E element) {

        if(element == null){
            return false;
        }

        this.top = new Node<E>(element,top);
        return true;
    }

    public E pop() {
        if(!isEmpty()){
            E temp = top.getData();
            this.top = this.top.getNext();
            return temp;
        }
        return null;
    }

    public E get() {
        if(!isEmpty()){
            return top.getData();
        }
        return null;
    }
}
