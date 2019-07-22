package com.tianhuixiang.algorithm;

/**
 * 求解最大子序列
 *
 */
public class MaxSubListTest {
    public static void main(String[] args){
        int[] a = {-1,4,5,7,-3};

        int maxSum = 0;
        int start =0;
        int end = 0;
        for(int i=0; i<a.length;i++){

            int thisSum = a[i];

            for(int j= i+1 ;j<a.length;j++){
                if(thisSum < thisSum+a[j]){
                    thisSum += a[j];
                    if(maxSum < thisSum){
                        maxSum = thisSum;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        System.out.println("x="+start+",y="+end+",maxSum="+maxSum);
    }
}
