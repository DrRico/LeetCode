参考[此博客园](https://www.cnblogs.com/bjh1117/p/8335108.html)

## 一、概念：

**链表：**

　　一种重要的数据结构，HashMap等集合的底层结构都是链表结构。链表以结点作为存储单元，这些存储单元可以是不连续的。每个结点由两部分组成：存储的数值+前序结点和后序结点的指针。即有前序结点的指针又有后序结点的指针的链表称为双向链表，只包含后续指针的链表为单链表，本文总结的均为单链表的操作。



**单链表结构：**

![img](https://images2017.cnblogs.com/blog/701013/201801/701013-20180123121217006-1095368452.png)



Java中单链表采用Node实体类类标识，其中data为存储的数据，next为下一个节点的指针：

```java
package com.algorithm.link;
/**
 * 链表结点的实体类
 * @author Rico
 */
public class Node {
    Node next = null;//下一个结点
    int data;//结点数据
    public Node(int data){
        this.data = data;
    }
}
```



## 二、链表常见操作：

### 1、链表添加结点:

```java
/**
* 链表添加结点:
* 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
* @param data
*/
public void addNode(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode;
        return;
    }
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newNode;
}
```

对于插入节点常用的思想主要有**头插法** 和 **尾插法**，使用尾插法的话需要再定义一个尾指针来区分。下面可以通过对比讨论他们的不同：

![img](https://upload-images.jianshu.io/upload_images/8031371-67d2eba0881755c1.png?imageMogr2/auto-orient/strip|imageView2/2/w/1076/format/webp)

### 2、链表删除结点:

```java
/**
    * 链表删除结点:
    * 把要删除结点的前结点指向要删除结点的后结点，即直接跳过待删除结点
    * @param index
    * @return
    */
public boolean deleteNode(int index){
    if(index<1 || index>length()){//待删除结点不存在
        return false;
    }
    if(index == 1){//删除头结点
        head = head.next;
        return true;
    }
    Node preNode = head;
    Node curNode = preNode.next;
    // int i = 1;						//这里听说是2，不清楚
    int i = 2;
    while(curNode != null){
        if(i==index){//寻找到待删除结点
            preNode.next = curNode.next;//待删除结点的前结点指向待删除结点的后结点
            return true;
        }
        //当先结点和前结点同时向后移
        preNode = preNode.next;
        curNode = curNode.next;
        i++;
    }
    return true;
}
```

### 3、求链表的长度

```java
/**
* 求链表的长度
* @return
*/
public int length(){
    int length = 0;
    Node curNode = head;
    while(curNode != null){
        length++;
        curNode = curNode.next;
    }
    return length;
}
```

### 4、链表结点排序,并返回排序后的头结点:

```java
/**
* 链表结点排序,并返回排序后的头结点:
* 选择排序算法,即每次都选出未排序结点中最小的结点，与第一个未排序结点交换
* @return
*/
public Node linkSort(){
    Node curNode = head;
    while(curNode != null){
        Node nextNode = curNode.next;
        while(nextNode != null){
            if(curNode.data > nextNode.data){
                int temp = curNode.data;
                curNode.data = nextNode.data;
                nextNode.data = temp;
            }
            nextNode = nextNode.next;
        }
        curNode = curNode.next;
    }
    return head;
}
```

### 5、打印结点

```java
/**
* 打印结点
*/
public void printLink(){
    Node curNode = head;
    while(curNode !=null){
        System.out.print(curNode.data+" ");
        curNode = curNode.next;
    }
    System.out.println();
}
```

### 6、去掉重复元素:

```java
/**
     * 去掉重复元素:
     * 需要额外的存储空间hashtable，调用hashtable.containsKey()来判断重复结点
     */
public void distinctLink(){
    Node temp = head;
    Node pre = null;
    Hashtable<Integer, Integer> hb = new Hashtable<Integer, Integer>();
    while(temp != null){
        if(hb.containsKey(temp.data)){//如果hashtable中已存在该结点，则跳过该结点
            pre.next = temp.next;
        }else{//如果hashtable中不存在该结点，将结点存到hashtable中
            hb.put(temp.data, 1);
            pre=temp;
        }
        temp = temp.next;
    }
}
```

### 7、返回倒数第k个结点

```java
 /**
     * 返回倒数第k个结点,
     * 两个指针，第一个指针向前移动k-1次，之后两个指针共同前进，
     * 当前面的指针到达末尾时，后面的指针所在的位置就是倒数第k个位置
     * @param k
     * @return
     */
    public Node findReverNode(int k){
        if(k<1 || k>length()){//第k个结点不存在
            return null;
        }
        Node first = head;
        Node second = head;
        for(int i=0; i<k-1; i++){//前移k-1步
            first = first.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
```

### 8 、查找正数第k个元素

```java
/**
* 查找正数第k个元素
*/
public Node findNode(int k){
    if(k<1 || k>length()){//不合法的k
        return null;
    }
    Node temp = head;
    for(int i = 0; i<k-1; i++){
        temp = temp.next;
    }
    return temp;
}
```

### 9、反转链表

```java
/**
* 反转链表，在反转指针钱一定要保存下个结点的指针
*/
public void reserveLink(){
    Node curNode = head;//头结点
    Node preNode = null;//前一个结点
    while(curNode != null){
        Node nextNode = curNode.next;//保留下一个结点
        curNode.next = preNode;//指针反转
        preNode = curNode;//前结点后移
        curNode = nextNode;//当前结点后移
    }
    head = preNode;
}
```

### 10、反向输出链表，三种方式：

```java
/**
     * 反向输出链表，三种方式：
     * 方法一、先反转链表，再输出链表，需要链表遍历两次
     * 方法二、把链表中的数字放入栈中再输出，需要维护额外的栈空间
     * 方法三、依据方法2中栈的思想，通过递归来实现，递归起始就是将先执行的数据压入栈中，再一次出栈
     */
public void reservePrt(Node node){
    if(node != null){
        reservePrt(node.next);
        System.out.print(node.data+" ");
    }
}
```

### 11、寻找单链表的中间结点：

```java
/**
     * 寻找单链表的中间结点：
     * 方法一、先求出链表的长度，再遍历1/2链表长度，寻找出链表的中间结点
     * 方法二、：
     * 用两个指针遍历链表，一个快指针、一个慢指针，
     * 快指针每次向前移动2个结点，慢指针一次向前移动一个结点，
     * 当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置 
     */
public Node findMiddleNode(){
    Node slowPoint = head;
    Node quickPoint = head;
    //quickPoint.next == null是链表结点个数为奇数时，快指针已经走到最后了
    //quickPoint.next.next == null是链表结点数为偶数时，快指针已经走到倒数第二个结点了
    //链表结点个数为奇数时,返回的是中间结点；链表结点个数为偶数时，返回的是中间两个结点中的前一个
    while(quickPoint.next != null && quickPoint.next.next != null){
        slowPoint = slowPoint.next;
        quickPoint = quickPoint.next.next;
    }
    return slowPoint;
}
```

### 12、判断链表是否有环：

```java
/**
     * 判断链表是否有环：
     * 设置快指针和慢指针，慢指针每次走一步，快指针每次走两步
     * 当快指针与慢指针相等时，就说明该链表有环
     */
public boolean isRinged(){
    if(head == null){
        return false;
    }
    Node slow = head;
    Node fast = head;
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow){
            return true;
        }        
    }
    return false;
}
```

### 13 、返回链表的最后一个结点

```java
/**
* 返回链表的最后一个结点
*/
public Node getLastNode(){
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    return temp;
}
```

### 14 、在不知道头结点的情况下删除指定结点：

```java
/**
     * 在不知道头结点的情况下删除指定结点：
     * 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点
     * 1、如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
     * 2、如果删除的结点不是尾结点，则将其该结点的值与下一结点交换，然后该结点的指针指向下一结点的后续结点
     */
public boolean deleteSpecialNode(Node n){
    if(n.next == null){
        return false;
    }else{
        //交换结点和其后续结点中的数据
        int temp = n.data;
        n.data = n.next.data;
        n.next.data = temp;
        //删除后续结点
        n.next = n.next.next;
        return true;
    }
}
```

### 15、判断两个链表是否相交：

```java
/**
* 判断两个链表是否相交：
* 两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
*/
public boolean isCross(Node head1, Node head2){
    Node temp1 = head1;
    Node temp2 = head2;
    while(temp1.next != null){
        temp1 = temp1.next;
    }
    while(temp2.next != null){
        temp2 = temp2.next;
    }
    if(temp1 == temp2){
        return true;
    }
    return false;
}
```

### 16、如果链表相交，求链表相交的起始点：

```java
/**
* 如果链表相交，求链表相交的起始点：
* 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
* 2、求出两个链表长度之差：len=length1-length2
* 3、让较长的链表先走len步
* 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
*/
public Node findFirstCrossPoint(MyLinkedList linkedList1, MyLinkedList linkedList2){
    //链表不相交
    if(!isCross(linkedList1.head,linkedList2.head)){
        return null;
    }else{
        int length1 = linkedList1.length();//链表1的长度
        int length2 = linkedList2.length();//链表2的长度
        Node temp1 = linkedList1.head;//链表1的头结点
        Node temp2 = linkedList2.head;//链表2的头结点
        int len = length1 - length2;//链表1和链表2的长度差

        if(len > 0){//链表1比链表2长，链表1先前移len步        
            for(int i=0; i<len; i++){
                temp1 = temp1.next;
            }
        }else{//链表2比链表1长，链表2先前移len步
            for(int i=0; i<len; i++){
                temp2 = temp2.next;
            }
        }
        //链表1和链表2同时前移,直到找到链表1和链表2相交的结点
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}
```

## 三、DFS和BFS

### 牛客第27题

- 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

#### 解题思路：

- 1、截止条件
- 2、遍历候选节点
- 2.1、筛选候选节点

```java
void dfs(int[] p, boolean[] pb, StringBuilder sb, List<List<String>> res){
	//1 截止条件
	if(p.length == sb.legth()){
		res.add(sb.toString());
		return;
	}
	//2 遍历候选节点
	for(int i = 0; i < p.length; i ++){
		int c = p[i];
		if(!pb[i]){		//2.1 筛选候选节点
			pb[i] = true;
			sb.append(c);
			dfs(p, pb, sb, res);
			pb[i] = false;
			sb.delete(sb.length() - 1, length());
		}
	}
}

----------------------------------------------------------------------------
    
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str.equals("") || str.length()==0)return res;
        StringBuilder s = new StringBuilder(str);
        dfs(s,0,new StringBuilder(),res);
        return res;
    }
    void dfs(StringBuilder s,int index, StringBuilder sb, ArrayList<String> res){
        //判断
        if(s.length() == index){
            if(!res.contains(sb.toString())){
                res.append(sb.add(sb.toString()));
            }
            return;
        }
        for(int i = 0; i < s.length(); i ++){	//候选元素
            char c = s.charAt(i);
            if(c != '0'){		//判断是否被访问过
                s.setCharAt(i, '0');
                sb.a(c);
                dfs(s, index + 1, sb, res);
                sb.deleteCharAt(sb.length()-1);
                s.setCharAt(i, c);   
            }   
        }   
    }
}
1234567891011121314151617181920212223242526272829
```

### leetcode-17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9hc3NldHMubGVldGNvZGUtY24uY29tL2FsaXl1bi1sYy11cGxvYWQvb3JpZ2luYWxfaW1hZ2VzLzE3X3RlbGVwaG9uZV9rZXlwYWQucG5n?x-oss-process=image/format,png)
示例:

输入：“23”
输出：[“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

```java
import java.util.*;
class Solution {
    char[][] m = {{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'},   
    {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
    {'p', 'q', 'r', 's'},{'t', 'u', 'v'},
    {'w', 'x', 'y', 'z'}}; //0和1是空的，值是从2开始
    

    public List<String> letterCombinations(String str) {
        List<String> res = new ArrayList<>();
        if(str.equals("")){
            return res;
        }
        dfs(str,0,new StringBuilder(),res);
        return res;
    }

    void dfs(String str,int index,StringBuilder sb, List<String>res){
        // 1、截止条件
        if (index == str.length()){
            res.add(sb.toString());
            return;
        }
        // 2、候选节点
        for(char c : m[str.charAt(index) - '0']){
            sb.append(c);						//保存节点数据
            dfs(str,index + 1, sb, res);		//递归
            sb.deleteCharAt(sb.length() - 1);	//恢复现场
        }

    }

} 
123456789101112131415161718192021222324252627282930313233
```

### leetcode-39. 组合总和

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

- 所有数字（包括 target）都是正整数。
- 解集不能包含重复的组合。
  示例 1：

```
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
123456
```

示例 2：

```
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
1234567
```

提示：

```java
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
1234
---------------------------------------------------------------------------
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),res);
        return res;
    }
    void dfs(int[] c, int t, List<Integer> chaim, List<List<Integer>> res){
        //1、截止条件
        int s = sum(chaim);
        if(s >= t){
            if(s == t){
                List<Integer> tmp = new ArrayList<>(chaim);
                Collections.sort(tmp);
                if(!res.contains(tmp)){
                    res.add(tmp);
                }
            }
            return;
        }
        //2、候选节点
        for(int i = 0; i < c.length; i ++){
            int temp = c[i];
            chaim.add(temp);
            dfs(c, t, chaim,res);
            chaim.remove(chaim.size() - 1);
        }
    }
    int sum(List<Integer> a){
        int sum = 0;
        for(Integer t : a){
            sum += t;
        }
        return sum;
    }
}
123456789101112131415161718192021222324252627282930313233343536
执行结果：通过
执行用时：
189 ms
, 在所有 Java 提交中击败了
5.00%
的用户
内存消耗：
40.6 MB
, 在所有 Java 提交中击败了
5.20%
的用户
1234567891011
```

**可以看到上边的结果耗时比较久，这是因为有了这个求和的操作，我们可以省略求和，在dfs递归的参数上做文章**

```java
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),res);
        return res;
    }
    void dfs(int[] c, int t, List<Integer> chaim, List<List<Integer>> res){
        //1、截止条件
        if(0 >= t){
            if(0 == t){
                List<Integer> tmp = new ArrayList<>(chaim);
                Collections.sort(tmp);
                if(!res.contains(tmp)){
                    res.add(tmp);
                }
            }
            return;
        }
        //2、候选节点
        for(int i = 0; i < c.length; i ++){
            int temp = c[i];
            chaim.add(temp);
            dfs(c, t - temp, chaim,res);
            chaim.remove(chaim.size() - 1);
        }
    }
}

----------------------------------------------------------------------------

执行结果：通过
执行用时：
78 ms
, 在所有 Java 提交中击败了
5.00%
的用户
内存消耗：
40.3 MB
, 在所有 Java 提交中击败了
16.36%
的用户
1234567891011
```

### leetcode 46. 全排列

这题和牛客第27题很相似，只不过这里不是打印出来而是放到list中

给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

```

代码：

```java
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] dp = new boolean[nums.length];
        dfs(nums, dp, new ArrayList<Integer>(), res);
        return res;
    }
    void dfs(int[] p, boolean[]dp, List<Integer> chain, List<List<Integer>> res){
        //1 截止条件
        if(p.length == chain.size()){
            res.add(new ArrayList(chain));
            return;
        }
        //2 候选节点
        for(int i = 0; i < p.length; i++){
            int c = p[i];
            if(!dp[i]){
                dp[i] = true;
                chain.add(c);
                dfs(p,dp,chain,res);
                chain.remove(chain.size() - 1);
                dp[i] = false;
            }
        }
    }
}


执行用时：
1 ms, 在所有 Java 提交中击败了99.76%的用户
内存消耗：
39.9 MB, 在所有 Java 提交中击败了71.61%的用户

```

代码二：

```java
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), res);
        return res;
    }
    void dfs(int[] p, List<Integer> chain, List<List<Integer>> res){
        //1 截止条件
        if(p.length == chain.size()){
            res.add(new ArrayList(chain));
            return;
        }
        //2 候选节点
        for(int i = 0; i < p.length; i++){
            int c = p[i];
            if(p[i]!=65535){
                p[i] = 65535;
                chain.add(c);
                dfs(p,chain,res);
                p[i] = c;
                chain.remove(chain.size() - 1);
            }
        }
    }
}
```

去掉了标志数组之后，直接用传入的数组给某一个下标设置标志：

```java
执行用时：
2 ms, 在所有 Java 提交中击败了81.73%的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了48.51%的用户
123
```

### leetcode 47. 全排列2

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

```
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
1234567
```

### 解题思路

此DFS算法，关键是总结截止条件和候选节点！

### 代码

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        char[] p = new char[]{'(', ')'};
        int[] pb = new int[]{n, n};
        List<String> res = new ArrayList<>();
        dfs(n, p, pb, new StringBuilder(), res);
        return res;
    }
    void dfs(int n,char[] p, int[] pb, StringBuilder sb, List<String> res){
        //关键是截止条件和
        if(n*2 == sb.length()){
            res.add(new String(sb.toString()));
            return;
        }
        //总结候选节点；
        if(pb[0]>0){
            pb[0] --;
            sb.append(p[0]);
            dfs(n, p, pb, sb, res);
            sb.delete(sb.length() - 1, sb.length());
            pb[0] ++;
        }
        if(pb[1]>0 && pb[0] != pb[1]){
            pb[1] --;
            sb.append(p[1]);
            dfs(n, p, pb, sb, res);
            sb.delete(sb.length() - 1, sb.length());
            pb[1] ++;
        }
    }
}
12345678910111213141516171819202122232425262728293031
```

### LeetCode93题，IP地址复原

### 解题思路

还是使用DFS来做，只不过对候选元素的判断不同，不能大于256并且除了0本身之外不能以0开头。

### 代码

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.equals("") || s.length() < 4 || s.length() >12){
            return res;
        }
        dfs(s, -1, 1, new StringBuilder(), res);
        return res;
    }

    void dfs(String s, int index, int level, StringBuilder sb, List<String> res){
        //1 截止条件
        if(level == 5 || index == s.length() - 1){
            if(level == 5  && index == s.length() - 1){
                res.add(sb.toString().substring(0,sb.length() - 1));
            }
            return;
        }
        // 2 候选节点
        for(int i = 1; i < 4; i++){ // 只能截取1到3个字符
            if(index + i + 1 >= s.length() + 1){
                continue;
            }
            String x = s.substring(index + 1,index + i + 1);
            //if(x.equals(""))continue;
            //2.1 筛选候选节点
            int num = Integer.parseInt(x);
            if(num <= 255 && (x.equals("0") || !x.startsWith("0"))){
                int len = sb.length();
                sb.append(x+".");
                dfs(s, index + i, level + 1, sb, res);
                sb.delete(len, len + x.length() + 1);
            }
        }
    }
}
123456789101112131415161718192021222324252627282930313233343536
```

或者把level去掉

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.equals("") || s.length() < 4 || s.length() >12){
            return res;
        }
        dfs(s, -1, new StringBuilder(), res);
        return res;
    }

    void dfs(String s, int index, StringBuilder sb, List<String> res){
        //1 截止条件
        if(sb.length() == s.length() + 4 || index == s.length() - 1){//因为要是结果正确，会多出4个'.'
            if(sb.length() == s.length() + 4  && index == s.length() - 1){
                res.add(sb.toString().substring(0,sb.length() - 1));
            }
            return;
        }
        // 2 候选节点
        for(int i = 1; i < 4; i++){
            if(index + i + 1 >= s.length() + 1){
                continue;
            }
            String x = s.substring(index + 1,index + i + 1);
            //if(x.equals(""))continue;
            //2.1 筛选候选节点
            int num = Integer.parseInt(x);
            if(num <= 255 && (x.equals("0") || !x.startsWith("0"))){
                int len = sb.length();
                sb.append(x+".");
                dfs(s, index + i, sb, res);
                sb.delete(len, len + x.length() + 1);
            }
        }
    }
}
```











