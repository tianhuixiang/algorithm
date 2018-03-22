package com.tianhuixiang.algorithm;

public class BinarySearchByRecursion {

    public static int rank(int[] arrays,int key){
        return rank(arrays,key,0,arrays.length-1);
    }

    public static int rank(int[] arrays,int key,int head,int tail){
        if(head > tail){
            return -1;
        }

        int mid = head + (tail - head)/2;

        if(key > arrays[mid]){
            return rank(arrays,key,mid+1,tail);
        }else if(key < arrays[mid]){
            return rank(arrays,key,head,mid-1);
        }else{
            return mid;
        }
    }

}
