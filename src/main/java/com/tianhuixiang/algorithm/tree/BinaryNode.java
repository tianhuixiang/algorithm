package com.tianhuixiang.algorithm.tree;

public class BinaryNode<E> {
    private E element;

    private BinaryNode<E> left;

    private BinaryNode<E> right;

    public BinaryNode(E element){
        this(element,null,null);
    }

    public BinaryNode(E element,BinaryNode<E> left,BinaryNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }
}
