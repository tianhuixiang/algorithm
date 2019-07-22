package com.tianhuixiang.algorithm.stack;


public class SeqStack<E> implements SStack<E> {

    //元素数组
    private Object[] value;

    //栈顶下标
    private int top;

    public SeqStack(){
        this(16);
    }

    public SeqStack(int initSize){
        value = new Object[Math.abs(initSize)];
        top = -1;
    }


    public boolean isEmpty() {
        //数组元素的长度如果为0，则为空栈
        return top == -1;
    }

    public boolean push(E element) {
        if(element == null){
            return false;
        }

        if(this.top == this.value.length -1){ //当栈满的时候，需要进行扩容
            ensureCap();
        }

        this.top ++;
        this.value[top] = element;
        return true;
    }

    public E pop() {

        if(isEmpty()){
            return null;
        }
        E result = (E)this.value[top];
        this.value[top] = null;
        top--;
        return result;
    }

    public E get() {
        if(isEmpty()){
            return null;
        }
        return (E)this.value[top];
    }

    private void ensureCap(){
        Object[] temp = new Object[this.value.length * 2];
        for(int i =0;i<this.value.length-1;i++){
            temp[i] = this.value[i];
        }

        this.value = temp;
    }

    @Override
    public String toString() {
        String str= "(";

        for(int i= top;i >= 0;i--){
            if(this.value[i] != null){
                if(i == 0){
                    str += this.value[i];
                }else{
                    str += this.value[i] +",";
                }
            }
        }

        str += ")";

        return str;
    }

    public static void main(String args[]){
        SStack<String> stack = new SeqStack<String>();
        System.out.println(stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.toString());

        System.out.println(stack.pop());
        stack.push("D");
        System.out.println(stack.get());
    }
}
