package com.tianhuixiang.algorithm.tree;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<E extends Comparable<? super E>> {
    private BinaryNode<E> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }



    public boolean contains(E element){
        return false;
    }

    public E findMin(){
        if(isEmpty()){
            throw new RuntimeException("xxxx");
        }

        return this.findMin(root).getElement();
    }

    public E findMax(){
        if(isEmpty()){
            throw new RuntimeException("xxxxx");
        }
        return this.findMax(root).getElement();
    }

    public void insert(E x){
        root = insert(x,root);
    }

    /**
     * 判断x与根节点的大小，当相等，则返回true，
     * 当比根节点小，则与根节点的左子节点进行比较
     * 当比根节点大，则与根节点的右子节点进行比较
     * 二叉查找树特点：对于节点T来说，左边所有的节点一定比它小，右边所有的节点一定比它大
     * @param x
     * @param t
     * @return
     */
    private boolean contains(E x,BinaryNode<E> t){

        if(t == null){  //当为空树时，直接返回
            return false;
        }

        int compareResult = x.compareTo(t.getElement());
        if(compareResult == 0){
            return true;
        }else if(compareResult < 0){
            return contains(x,t.getLeft());
        }else{
            return contains(x,t.getRight());
        }
    }

    /**
     * 查找最小，对于二叉查找树，它的最后一个左子节点就是最小的
     * @param t
     * @return
     */
    private BinaryNode<E> findMin(BinaryNode<E> t){
        if(t == null){
            return null;
        }else if(t.getLeft() == null){
            return t;
        }else{
            return findMin(t);
        }
    }

    private BinaryNode<E> findMax(BinaryNode<E> t){
        if(t != null){
            while(t.getRight() != null){
                t = t.getRight();
            }
        }
        return t;
    }

    private BinaryNode<E> insert(E x ,BinaryNode<E> t){
        if(t == null){
            return new BinaryNode<E>(x,null,null);
        }

        int compareResult = x.compareTo(t.getElement());
        if(compareResult < 0){
            t.setLeft(insert(x,t.getLeft()));
        }else if(compareResult > 0 ){
            t.setRight(insert(x,t.getRight()));
        }
        return t;
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

        for(int i=0;i<10;i++){
            binarySearchTree.insert(i);
        }

        System.out.println(binarySearchTree.findMax());

    }
}
