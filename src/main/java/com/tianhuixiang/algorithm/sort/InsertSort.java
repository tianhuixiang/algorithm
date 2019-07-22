package com.tianhuixiang.algorithm.sort;

import com.alibaba.fastjson.JSON;

public class InsertSort<E extends Comparable<? super E>> {

    public void insertSort(E[] a){
        for(int p = 1;p<a.length;p++){
            int j = 0;
            E temp = a[p];
            for(j = p ; j>0 ;j--){
                if(temp.compareTo(a[j-1]) < 0){
                    a[j] = a[j-1];
                }
            }
            a[j] = temp;
        }
    }

    public static void main(String args[]){
        Integer a[] = {34,8,64,51,32,21};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
