package com.rico.medium;
import com.rico.tester.TreeNodeTest;

;

/**
 * @author Rico_dds
 * @date 2020/8/8 15:47
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点
 * 并且返回。注意，树中的结点不仅
 * 包含左右子结点，同时包含指向父
 * 结点的指针。
 *     未完成
 */

public class SolutionGetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){            //如果节点为空，直接返回null
            return pNode;
        }
        if (pNode.right != null){      //节点有右子树
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode != null && pNode == pNode.next.left){
            return pNode.next;
        } else if (pNode != null && pNode == pNode.next.right){
            while(pNode != null && pNode != pNode.next.left){
                pNode = pNode.next;
            }
            return pNode.next;
        } else {
            return pNode.next;
        }
    }

    public static void main(String[] args) {
        TreeNodeTest.Node node = new TreeNodeTest.Node(8);
        System.out.println();
    }
}
