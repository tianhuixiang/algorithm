package com.tianhuixiang.algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class TestJosephus {

    public static void main(String[] args){
        josephus(5,2);
    }

    public static void josephus(Integer N,Integer M){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){
            index = (index + M -1) % list.size();
            System.out.println("删除"+list.get(index));
            list.remove(index);
        }
    }
}
