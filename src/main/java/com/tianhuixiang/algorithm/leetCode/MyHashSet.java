package com.tianhuixiang.algorithm.leetCode;

import com.tianhuixiang.algorithm.entity.ListNode;

public class MyHashSet {

    private ListNode[] table;

    private int bucket = 1000;

    public MyHashSet(){
        table = new ListNode[bucket];
        for(int i=0;i<bucket;i++){
            table[i] = new ListNode(-1);
        }
    }

    public void add(int key){
        if(contains(key)){
            return;
        }

        ListNode tmp = table[key % bucket];
        boolean flag = true;
        while(flag){
            if(tmp.next != null){
                tmp = tmp.next;
            }else{
                tmp.next = new ListNode(key);
                return;
            }
        }

    }

    public boolean contains(int key){
        ListNode node = table[key % bucket];

        while(node != null){
            if(node.val != key){
                node = node.next;
            }else{
                return true;
            }

        }
        return false;
    }

    public void remove(int key){
        ListNode node = table[key % bucket];
        if(node.val == key){
            table[key % bucket] = node.next;
        }else{
            boolean flag = true;
            while(flag){
                if(node.next == null){
                    break;
                }
                if(node.next.val != key){
                    node = node.next;
                }else{
                    node.next = node.next.next;
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
    }
}
