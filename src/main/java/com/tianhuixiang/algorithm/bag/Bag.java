package com.tianhuixiang.algorithm.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E>{

    private E[] table;

    private int bagSize;

    private static int DEFAULT_CAPACITY  = 10;

    public Bag(){
        table =(E[]) new Object[DEFAULT_CAPACITY];
    }

    public Bag(int capacity){
        ensureCapacity(capacity);
    }

    boolean add(E element){
        if(element == null){
            return false;
        }
        if(table.length == bagSize){
            ensureCapacity(2*DEFAULT_CAPACITY);
        }
        table[bagSize] = element;
        bagSize++;
        return true;
    }

    boolean isEmpty(){
        return bagSize == 0;
    }

    int size(){
        return bagSize;
    }

    private void ensureCapacity(int newCapacity){

        E[] newTable = (E[]) new Object[newCapacity];
        for(int i=0; i<table.length;i++){
            newTable[i] = table[i];
        }
        table = newTable;
    }

    public Iterator<E> iterator() {
        return new DeIterator<E>();
    }

    private class DeIterator<E> implements Iterator<E>{
        private int currentSize ;

        public boolean hasNext() {
            return currentSize < bagSize;
        }

        public E next() {

            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (E)table[currentSize++];
        }

        public void remove() {

        }
    }
}
