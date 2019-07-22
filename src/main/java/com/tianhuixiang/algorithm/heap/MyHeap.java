package com.tianhuixiang.algorithm.heap;

/**
@Description: 使用数组实现堆
@Author: tianhuixiang
@CreateDate: 2019/4/28 15:52
@Version: 1.0
*/
public class MyHeap {
    private int[] nums;
    private int size;

    public MyHeap(int[] nums){
        nums = nums;
        size = nums.length;
    }



    //上浮，将t位置的元素与上层节点对比，如果比上级节点小，则交换
    private void siftUp(int t){
        int n = nums[t];
        for(;t>0;){
            int p = (t-1) >> 1;
            if(nums[p] < n){
                break;
            }
            n = nums[p];
            nums[p] = nums[t];
            nums[t] = n;
            t = p;
        }
    }

    /**
    * @Description 下沉，将元素下沉，首先比较下方左右节点的大小，然后比较元素与子节点的大小
    * @author      tianhuixiang
    * @param
    * @return
    * @exception
    * @date        2019/4/28 16:34
    */
    private void siftDown(int t){
        int n = nums[t];
        for(;t<nums.length/2;){
            int child = (t << 1) +1;
            //不能超过数组界限
            if (child + 1 < nums.length && nums[child] > nums[child +1]) {
                child = child + 1;
            }

            if(n > nums[child]){
                int c = nums[child];
                nums[t] = nums[child];
                nums[child] = c;
            }
            t = child;
        }
    }



}
