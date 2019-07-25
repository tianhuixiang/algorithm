package com.tianhuixiang.algorithm.leetCode;

import com.alibaba.fastjson.JSON;
import com.tianhuixiang.algorithm.entity.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumList {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        StringBuffer s1 = new StringBuffer(l1.val+"");
        //首先循环L1和L2
        ListNode next1 = l1.next;
        while(next1 != null){
            s1.append(next1.val);
            next1 = next1.next;
        }

        StringBuffer s2 = new StringBuffer(l2.val+"");
        ListNode next2 = l2.next;
        while(next2 != null) {
            s2.append(next2.val);
            next2 = next2.next;
        }

        //将s1和s2翻转
        s1 = s1.reverse();
        s2 = s2.reverse();

        Long s3 = Long.valueOf(s1.toString()) + Long.valueOf(s2.toString());
        String sb = new StringBuffer( String.valueOf(s3)).reverse().toString();
        char[] c = sb.toCharArray();
        ListNode l3 = new ListNode(Integer.valueOf(String.valueOf(c[0])));
        ListNode next = null;
        for(int i =1;i < c.length;i++){
            ListNode temp = new ListNode(Integer.valueOf(String.valueOf(c[i])));
            if(next == null){
                next = temp;
                l3.next = next;
            }else{
                next.next = temp;
                next = temp;
            }
        }

        return l3;
    }

    public static void main(String[] args){
        int[][] maxtrix = new int[10][5];
        maxtrix[0][0] = 6;
        maxtrix[0][1] = 1;
        maxtrix[0][2] = 2;
        maxtrix[0][3] = 3;
        maxtrix[0][4] = 4;
        maxtrix[1][0] = 5;
        if(maxtrix == null || maxtrix[0] == null){

        }
       System.out.println(maxtrix[0].length);
       System.out.println(maxtrix.length);
    }

}
