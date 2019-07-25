package com.tianhuixiang.algorithm.leetCode;

import com.alibaba.fastjson.JSON;
import com.tianhuixiang.algorithm.entity.ListNode;

/**
@Description:  对链表进行插入排序
 每次迭代，顺序获取某位置的值，与前面的元素一一比较，找到适合该元素的位置
@Author: tianhuixiang
@CreateDate: 2019/7/24 9:34
@Version: 1.0
*/
public class ListInsertSort {

    public ListNode insertionSort(ListNode head){

        if(head == null || head.next == null){
            return null;
        }

        ListNode fakeHead = new ListNode(0),cur = head,insert = fakeHead;

        fakeHead.next = head;

        while(cur != null && cur.next != null){

            if(cur.val < cur.next.val){
                cur = cur.next;
                continue;
            }

            insert = fakeHead;

            while(insert.next.val < cur.next.val){
                insert = insert.next;
            }

            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = insert.next;
            insert.next = tmp;
        }

        return fakeHead.next;
    }

    public static void main(String[] args){
        ListInsertSort insertSort = new ListInsertSort();
        ListNode head  = new ListNode(4);
        head = insertSort.insertionSort(head);
        System.out.println(JSON.toJSONString(head));
    }
}
