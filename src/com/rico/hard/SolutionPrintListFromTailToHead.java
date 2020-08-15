package com.rico.hard;

import java.util.*;
import java.util.Stack;

/**
 * @author Rico_dds
 * @date 2020/8/6 22:33
 *
 *      cong尾到头打印链表
 */
public class SolutionPrintListFromTailToHead {

public static class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if(listNode == null){
            return res;
        }
        Stack<Integer> node = new Stack<>();
        while(listNode != null){
            node.push(listNode.val);
            listNode = listNode.next;
        }
        while(!node.isEmpty()){
            res.add(node.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        System.out.println(printListFromTailToHead(listNode));

    }

}
