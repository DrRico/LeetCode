package com.rico.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Rico_dds
 * @date 2020/8/7 9:55
 */
public class TreeNodeTest {

    public static class Node {
        private int value;        //节点的值
        private Node node;        //此节点，数据类型为Node
        private Node left;        //此节点的左子节点，数据类型为Node
        private Node right;       //此节点的右子节点，数据类型为Node
        private Node next;        //此节点的父节点，数据类型为Node

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int value) {
            this.value=value;
            this.left=null;
            this.right=null;
        }
        public String toString() {         //自定义的toString方法，为了方便之后的输出
            return this.value+" ";
        }
    }

    /**
     * 如果datas = {1,2,3,4,5,6,7};
     * 则二叉树为
     *                  1
     *                /  \
     *               2    3
     *             / \   / \
     *            4  5  6  7
     *
     */
    public  static void create(int[] datas, List<Node> list) {

        //将数组里面的东西变成节点的形式
        for(int i=0;i<datas.length;i++) {
            Node node=new Node(datas[i]);
            list.add(node);
        }

        //节点关联成树
        for(int index=0;index<list.size()/2-1;index++) {
            list.get(index).setLeft(list.get(index*2+1));
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            list.get(index).setRight(list.get(index*2+2));  //与上同理
        }

        //单独处理最后一个父节点 ,list.size()/2-1进行设置，避免单孩子情况
        int index=list.size()/2-1;
        list.get(index).setLeft(list.get(index*2+1));
        if(list.size()%2==1)
            //如果有奇数个节点，最后一个父节点才有右子节点
            list.get(index).setRight(list.get(index*2+2));

    }

    public static void preTraversal(Node node){
        if (node == null) //很重要，必须加上 当遇到叶子节点用来停止向下遍历
            return;
        System.out.print(node.getValue()+" ");
        preTraversal(node.getLeft());
        preTraversal(node.getRight());
    }

    public static void MidTraversal(Node node){
        if (node == null)
            return;
        MidTraversal(node.getLeft());
        System.out.print(node.getValue()+" ");
        MidTraversal(node.getRight());
    }

    public static void postTraversal(Node node){
        if (node == null)
            return;
        postTraversal(node.getLeft());
        postTraversal(node.getRight());
        System.out.print(node.getValue()+" ");
    }
    public static void preOrderTraversalbyLoop(Node node){
        // 我这里使用了栈这个数据结构，用来保存已经遍历过但是没有遍历完全的父节点
        // 之后再进行回滚。基本的原理就是当循环中的p不为空时，就读取p的值，并不断更
        // 新p为其左子节点，即不断读取左子节点，直到一个枝节到达最后的子节点，再继续返回上一层进行取值
        Stack<Node> stack = new Stack();
        Node p = node;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                //当p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点
                System.out.print(p.getValue()+" ");
                stack.push(p); //将p入栈
                p = p.getLeft();
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.getRight();
            }
        }
    }

    public static void midOrderTraversalbyLoop(Node node){
        Stack<Node> stack = new Stack<>();
        Node p = node;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p); //将p入栈
                p = p.getLeft();
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                System.out.print(p.getValue() + " ");
                p = p.getRight();
            }
        }
    }

    public static void postOrderTraversalbyLoop(Node node){
        Stack<Node> stack = new Stack<>();
        Node p = node;
        Node prev = node;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p); //将p入栈
                p = p.getLeft();
            }
            if(!stack.isEmpty()){
                Node temp = stack.peek().getRight();
                //只是拿出来栈顶这个值，并没有进行删除
                if(temp == null||temp == prev){
                    //节点没有右子节点或者到达根节点【考虑到最后一种情况】
                    p = stack.pop();
                    System.out.print(p.getValue()+" ");
                    prev = p;
                    p = null;
                }
                else{
                    p = temp;
                }
            }
        }
    }

    /**
     * 如果datas = {1,2,3,4,5,6,7};
     * 则二叉树为
     *                  1
     *                /  \
     *               2    3
     *             / \   / \
     *            4  5  6  7
     */
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7};
        ArrayList<Node> list = new ArrayList<>();
        create(data,list);
        System.out.println(list);
        preTraversal(list.get(0));
        System.out.println("----------前序-----------");
        preOrderTraversalbyLoop(list.get(0));
        System.out.println("-------非递归前序-----------");

        MidTraversal(list.get(0));
        System.out.println("----------中序-----------");
        midOrderTraversalbyLoop(list.get(0));
        System.out.println("-------非递归中序-----------");


        postTraversal(list.get(0));
        System.out.println("----------后序-----------");
        postOrderTraversalbyLoop(list.get(0));
        System.out.println("-------非递归后序-----------");

    }

}
