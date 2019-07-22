package com.tianhuixiang.algorithm.quque;

public class SeqCycleQueue<E> implements QQueue<E> {

    private Object[] value;

    private int head;

    private int tail;

    public SeqCycleQueue(){
        this(16);
    }

    public SeqCycleQueue(int capacity){
        this.value = new Object[Math.abs(capacity)];
        this.head = this.tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean enQueue(E element) {
        if(null == element){
            return false;
        }

        if(this.head == (this.tail+1) % this.value.length){
            Object[] temp = new Object[this.value.length*2];
            int i = this.head;
            int j = 0;
            while(i != this.tail){
                temp[j] = this.value[i];
                i = (i+1)% value.length;
                j++;
            }
            this.head = 0;
            this.tail = j;
            this.value = temp;
        }

        this.value[this.tail] = element;
        this.tail = (this.tail+1) % this.value.length;
        return true;
    }

    public E deQueque() {
        if(!isEmpty()){
            E temp = (E)this.value[this.head];
            this.head = (this.head+1) % this.value.length;
            return temp;
        }
        return null;
    }
}
