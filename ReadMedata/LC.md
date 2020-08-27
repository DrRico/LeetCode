## 一、数组

### 第一题：[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

> 给定 nums = [2, 7, 11, 15], target = 9
>
> 因为 nums[0] + nums[1] = 2 + 7 = 9
>
> 所以返回 [0, 1]

- 思路：我感觉我这样子做应该有个大前提，就是数组中的元素不重复才行：
  我先使用一个HashMap将数据保存，数据为键、数据对应的下标设置为值，
  然后再使用一个for循环去比较target减去当前值后得到的值，是否包含在map中，
  要是包含则取出值对应的下标即可，详情请看代码：

```java
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i ++){
            // 这个判断最关键的是后面的&&，因为题目说了一个数只能使用一次
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }

        }
        return res;
    }
}
作者：drrico
链接：https://leetcode-cn.com/problems/two-sum/solution/shi-yong-hashmapde-zuo-fa-by-drrico/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```





### 第2题：[4. 寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。你可以假设 nums1 和 nums2 不会同时为空。

**示例 1:**

> ```
> nums1 = [1, 3]
> nums2 = [2]
> 
> 则中位数是 2.0
> ```

**示例 2:**

> ```
> nums1 = [1, 2]
> nums2 = [3, 4]
> 
> 则中位数是 (2 + 3)/2 = 2.5
> ```



- 思路一：合成一个大的数组，然后排序求解

```java
import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        double res;
        for (int i = 0; i < nums1.length; i ++){
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i ++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        if((nums1.length + nums2.length) % 2 == 0){
            // 偶数
            res = (list.get((nums1.length + nums2.length) >> 1) + list.get((nums1.length + nums2.length - 1) >> 1))  / 2.0;
        } else {
            res = list.get(nums1.length + nums2.length >> 1);
        }
        return res;
    }
}
```

### 第3题：[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

**说明：**你不能倾斜容器，且 *n* 的值至少为 2。

 ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

**示例：**

```
输入：[1,8,6,2,5,4,8,3,7]
输出：49
```

- 思路：

- 利用双指针即可完成
  - 具体做法：设置left为做指针，初始值为0；设置right 为右指针，初始值为height.length - 1；结果就等于sum = (right - left) * min(height[left], height[right]), 接着就移动指针，循环条件是right > left，并在退出循环后记录max(sum)即可，代码如下：

```java
class Solution {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0, maxSum = 0;
        while (right > left){
            sum = Math.min(height[left],height[right]) * (right - left);
            maxSum = Math.max(maxSum,sum);
            if (height[left] > height[right]){
                right --;
            } else {
                left ++;
            }
        }
        return maxSum;
    }
}
作者：drrico
链接：https://leetcode-cn.com/problems/container-with-most-water/solution/11-sheng-zui-duo-shui-de-rong-qi-shuang-zhi-zhen-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```









### 第4题：15. 三数之和，使用双指针解决

- 解题思路：
  还是使用双指针的思想，首先：
  1、给数组进行排序；
  2、遍历数组，从0到length-2到，因为有三个数，所以需要到length-2就可以了，
  3、如果当前的数字等于上一个数字，即num[i] == num[i-1]，那么跳过；
  4、如果数字不同，则设置start = i + 1,end = length - 1;并且判断i，start，end，三个数情况；当大于0，end --;当小于0，start ++;当等于0的时候，判断里面的两个while循环很关键,用于去重，并且把结果添加进结果数组中；
  5、返回结果数组。

- java代码如下：

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums)  {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int start , end;
        for (int i = 0; i < nums.length - 2; i ++){
            start = i + 1;
            end = nums.length - 1;
            if(i >= 1 && nums[i - 1] == nums[i])continue;
            while (start < end) {
                if ((nums[end] + nums[i] + nums[start]) > 0) {
                    end --;
                } else if ((nums[end] + nums[i] + nums[start]) < 0) {
                    start ++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(new ArrayList<>(list));
                    start ++;
                    end --;
                    // 以下两个while循环很重要
                    while (start < end && nums[start - 1] == nums[start]) start  ++;
                    while (start < end && nums[end + 1] == nums[end]) end  --;
                }
            }
        }
        return  res;
    }
}
```

###  第4题：[53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

**示例:**

```
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

**进阶:**

如果你已经实现复杂度为 O(*n*) 的解法，尝试使用更为精妙的分治法求解。

- 思路：使用动态规划进行求解，添加一个dp数据，记录了当前值和前面的值加上当前值的较大者，然后此时dp数组的最大值就是最大和的连续子数组的值；

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = Arrays.copyOf(nums,len);
        for (int i = 1; i < len; i ++){
            // 这步最重要，记录前面的值加上当前值和仅仅当前的值较大者
            dp[i] = Math.max(dp[i - 1]+nums[i], nums[i]);
        }
        int sum = dp[0];
        for (int i = 0; i < len; i ++){
            if (sum < dp[i]){
                sum = dp[i];
            }
        }
        return sum;
    }
}
```

### 华为笔试手撕代码-三个数的最大乘积解法-不需要排序

给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

**示例 1:**

```
输入: [1,2,3]
输出: 6
```

**示例 2:**

```
输入: [1,2,3,4]
输出: 24
```

注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

- 解题思路
  -  使用5个变量，三个来保存最大的值、两个来保存最小的值，结果无非是最小的两个值与最大的值之积、或者最大的三个数之积。
  -  请看Java代码实现：

```java
class Solution {
    public int maximumProduct(int[] a) {
        // 定义三个变量保存最大的三个数。
        int maxOne=Integer.MIN_VALUE;
        int maxTwo=Integer.MIN_VALUE;
        int maxThree=Integer.MIN_VALUE;
        // 两个最小负数
        int minOne=Integer.MAX_VALUE;
        int minTwo=Integer.MAX_VALUE;
        // 遍历一次数组，将各个合适的元素放到对应的位置。
        for(int i=0;i<a.length;i++)  
        {
          if(maxOne<a[i])  {
             maxThree=maxTwo;
             maxTwo=maxOne;
             maxOne=a[i];
          } else {
             if(maxTwo<a[i])  {
                maxThree=maxTwo;
                maxTwo=a[i];
             } else  {
                if (maxThree<a[i]) {
                  maxThree=a[i];
                }
             }
          }
          // 求两个最小负数。
          if(minOne>a[i])  {
             minTwo=minOne;
             minOne=a[i];
          } else  {
             if(minTwo>a[i]) {
                minTwo=a[i];
             }
          }
         
        }
        int maxMulipty=maxOne*maxTwo*maxThree;
        int minMulipty=minOne*minTwo*maxOne;
        return maxMulipty>minMulipty?maxMulipty:minMulipty;
    }
}
作者：drrico
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/628-san-ge-shu-de-zui-da-cheng-ji-jie-fa-bu-xu-yao/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

### 华为笔试手撕代码-[43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings/)

给定两个以字符串形式表示的非负整数 `num1` 和 `num2`，返回 `num1` 和 `num2` 的乘积，它们的乘积也表示为字符串形式。

示例 1:

`输入: num1 = "2", num2 = "3"`
`输出: "6"`

示例 2:

`输入: num1 = "123", num2 = "456"`
`输出: "56088"`
说明：

`num1 和 num2 的长度小于110。`
`num1 和 num2 只包含数字 0-9。`
`num1 和 num2 均不以零开头，除非是数字 0 本身。`
`不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。`

>  **思路：**

                            1   2   3
                        乘  4   5   6
                    ————————————————————
                            6   12  18
                        5   10  15
                    4   8   12
                    ————————————————————
                    4   13  28  27  18
             之后对[ 4   13  28  27  18]处理：
             整理： c[i - 1] += c[i] / 10,
                   c[i] %= 10, 从低位（数组的高位）开始。
                    step 0: 4   13  28  27  18
                    step 1: 4   13  28  28  8
                    step 2: 4   13  30  8   8
                    step 3: 4   16  0   8   8
                    step 4: 5   6   0   8   8

- Java代码实现：

```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) { // 对0的判断
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();     //统计数组长度
        int newlen = len1 + len2;
        int[] num = new int[newlen];                     //建立结果数组

        for(int i=len1-1;i>=0;i--){		// 每个个位数的相乘，不进位法
            int n1 = num1.charAt(i) - '0';
            for(int j=len2-1;j>=0;j--){
                int n2 = num2.charAt(j) - '0';
                num[i+j+1] += n1*n2;
            }
        }
        for(int i = newlen - 1; i > 0; i--)// 对每个数进行处理，进位取模等
        {
            num[i-1] += num[i] / 10;
            num[i] = num[i] % 10;
        }
        String s = "";	// 拼接成合法是字符数字
        int i = newlen - 1,j=0;
        if(num[0] == 0 && i>0)j++;
        for(;j<=i;j++){
            s += num[j];
        }
        return s;
    }
}
```

### 华为笔试手撕代码-[7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

```
示例 1:
输入: 123
输出: 321
示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
```

- 思路：本题如果不考虑溢出问题，是非常简单的。解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。
- 由于字符串转换的效率较低且使用较多库函数，所以解题方案不考虑该方法，而是通过数学计算来解决。
- 通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
- 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
- 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
  - 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
  - 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
- 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
  - 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
  - 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数

> - Java代码实现：

```java
class Solution {
    public static int reverse(int n) {
        int res = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        int minValue = Integer.MIN_VALUE / 10;
        while (n != 0) {
            int pop = n % 10;
            if (res > maxValue || (res == maxValue && pop > 7)) 
                return 0;
            if (res < minValue || (res == minValue && pop < -8)) 
                return 0;
            res = res * 10 + pop;
            n /= 10;
        }
        return res;
    }
}
```





### 第五题-1： [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

**示例 1:**

```输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
```

**示例 2:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

- 思路一：

> 使用双层for循环，判断每个元素与当前数相减，取最大者。O（n^2）,不是好的解法，不行的。

- 思路二：

> **使用单层for循环即可，当遍历到i的时候，将前面i-1个数中最小值与i相减即可。**

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i ++){
            if (min > prices[i]){
                min = prices[i]; // 保存遍历过的最小的值
            } else if (prices[i] - min > sum){
                sum = prices[i] - min; // 符合条件则更新利润的值
            }
        }
        return sum;
    }
}
```

- 思路三：

> 强行使用单调栈：
>
> - 在 prices 数组的末尾加上一个 哨兵👨‍✈️(也就是一个很小的元素，这里设为 0))，就相当于作为股市收盘的标记(后面就清楚他的作用了)
> - 假如栈空或者入栈元素大于栈顶元素，直接入栈
> - 假如入栈元素小于栈顶元素则循环弹栈，直到入栈元素大于栈顶元素或者栈空
> - 在每次弹出的时候，我们拿他与买入的值(也就是栈底)做差，维护一个最大值。

```java
public int maxProfit(int[] prices) {
        int[] prices2 = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            prices2[i] = prices[i];
        }
        prices2[prices.length] = -1; //哨兵, 保证所有的元素出栈

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < prices2.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= prices2[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                ans = Math.max(ans, top - stack.peekLast()); // 出栈时栈顶减去栈底元素
            }
            stack.push(prices2[i]);
        }
        return ans;
    }
```

###第五题-2 [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

**注意：**你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
```

**示例 2:**

```
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
```

**示例 3:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

**提示：**

```java
1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i] <= 10 ^ 4
```

**解题的方法：**

- 简单的一次遍历。我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值。
- 最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。这种方法将简化解决方案。

- 这个例子可以更清楚地展现上述情况：[1, 7, 2, 3, 6, 7, 6, 7]与此数组对应的图形是：

![Profit Graph](https://pic.leetcode-cn.com/6eaf01901108809ca5dfeaef75c9417d6b287c841065525083d1e2aac0ea1de4-file_1555699697692)

从上图中，我们可以观察到 A+B+C*A*+*B*+*C* 的和等于差值 D*D* 所对应的连续峰和谷的高度之差。

- java代码如下：

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
```

### 第六题：[238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)（乘积数组）

给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

**示例:**

```
输入: [1,2,3,4]
输出: [24,12,8,6]
```

**提示：**题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

**说明:** 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

**进阶：**你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

---------------

- 思路：

- 根据题目描述，如果可以使用除法，就很简单。但是要求不能使用。

- 假设：
  `left[i] = A[0]*...*A[i-1]`
  `right[i] = A[i+1]*...*A[n-1]`

- 所以：
  `B[i] = left[i] * right[i]`

- 这样就避免使用了除法。但是如果对每个B[i], 0<=i<n,都这么求，显然时间复杂度太高。

  我们把整个结果画到下面图：



![图片说明](https://uploadfiles.nowcoder.com/images/20200506/284295_1588756073632_8F528B3C1F44C5BD5ED7012E809F9A49)

- 可知：
  `left[i+1] = A[0]*...A[i-1]*A[i]`
  `right[i+1] = A{i+2]*...*A[n-1]`

- 于是，
  `left[i+1] = left[i] * A[i]`
  `right[i] = right[i+1] * A[i+1]`

- 所以，我们可以先把所有的left[i]求出，right[i]求出。代码如下：

```java
class Solution {
    public int[] productExceptSelf(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for(int i = 1; i < len; i++){
            B[i] = B[i-1] * A[i-1];    //left[i]用B[i]代替
        }
        int temp = 1;
        for(int j = len -2; j>=0; j--){
            temp *= A[j+1];            // right[i]用tmp代替
            B[j] *= temp;
        }
        return B;
    }
}
```

### 第七题：[561. 数组拆分 I](https://leetcode-cn.com/problems/array-partition-i/)

给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

示例 1:

```
输入: [1,4,3,2]
输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).

提示:
n 是正整数,范围在 [1, 10000].
数组中的元素范围在 [-10000, 10000].
```

- 思路：先排序，然后隔一个取一个数据即可；

```java
import java.util.*;
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2 ){
            sum += nums[i];
        }
        return sum;
    }
}
```

































