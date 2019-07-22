package com.tianhuixiang.algorithm.list;

import com.tianhuixiang.algorithm.entity.Node;

public class MyLinkedList<E>{
    private Node<E> head;

    public MyLinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean add(E element){
        if(isEmpty()){
            head = new Node<E>(element,null);
            return true;
        }else if(null == head.getNext()){
            Node node = new Node(element,null);
            head.setNext(node);
            return true;
        }

        boolean flag = true;
        Node node = head.getNext();
        while(flag){
            if(node.getNext() == null){
                Node tempNode = new Node(element,null);
                node.setNext(tempNode);
                flag = false;
            }else{
                node = node.getNext();
            }
        }
        return true;
    }

    public boolean contains(E element){

        if(isEmpty()){
            return false;
        }

        if(head.getNext() == null){
            return head.getData().equals(element);
        }

        Node node = head.getNext();
        while(true){
            if(node.getData().equals(element)){
                return true;
            }else if(node.getNext() != null){
                node = node.getNext();
            }else{
                return false;
            }
        }
    }
}
