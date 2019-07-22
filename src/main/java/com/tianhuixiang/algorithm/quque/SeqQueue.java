package com.tianhuixiang.algorithm.quque;

public class SeqQueue<E> implements QQueue<E> {

    private Object[] value;

    private int head;

    private int tail;

    public SeqQueue(){
        this(16);
    }

    public SeqQueue(int capacity){
        value = new Object[Math.abs(capacity)];
        head=-1;
        tail=-1;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean enQueue(E element) {
        if(element == null){
            return false;
        }

        if(isEmpty()){
            this.value[0] = element;
            this.head ++;
            this.tail ++;
        }else{
            if(this.tail == this.value.length -1){  //当数组满的时候，需要进行扩容
                Object[] temp = new Object[this.value.length * 2];
                for(int i=0;i<this.value.length-1;i++){
                    temp[i] = this.value[i];
                }
                this.value = temp;
            }

            this.value[this.tail ++] = element;
        }

        return true;
    }

    public E deQueque() {

        if(isEmpty()){
            return null;
        }

        E result = (E)this.value[head ++];
        return result;
    }
}
