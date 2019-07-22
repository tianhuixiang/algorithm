package com.tianhuixiang.algorithm.heap;

import java.nio.BufferUnderflowException;

public class BinaryHeap<E extends Comparable<? super E>>  {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] array;

    private int currentSize;

    public BinaryHeap(){

    }

    public BinaryHeap(int capacity){

    }

    public BinaryHeap(E[] items){

    }

    public void insert(E x){

        if(currentSize == array.length-1){
            enLargeArray(array.length *2 +1);
        }

        int hole = ++currentSize;
        for(;hole>1 && x.compareTo(array[hole/2]) <0;hole = hole/2){
            array[hole] = array[hole/2];
        }
        array[hole] = x;

    }

    public E findMin(){
        return null;
    }

    public E deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        E minItem = findMin();
        array[1] = array[currentSize --];
        perDown(1);
        return minItem;
    }

    public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }

    public void makeEmpty(){

    }

    public void perDown(int hole){
        int child =0;
        E tmp = array[hole];
        for(;hole * 2 <= currentSize;hole = child){
            child = hole *2;
            if(child != currentSize && array[child+1].compareTo(array[child]) < 0){
                child ++;
            }
            if(array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            }else{
                break;
            }
        }
        array[hole] = tmp;
    }

    public void buildHeap(){

    }

    private void enLargeArray(int newSize){

    }

}
