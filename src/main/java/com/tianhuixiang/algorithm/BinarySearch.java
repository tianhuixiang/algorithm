package com.tianhuixiang.algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int[] array,int key){

        int head = 0; //头标
        int tail = array.length - 1;  //尾标

        while(head <= tail){
            int mid = head + (tail - head)/2;  //中间值

            if(key > array[mid]){
                head = mid +1;
            }else if(key < array[mid]){
                tail = mid -1;
            }else{
                return mid;
            }

        }

        return -1;
    }

    public static void main(String[] args){
        int[] array = {1,3,7,5,2,4,6};
        Arrays.sort(array);
        int key = 7;
        System.out.println(rank(array,key));
    }

}
