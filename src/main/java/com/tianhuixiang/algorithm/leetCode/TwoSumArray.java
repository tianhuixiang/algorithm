package com.tianhuixiang.algorithm.leetCode;

import com.alibaba.fastjson.JSON;

class TwoSumArray {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0 ;i<nums.length;i++){
            int c = target - nums[i];
            if(c < 0){
                break;
            }
            for(int j = 0;j<nums.length;j++){
                if(i == j){
                    continue;
                }
                if(nums[j] == c){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
            if(result[1] != 0){
                break;
            }
        }
        return result;
    }

    public void sort(int[] nums){
        int j=0;
        for(int i=1;i<nums.length;i++){
            int tmp = nums[i];
            for(j=i;j>0 && tmp < nums[j-1];j--){
                nums[j] = nums[j-1];
            }
            nums[j] = tmp;
        }
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        TwoSumArray solution = new TwoSumArray();
        System.out.println(JSON.toJSONString(solution.twoSum(nums,9)));
    }
}
