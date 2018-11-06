package com.tianhuixiang.algorithm.entity;

public class Node<E> {

    private E node;

    private Node<E> next;

    public Node(E node,Node<E> next){
        this.node = node;
        this.next = next;
    }
}
