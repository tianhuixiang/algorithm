package com.tianhuixiang.algorithm.bag;

import java.util.Iterator;

public class BagTest {
    public static void main(String[] args){
        Bag<Double> numbers = new Bag<Double>();

        //初始化numbers
        for(int i= 0;i< 10;i++){
            numbers.add(Double.valueOf(i));
        }
        //打印长度
        System.out.println("bag size is: "+numbers.size());

        //求和
        double x = 0.0;
        Iterator<Double> lt = numbers.iterator();
        while(lt.hasNext()){
            x += lt.next();
        }

        System.out.println("bag sum is: "+x);

        //求平均
        double mean = x/numbers.size();
        System.out.println("mean is: "+mean);
    }
}
