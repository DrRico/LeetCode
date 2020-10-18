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

### 第四题：[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png)

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

**示例:**

```
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
```

- 思路一：先找到最大值，然后往两边遍历，遍历的过程还需要一直带有递归求解

- java代码

```java
public static int left(int mid, int[] height) {
        if (mid == 0) {
            return 0;
        }
        // 依次找左侧最高点
        int index = mid - 1;
        int max = 0;
        int idx = 0;
        for (; index >= 0; index--) {// 继续求最大值
            if (height[index] >= max) {
                max = height[index];
                idx = index;
            }
        }

        // 求总面积
        int area = max * (mid - (idx + 1));

        int pillars = 0;
        int i = idx + 1;
        for (; i < mid; i++) { // 求石头部分，即数组中非空的部分
            pillars += height[i] * 1;
        }
        int water = (area - pillars) + left(idx, height);  // 求有效面积
        return water;
    }


    public static int right(int mid, int[] height) {
        if (mid == height.length - 1) {
            return 0;
        }
        // 依次找左侧最高点
        int index = mid + 1;
        int max = 0;
        int idx = 0;
        for (; index < height.length; index++) {// 继续求最大值
            if (height[index] >= max) {
                max = height[index];
                idx = index;
            }
        }
        // 求总面积
        int area = max * ((idx - 1) - mid);

        int pillars = 0;
        int i = idx - 1;
        for (; i > mid; i--) { // 求石头部分，即数组中非空的部分
            pillars += height[i] * 1;
        }
        int water = (area - pillars) + right(idx, height); // 求有效面积
        return water;
    }


    public static int trap_left_right(int[] height){
        int len = height.length;
        if (len <= 2) return 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }

        }
        int left = left(index,height);
        int right = right(index,height);


        return left + right;
    }
```

- 思路二：动态规划
- ![trapping_rain_water.png](https://pic.leetcode-cn.com/53ab7a66023039ed4dce42b709b4997d2ba0089077912d39a0b31d3572a55d0b-trapping_rain_water.png)

- java实现：

```java
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int res = 0;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        int max = 0;
        // 从左边遍历的最大值
        for (int i = 0; i < len; i++) {
            if (max <= height[i]){
                max = height[i];
            }
            leftArr[i] = max;
        }
        // 从右边遍历的最大值
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (max <= height[i]){
                max = height[i];
            }
            rightArr[i] = max;
        }
// 求出有效值，有效值（雨水）= min(leftArr[i],rightArr[i]) - 石头部分(height[i])
        for (int i = 0; i < len; i++) {
            res += Math.min(leftArr[i],rightArr[i]) - height[i];
        }
        return res;
    }
}
```

- 思路三：使用栈：

```java
   //方法 3：栈的应用
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
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

- 思路：先排序，然后隔一个取一个数据即可；[证明](https://leetcode-cn.com/problems/array-partition-i/solution/minshu-dui-bi-shi-you-xu-shu-lie-shang-xiang-lin-y/)

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

### 第八题-1：[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

​	给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

​	求在该柱状图中，能够勾勒出来的矩形的最大面积。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram.png)

​	以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 `[2,1,5,6,2,3]`。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram_area.png)

​	图中阴影部分为所能勾勒出的最大矩形面积，其面积为 `10` 个单位。

**示例:**

```
输入: [2,1,5,6,2,3]
输出: 10
```

- 解法一：暴力法。
  - 首先遍历每个数据，判断左边和右边的数是不是大于等于当前数，要是符合条件继续向两边遍历，当不满足条件的时候，则计算左右的宽度乘以当前数据的高度。保存每个最大乘积即可。

```java
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }
}
```

- 解法二：

- 1、单调栈分为单调递增栈和单调递减栈
  - 1.1单调递增栈即栈内元素保持单调递增的栈
  - 1.2同理单调递减栈即栈内元素保持单调递减的栈

- 2、操作规则（下面都以单调递增栈为例）
  - 2.1、如果新的元素比栈顶元素大，就入栈
  - 2.2、如果新的元素较小，那就一直把栈内元素弹出来，直到栈顶比新元素小

- 3、加入这样一个规则之后，会有什么效果
  - 3.1、栈内的元素是递增的
  - 3.2、当元素出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素

> [2,1,5,6,2,3]
>
> 举个例子，配合上面，设现在索引在 6 ，栈里是 1 5 6 。
>
> 接下来新元素是 2 ，那么 6 需要出栈。
>
> 当 6 出栈时，右边 2 代表是 6 右边第一个比 6 小的元素。
>
> 当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素
>
> 当 6 出栈时，5 成为新的栈顶，那么 5 就是 6 左边第一个比 6 小的元素。

- C++代码模板

```c++
stack<int> st;
for(int i = 0; i < nums.size(); i++)
{
	while(!st.empty() && st.top() > nums[i])
	{
		st.pop();
	}
	st.push(nums[i]);
}
```

- 画图理解

![图片.png](https://pic.leetcode-cn.com/7e876ae756613053b3432cebc9274e9dbdaafd2e6b8492d37fc34ee98f7655ea-%E5%9B%BE%E7%89%87.png)

-  **思路**
  - 1、对于一个高度，如果能得到向左和向右的边界
  - 2、那么就能对每个高度求一次面积
  - 3、遍历所有高度，即可得出最大面积
  - 4、使用单调栈，在出栈操作时得到前后边界并计算面积

```java
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 对特殊条件的判断
        if (len == 0) return 0;
        if (len == 1) return heights[0];      
		// 使原始数据[2,1,5,6,2,3]变成[0,2,1,5,6,2,3,0]的形式
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        // System.arraycopy(heights, 0, newHeights, 1, len);
        for (int i = 0; i < len; i ++){
            newHeights[i + 1] = heights[i];
        }
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;
		// 使用Deque<>代替Stack<>，底层基于ArrayDeque，所有操作加后加上Last，如
        // add() -> addLast() ;  peek() -> peekLast()等
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        int res = 0;	// 保存最大者
        for (int i = 1; i < len; i ++){ // for循环从1开始
            // 当新来的元素比栈顶元素大，则将下标插入，stack.addLast(i)，小则进入循环
            while(heights[i] < heights[stack.peekLast()]){
                // 保存当前栈顶元素的数据
                int curH = heights[stack.pollLast()];
                // 获取宽度，即当前元素左边的下标
                int curW = i - stack.peekLast() - 1;
                // 计算面积，保存最大者
                res = Math.max(res, curH * curW);
            }
            stack.addLast(i); // 当新来的元素比栈顶元素大，则将下标插入
        }
        return res;// 返回最大者
    }
}
```

### 第八题-2：[85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

**示例:**

```
输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
```

- **解法一：暴力破解**

  - 遍历每个点，求以这个点为矩阵右下角的所有矩阵面积。如下图的两个例子，橙色是当前遍历的点，然后虚线框圈出的矩阵是其中一个矩阵。

  ![image.png](https://pic.leetcode-cn.com/28f7b0ae6d95bba9f81ef0236f7448d030cc484453de077a05c5436b557cf223-image.png)
  - 怎么找出这样的矩阵呢？如下图，如果我们知道了以这个点结尾的连续 1 的个数的话，问题就变得简单了。

  ![image.png](https://pic.leetcode-cn.com/59a6f3369ea805a02e2fc2ec1ca3aeedceba54825dd5b75775cf740a6db85811-image.png)

  - 首先求出高度是 1 的矩形面积，也就是它自身的数，如图中橙色的 4，面积就是 4。
  - 然后向上扩展一行，高度增加一，选出当前列最小的数字，作为矩阵的宽，求出面积，对应上图的矩形框。
  - 然后继续向上扩展，重复步骤 2。
  - 按照上边的方法，遍历所有的点，求出所有的矩阵就可以了。

```java 
public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
        return 0;
    }
    //保存以当前数字结尾的连续 1 的个数
    int[][] width = new int[matrix.length][matrix[0].length];
    int maxArea = 0;
    //遍历每一行
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[0].length; col++) {
            //更新 width
            if (matrix[row][col] == '1') {
                if (col == 0) {
                    width[row][col] = 1;
                } else {
                    width[row][col] = width[row][col - 1] + 1;
                }
            } else {
                width[row][col] = 0;
            }
            //记录所有行中最小的数
            int minWidth = width[row][col];
            //向上扩展行
            for (int up_row = row; up_row >= 0; up_row--) {
                int height = row - up_row + 1;
                //找最小的数作为矩阵的宽
                minWidth = Math.min(minWidth, width[up_row][col]);
                //更新面积
                maxArea = Math.max(maxArea, height * minWidth);
            }
        }
    }
    return maxArea;
}
```

时间复杂度：O（m²n）。

空间复杂度：O（mn）。

- **解法二：借助上一题的思路，使用栈**

![image.png](https://pic.leetcode-cn.com/aabb1b287134cf950aa80526806ef4025e3920d57d237c0369ed34fae83e2690-image.png)

- 算法有了，就是求出每一层的 heights[] 然后传给上一题的函数就可以了。利用上一题的栈解法。

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if(len == 0) return 0;
        int height = matrix[0].length;
        int[][] temp = new int[len][height];
        int res = 0;
        for (int i = 0; i < len; i ++){
            for (int j = 0; j < height; j ++){
                if(matrix[i][j] == '1'){
                    if (i == 0){
                        temp[i][j] = 1;// i = 0第一层的情况，赋值为1
                    } else {
                        temp[i][j] = temp[i - 1][j] + 1; // 将上一层的数，加上1，得到本层当前的值
                    }
                }
            }
            // 遍历完一层之后，将这一层一维数组传递进去
            res = Math.max(res,largestRectangleArea(temp[i]));
        }
        return res;
    }
// 84题的函数，只需要将每一层的一维数组传递进来即可。
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int[] arr = new int[2 + len];
        arr[0] = 0;
        for (int i = 0; i < len; i ++){
            arr[i + 1] = heights[i];
        }
        len = len + 2;
        arr[len - 1] = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>(len);
        stack.addLast(0); // 哨兵
        int maxSum = 0;
        for (int i = 1; i < len; i ++){
            while (arr[i] < arr[stack.peekLast()]){
                int curH = arr[stack.pollLast()];
                int curW = i - stack.peekLast() - 1;
                maxSum = Math.max(maxSum, curH * curW);
            }
            stack.addLast(i);
        }
        return maxSum;
    }
}
```

### 第九题：[169. 多数元素](https://leetcode-cn.com/problems/majority-element/)

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1:**

```
输入: [3,2,3]
输出: 3
```

**示例 2:**

```
输入: [2,2,1,1,1,2,2]
输出: 2
```

- 思考：多数元素只会存在一个，因出现的次数一旦大于 ⌊ n/2 ⌋ ，就不能满足第二个数也这样了。
- 使用两个数保存数组中的元素res和对应出现的次数time，在进行遍历的时候判断res是否等于array的元素，若相等，则对time+1，若不等，则time-1，当time==0时，则将res替换为当前的元素，并赋值time=1，直到遍历结束，此时保存的res应该就是最终结果了，再来个for循环验证一下即可。

```java
class Solution {
    public int majorityElement(int[] nums) {
        int time = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if(temp == nums[i]){
                time ++;
            } else {
                time --;
                if (time == 0){
                    time = 1;
                    temp = nums[i];
                }
            }
        }
// 题目明确规定会存在这样一个数，所以直接返回即可，若不确定是否存在，则应再加一个for循环进行判断的
        return temp;
    }
}
```



### 第十题：[66. 加一](https://leetcode-cn.com/problems/plus-one/)

 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

```
示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

```

- 思路

> *执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户*
>
> 内存消耗：38.2 MB, 在所有 Java 提交中击败了48.47%的用户*



- 思路就是要开辟一个新的数据，长度比原来的数组长度多1即可。

- 总的来说有三种情况：
  - 1、要是给最低位加上1，不产生进位，这个好办，直接返回+1后数组。
  - 2、要是给最低位加上1，产生进位，这个时候就进行进位的传递，即把本位置为零，高一位加1即可，要去判断最高位的0，去掉后返回即可；
  - 3、特殊情况，如99、9999、9999等数字，需要不断的处理进位即可。即当只要有一个不产生进位后，后面的直接不进行计算即可（代码break的作用）。

- java实现：

```java
import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length + 1];
        if(++digits[digits.length - 1] == 10){
            for (int i = 0;i < digits.length; i ++){
                temp[i + 1] = digits[i];
            }
        } else {
            return digits;  // 情况1
        }
        digits = temp;
        for (int i = digits.length - 1; i >= 0; i --){
            if(digits[i]>9){    // 因为是加上1而已，所以可以怎么去直接置位即可，
                digits[i] = 0;  // 若是加上其他的常数，使用取余和取模运算即可。
                digits[i - 1] ++;
            } else {    // 加速运算，只要有一个没有进位，后面的运算就可以跳过了
                break;
            }
        }
        if (digits[0] == 0){
            return Arrays.copyOfRange(digits,1,digits.length);// 情况二
        }
        return digits;  // 情况三
    }
}
```



### 第十一题：[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

给你两个有序整数数组 *nums1* 和 *nums2*，请你将 *nums2* 合并到 *nums1* 中*，*使 *nums1* 成为一个有序数组。

**说明:**

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

**示例:**

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```

- **思路：双指针 / 从后往前.**

  使用双指针的方式去解决问题：

![image.png](https://pic.leetcode-cn.com/358c5531639dff237d3a5b7d51d101f652d6409ff6a24f4ca601a277a4b859c5-image.png)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;		// 用于控制num1有效数据的指针
        int p2 = n - 1;		// 用于控制num2有效数据的指针
        int p3 = m + n - 1; // 用于控制num1尾部数据的指针
        while (p2 >= 0){
            if (p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3 --] = nums1[p1 --];
            } else {
                nums1 [p3 --] = nums2[p2 --];
            }
        }
    }
}
```

### 第十二题：[135. 分发糖果](https://leetcode-cn.com/problems/candy/)（奇安信笔试第二题）

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。你需要按照以下要求，帮助老师给这些孩子分发糖果：

- 每个孩子至少分配到 1 个糖果。
- 相邻的孩子中，评分高的孩子必须获得更多的糖果。

那么这样下来，老师至少需要准备多少颗糖果呢？

```
示例 1:
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。

示例 2:
输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
```

- 思路：取自力扣官方题解
- 在这种方法中，我们使用两个一维数组 left 和 right 。数组 left用来存储每名学生只与左边邻居有关的所需糖果数。也就是假设规则为：如果一名学生评分比他左边学生高，那么他应该比他左边学生得到更多糖果。类似的，right 数组用来保存只与右边邻居有关的所需糖果数。也就是假设规则为：如果一名学生评分比他右边学生高，那么他应该比他右边学生得到更多糖果。最后取两个数组的最大值最为新数组进行相加即可得到糖果的数量



- ![image.png](https://pic.leetcode-cn.com/8d1eb25bdea9343564a0a925a4b9007e62366795785feb112c4ab9c25bd95e0b-file_1559471526790)

```java
class Solution {
    public int candy(int[] num) {
        int[] left = new int[num.length];
        int[] right = new int[num.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        // 处理left
        for (int i = 1; i < num.length; i ++){
            if(num[i] > num[i - 1]) left[i] = left[i - 1] + 1;
        }
        // 处理right，同时计算出最大值
        int count = left[num.length - 1];
        for (int i = num.length - 2; i >= 0; i --){
            if(num[i] > num[i + 1])right[i] = right[i+1] + 1;
            count += Math.max(left[i],right[i]);
        }
        return count;
    }
}
```



--------

## 二、字符串

### 第一题：[5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

给定一个字符串 `s`，找到 `s` 中最长的回文子串。你可以假设 `s` 的最大长度为 1000。

```
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"
```

- 思路：

> 一：使用暴力解法的话，时间复杂度是O（n^3）,测试用例会不通过的

> 二：使用时间复杂度为O（n^2） 的方法**(中心扩散法)**，思路：遍历一个数，往两边扩散进行判断即可，分偶数和奇数的情况：

> 三：马拉车算法：使用马拉车算法可以优化技术和偶数判断的情况



- 思路二代码：**(中心扩散法)**

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;// 特殊条件的判断
        int res = 1;
        int left = 0;	// 记录左边界
        int right = 0;	// 记录右边界
        for (int i = 0; i < s.length(); i ++){
            // 判断偶数的情况
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l + 1;
                if(res < len){
                    res = len;
                    left = l;
                    right = r;
                }
                l --;
                r ++;
            }
            // 判断奇数的情况
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l + 1;// 获取当前长度
                if(res < len){// 更新最大回文子串的长度
                    res = len;
                    left = l;
                    right = r;
                }
                l --;
                r ++;
            }
        }
        return s.substring(left, right + 1);
    }
}

```

- 思路三代码：
- **第 1 步：定义状态**
  - `dp[i][j]`表示子串 `s[i..j] `是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，可以取到 s[i] 和 s[j]。
- **第 2 步：思考状态转移方程**
  - 在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
  - `dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]`
  - 说明：
    - 「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，因此，只需要填这张表格对角线以上的部分。
    - 看到 dp[i + 1][j - 1] 就得考虑边界情况。
  - 边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
  - 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
  - 如果子串 s[i + 1..j - 1] 只有 1 个字符，即去掉两头，剩下中间部分只有 11 个字符，显然是回文；
  - 如果子串 s[i + 1..j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
  - 因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，直接可以下结论，dp[i][j] = true，否则才执行状态转移。
- **第 3 步：考虑初始化**
  - 初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 true，即 dp[i][i] = true 。
  - 事实上，初始化的部分都可以省去。因为只有一个字符的时候一定是回文，dp[i][i] 根本不会被其它状态值所参考。
- **第 4 步：考虑输出**
  - 只要一得到` dp[i][j] = true`，就记录子串的长度和起始位置，没有必要截取，这是因为截取字符串也要消耗性能，记录此时的回文子串的「起始位置」和「回文长度」即可。
- **第 5 步：考虑优化空间**
  - 因为在填表的过程中，只参考了左下方的数值。事实上可以优化，但是增加了代码编写和理解的难度，丢失可读和可解释性。在这里不优化空间。
  - 注意事项：总是先得到小子串的回文判定，然后大子串才能参考小子串的判断结果，即填表顺序很重要。
  - 大家能够可以自己动手，画一下表格，相信会对「动态规划」作为一种「表格法」有一个更好的理解。
- **（动态规划）**

```java
public class Solution {

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
```

### 第二题：[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

```java
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
```

- 思路：先为题目选择合适的数据结构进行子字符串的保存：考虑到栈先入后出特点恰好与本题括号排序特点一致
- 判断括号的有效性可以使用「栈」这一数据结构来解决。
- 我们对给定的字符串 s 进行遍历，当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
- 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 ss 无效，返回False。为了快速判断括号的类型，我们可以使用哈希映射（HashMap）存储每一种括号。哈希映射的键为右括号，值为相同类型的左括号。
- 在遍历结束后，如果栈中没有左括号，说明我们将字符串 s 中的所有左括号闭合，返回 True，否则返回False。
- 注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程。

![20.gif](https://pic.leetcode-cn.com/baa8829ac398e665eb645dca29eadd631e2b337e05022aa5a678e091471a4913-20.gif)

- java实现

```java
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) return true;
        if (len % 2 != 0) return false; // 奇数情况直接返回false
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i ++){
            if (stack.isEmpty()){
                stack.addLast(arr[i]);
                continue;
            }
            if(isCorr(stack.peekLast(),arr[i])){
                stack.pollLast();
            } else {
                stack.addLast(arr[i]);
            }
        }
        return stack.isEmpty(); 
     }
     // 判断函数
     boolean isCorr(char i, char j){
         return (i == '[' && j == ']') || (i == '{' && j == '}') || (i == '(' && j == ')');
     }
}
```

### 第三题[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

```
示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。

请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

- 使用滑动窗口进行计算：请看java代码：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) return len;
        int left = 0;// 左指针初始位置
        int right = 0;// 右指针初始位置
        int maxSum = 0;
        Set<Character> set = new HashSet<Character>();
        
        while (left < len){// 先判断长度，再判断是否包含字符，避免越界
            // right初始位置是0，0号字符已被加入集合，从下一个字符开始计算
            while (right< len && !set.contains(s.charAt(right))){
                // 将字符添加进入，并且使right ++来滑动窗口
                set.add(s.charAt(right));
                right ++;
            }
            maxSum = Math.max(maxSum, right - left);// 取最大的值
            set.remove(s.charAt(left));// 删除第一个重复的值，
            left++; 	//并left++使窗口左边右移
        }
        return maxSum;
    }
}
```

### 第四题 -1：[22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

数字 *n* 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

 ```
示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 ```

- 思路一：采用DFS深度优先遍历

- 请看代码一：

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n,n,new StringBuilder(),res);
        return res;
    }
    void dfs(int left,int right, StringBuilder sb, List<String> res){
        // 截止条件
        if(left > right || left < 0 || right < 0)return;
        if (left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }
        // 候选节点
        sb.append("(");
        dfs(left - 1, right,sb,res);
        sb.deleteCharAt(sb.length() - 1); // 恢复现场
		// 候选节点
        sb.append(")");
        dfs(left, right - 1,sb,res);
        sb.deleteCharAt(sb.length() - 1); // 恢复现场
    }
}
```

- ![LeetCode 第 22 题：“括号生出”题解配图.png](https://pic.leetcode-cn.com/7ec04f84e936e95782aba26c4663c5fe7aaf94a2a80986a97d81574467b0c513-LeetCode%20%E7%AC%AC%2022%20%E9%A2%98%EF%BC%9A%E2%80%9C%E6%8B%AC%E5%8F%B7%E7%94%9F%E5%87%BA%E2%80%9D%E9%A2%98%E8%A7%A3%E9%85%8D%E5%9B%BE.png)思路二：还是采用DFS深度优先遍历
- 

- 请看代码二：

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);// 执行深度优先遍历，搜索可能的结果
        return res;
    }
    void dfs(int left, int right, String s, List<String> res){
    // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
    // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
// 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) { 
            return;
        }
        if (left > 0){
            dfs(left - 1, right, s + "(", res);
        }
        if (right > 0){
            dfs(left, right - 1, s + ")", res);
        }
    }
}
```

### 第四题 - 2: [46. 全排列](https://leetcode-cn.com/problems/permutations/)

给定一个 **没有重复** 数字的序列，返回其所有可能的全排列。

```
示例:

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

- 思路：DFS
- 判断截止条件
- 遍历候选节点

- java代码一：借助dp数组：判断是否已经遍历过

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
            if(!dp[i]){		// 2.1 判断候选节点
                dp[i] = true;
                chain.add(c);
                dfs(p,dp,chain,res);
                chain.remove(chain.size() - 1);
                dp[i] = false;
            }
        }
    }
}

```

- java代码二：可省略dp数组，用自身元素保存遍历的标志

```java
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(nums,new ArrayList(), res);
        return res;
    }
    void dfs(int[] nums,List<Integer> list, List<List<Integer>> res){
        // 1 截止条件
        if (nums.length == list.size()){
            res.add(new ArrayList(list));
            return;
        }
        // 2 遍历候选节点
        for (int i = 0; i < nums.length; i ++){
            int n = nums[i];
            if (nums[i] != 666666){	// 2.1 判断候选节点
                list.add(n);
                nums[i] = 666666;
                dfs(nums, list, res);
                nums[i] = n;
                list.remove(list.size() - 1);
            }
        }
    }
}
```

### 第四题 - 3 : [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

给定一个**无重复元素**的数组 `candidates` 和一个目标数 `target` ，找出 `candidates` 中所有可以使数字和为 `target` 的组合。

`candidates` 中的数字可以无限制重复被选取。

**说明：**

- 所有数字（包括 `target`）都是正整数。
- 解集不能包含重复的组合。 

```
示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 
提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
```

- 思路：能想到的也是DFS算法了

列出模板三部曲：

- 1、判断截止条件
- 2、遍历候选节点
  - 2.1、判断候选节点

有于题目中给出条件：`candidates` 中的数字可以无限制重复被选取。故2.1步可省略

- java代码实现

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        dfs(candidates,target,new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> res){
        if(target <= 0){
            if (target == 0){// 去重判断，排列再判断有没有存在即可
                ArrayList<Integer> tempList = new ArrayList<>(list);
                Collections.sort(tempList);
                if (!res.contains(tempList)) res.add(tempList);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i ++){
            list.add(candidates[i]);
            dfs(candidates,target - candidates[i],list,res);
            list.remove(list.size() - 1);
        }
    }
}
```

### 第五题：[1249. 移除无效的括号](https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/)

给你一个由 '('、')' 和小写字母组成的字符串 s。

你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。

请返回任意一个合法字符串。

有效「括号字符串」应当符合以下 任意一条 要求：

- 空字符串或只包含小写字母的字符串
- 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
- 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」

```
示例 1：
输入：s = "lee(t(c)o)de)"
输出："lee(t(c)o)de"
解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。

示例 2：
输入：s = "a)b(c)d"
输出："ab(c)d"

示例 3：
输入：s = "))(("
输出：""
解释：空字符串也是有效的

示例 4：
输入：s = "(a(b(c)d)"
输出："a(b(c)d)"
 
提示：
1 <= s.length <= 10^5
s[i] 可能是 '('、')' 或英文小写字母
```

> 思路:

这题其实非常简单，要移除无效的括号，那么只要找到所有无效的括号就行了。怎么找呢？方法类似于经典问题——"括号匹配"，用栈就可以很容易地解决，具体如下：

比如对于这样一个括号串 )(())(()，如果要找到不合法括号的位置，可以这样做：

- 首先，用一个flags组标记无效括号的索引，用一个栈存放所有遍历到的左括号的索引，

然后从前往后扫描这个串，对于第i个括号：

- 若为(，先进栈（栈中存的是下标）

- 若为)，这时先判断栈是否为空：
  - 若为空，说明右括号)在左括号(之前出现了，那显然是无效括号，即flags[i] = true；
  - 若不为空，那么这个右括号)和上一个出现的左括号(可以组成合法括号，就从栈中弹出一个元素，将其修正为合法的

- 当for循环完成之后，若stack非空则依次弹出栈中对应元素，并赋值给对应的flags数组标志为删除即可

- 最后遍历flags删除为true的元素即可

通过上述操作，我们可以记录下所有的无效括号的下标，再往后就很简单了。至此，就不难得出如下

- java代码：

```java
import java.util.*;
class Solution {
public String minRemoveToMakeValid(String s) {
        if (s.length() == 0) return s;
        boolean[] flags = new boolean[s.length()];		// 建立标志数组
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 建立栈
        for (int i = 0; i < s.length(); i ++){		// 循环遍历整个数组
            char ch = s.charAt(i);					
            if(ch == '('){			// 若为'('直接添加进入数组
                stack.addLast(i);
            } else if (ch == ')'){	// 若为')'
                if(stack.isEmpty()){  //且stack为非空，则为非法数组，待删除
                    flags[i] = true;
                }
                else {
                    stack.pollLast(); //若不为空，则栈中元素有与之匹配，则出栈即可
                }
            }
        }
    
        while (!stack.isEmpty()){	// 遍历一遍栈
            flags[stack.pollLast()] = true;		// 标记栈中所存下标，待删除	
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i --){
            if(flags[i]) sb.deleteCharAt(i);	// 删除不匹配的括号
        }
        return sb.toString();
    }
}
```

### 第六题：[49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

```
示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

- 思路：维护一个映射 ans : {String -> List}，其中每个键K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。

![Anagrams](https://pic.leetcode-cn.com/Figures/49/49_groupanagrams1.png)

```java
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        HashMap<String,List> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
```

### 第七题：[415. 字符串相加](https://leetcode-cn.com/problems/add-strings/)

给定两个字符串形式的非负整数 `num1` 和`num2` ，计算它们的和。

```java
提示：

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
```

- 思路：单个同一位进行相加，相加时先不进位；在第二轮遍历的时候处理进位问题即可，最后按照格式进行输出即可；

```java
class Solution {
	public String addStrings(String num1, String num2) {
        // 特殊条件判断；
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0) return num2;
        if (len2 == 0) return num1;
        // 建立新数组，只需要在原来最大数值上加1即可
        int maxLen = Math.max(len1,len2) + 1;
        // 建立新数组，将参数传入到新数组上
        int[] res = new int[maxLen];
        int[] resTemp = new int[maxLen];
        // 进行对其操作如 99 和  999
        // 令新数组为:  0099 和 0999
        int k = maxLen - 1;
        for (int i = len1 - 1; i >= 0; i --){
            res[k --] = num1.charAt(i) - '0';
        }
        k = maxLen - 1;
        for (int i = len2 - 1; i >= 0; i --){
            resTemp[k -- ] = num2.charAt(i) - '0';
        }
        // 进行同位相加，并且不进行进位处理
        int i = 0;
        while (i < maxLen){
            res[maxLen - 1 - i] += resTemp[maxLen - 1 - i];
            i ++;
        }
        // 进行进位处理
        for (int j = maxLen - 1; j >= 1 ; j --){
            res[j - 1] += res[j] / 10;
            res[j] %= 10;
        }
        // 按格式输出
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLen ; j ++){
            if (j == 0 && res[j] == 0) continue;
            sb.append(res[j]);
        }
        return sb.toString();
    }
}
```

- 或者采用双指针的形式：不提前补零的话，就要考虑缺位时怎么加，要在遍历时补0：

  

```java
class Solution {
public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (len1 >= 0 || len2 >= 0 || carry != 0){
            int n1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int n2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            len1 --;
            len2 --;
        }
        return sb.reverse().toString();
    }
}
```

### 第八题（难~）：[76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

**示例：**

```
输入：S = "ADOBECODEBANC", T = "ABC"
输出："BANC"
```

**提示：**

- 如果 S 中不存这样的子串，则返回空字符串 `""`。
- 如果 S 中存在这样的子串，我们保证它是唯一的答案。



> **思路：**滑动窗口

​		本问题要求我们返回字符串 s中包含字符串 t的全部字符的最小窗口。我们称包含 t 的全部字母的窗口为「可行」窗口。

​		我们可以用滑动窗口的思想去解决这个问题，在滑动窗口类型的问题中都会有两个指针。一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 ll 指针。在任意时刻，只有一个指针运动，而另一个保持静止。我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。

![](https://assets.leetcode-cn.com/solution-static/76/76_fig1.gif)

​		如何判断当前的窗口包含所有 t 所需的字符呢？我们可以用一个哈希表表示 t 中所有的字符以及它们的个数，用一个哈希表动态维护窗口中所有的字符以及它们的个数，如果这个动态表中包含 t 的哈希表中的所有字符，并且对应的个数都不小于 t 的哈希表中各个字符的个数，那么当前的窗口是「可行」的。

​		注意：这里 t 中可能出现重复的字符，所以我们要记录字符的个数。

```java
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        //ASCII表总长128
        int[] need = new int[128]; // t数组
        int[] have = new int[128]; // s数组
        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //分别为左指针，右指针，最小长度(初始值为一定不可达到的长度)
        //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0;
        int min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            //说明该字符不被目标字符串需要，此时有两种情况
            // 1.循环刚开始，那么直接移动右指针即可，不需要做多余判断
            // 2.循环已经开始一段时间，此处又有两种情况
            // 2.1上一次条件不满足，已有字符串指定字符出现次数不满足目标字符串指定字符出现次数，
            //    那此时如果该字符还不被目标字符串需要，就不需要进行多余判断，右指针移动即可
            // 2.2 左指针已经移动完毕，那么此时就相当于循环刚开始，同理直接移动右指针
            if (need[r] == 0) {
                right++;
                continue;
            }
            //当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            //是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要挨个比对字符出现的次数
            if (have[r] < need[r]) {
                count++;
            }
            //已有字符串中目标字符出现的次数+1
            have[r]++;
            //移动右指针
            right++;
            //当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                //挡窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                //如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                //如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                //就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    count--;
                }
                //已有字符串中目标字符出现的次数-1
                have[l]--;
                //移动左指针
                left++;
            }
        }
        //如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        //返回的为以记录的起始位置为起点，记录的最短长度为距离的指定字符串中截取的子串
        return s.substring(start, start + min);
    }
}
```

### 第九题：[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png)

```
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
```

- 思路：使用DFS进行解决即可
- java代码如下：

```java
import java.util.*;
class Solution {
    static char[][] m = {{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},{'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}}; //0和1是空的，值是从2开始
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(0,digits,new StringBuilder(),res);
        return res;
    }
    void dfs(int index, String s, StringBuilder sb,List<String> res){
         // 1、截止条件
        if(index == s.length()){
            res.add(sb.toString());
            return;
        }
         // 2、候选节点
        for(char c : m[s.charAt(index) - '0']){ //取二维数组中的值
            sb.append(c);  						//增加到数组
            dfs(index+1, s, sb, res);			// dfs
            sb.deleteCharAt(sb.length() - 1); 	// 恢复现场
        }
    }
}
```

### 第十题：[91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

一条包含字母 `A-Z` 的消息通过以下方式进行了编码：

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
```

- 思路：使用DP动态规划进行求解

![image.png](https://pic.leetcode-cn.com/c09dc70d3085792b2b8417843e297f6841fd12f921b0e4fe28a2c4a8dc86dd1e-image.png)

- Java代码：

```java
class Solution {
    public int numDecodings(String s) {
        // 特殊情况的判断
        int len = s.length();
        if (len == 0) return 0;
        int pre = 1, curr = 1;  // dp[-1] = dp[0] = 1
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        for (int i = 1; i < len; i++) {
            int tmp = curr;
            if (chars[i] == '0'){
                if (chars[i-1] == '1' || chars[i-1] == '2') curr = pre;
                else return 0;
            } else if (chars[i-1] == '1' || (chars[i-1] == '2' && chars[i] >= '1' && chars[i] <= '6')){
                curr += pre;
            }
             pre = tmp;
        }
        return curr;
    }
}
```







## 三、深度优先搜索BFS

### 第一题-1：[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

```java
示例 1:
输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1
    
示例 2:
输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
```

- **思路**：采用DFS深度优先搜索来进行解决
- **沉没：**通过DFS来控制小岛进行沉没，直到所有小岛沉没为止：
- **程序思路：**遍历一遍二维数组，当发现为小岛“1”的时候则进行**沉没**操作，沉没的方式判断数组是否为“1”，若为“1”则变成“0”即可，然后通过不断dfs进行判断上下左右的数组元素是否有效和判断越界等。

- java实现：

```java
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == '1'){// 进入沉没操作
                    dfs(grid,i,j);
                    res ++;
                }
            }
        }
        return res;
    }
    void dfs(char[][] chars,int i, int j){
        // 截止条件
        if (i < 0 || j <0 || i >= chars.length || j >= chars[0].length || chars[i][j] == '0'){
            return;
        }
        chars[i][j] = '0';
        dfs(chars,i + 1,j);
        dfs(chars,i,j + 1);
        dfs(chars,i - 1,j);
        dfs(chars,i,j - 1);
    }
}
```

### 第一题-2：[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

```
示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
   
返回它的最大深度 3
```

- 使用深度优先搜索算法以此递归下去即可。

>- 标签：DFS
>- 找出终止条件：当前节点为空
>- 找出返回值：节点为空时说明高度为 0，所以返回 0；节点不为空时则分别求左右子树的高度的最大值，同时加1表示当前节点的高度，返回该数值
>- 某层的执行过程：在返回值部分基本已经描述清楚
>- 时间复杂度O(n)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

### 第一题-3：[108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```

- 使用深度优先遍历的思想，其实就是递归进行下去，因为是二叉平衡搜索树，可知其中序遍历为排序数组，再分别处理左子树和右子树并递归下去即可

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return healper(0, nums.length - 1, nums);
    }
    public TreeNode healper(int i, int j, int[] nums){
        if (i > j) return null;	// 截止的条件
        int mid = (i + j) >> 1;	// 求中心下标的位置
        TreeNode node = new TreeNode(nums[mid]); // mid 为根节点
        node.left = healper(i, mid - 1, nums); 	 // 递归进行处理左子树
        node.right = healper(mid + 1, j, nums);	 // 递归进行处理右子树
        return node;
    }
}
```

### 第一题-4：[1382. 将二叉搜索树变平衡](https://leetcode-cn.com/problems/balance-a-binary-search-tree/)

给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。如果有多种构造方法，请你返回任意一种。

示例：

```
输入：root = [1,null,2,null,3,null,4,null,null]
输出：[2,1,3,null,null,null,4]
解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。

提示：
树节点的数目在 1 到 10^4 之间。
树节点的值互不相同，且在 1 到 10^5 之间。
```

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/15/1515_ex1.png"/>

<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/15/1515_ex1_out.png"/>

- 思路一：最优解思路和上一题一样的思路，只不过本题中给出的是一颗二叉搜索树而不是一个排序数组，很简单只需要将此二叉搜索树中序遍历出来，再进行重建即可；
- **利用二叉搜索树的性质，中序遍历输出，然后以中间为root，递归构造树**;

```java
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list); // 中序遍历构造有序链表
        return healper(list, 0, list.size() - 1);// 有序链表构造平衡二叉树
    }
    void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;	// 使用递归的方式中序遍历二叉树
        inorder(root.left, list);	// 左
        list.add(root.val);			// 根
        inorder(root.right, list);	// 右
    }
    public TreeNode healper(List<Integer> list, int i, int j){
        if (i > j) return null;		// 截止的条件
        int mid = (i + j) >> 1;		// 求中心下标的位置,中间节点为root
        TreeNode node = new TreeNode(list.get(mid));// mid 为根节点
        node.left = healper(list, i, mid - 1);		// 递归进行处理左子树
        node.right = healper(list, mid + 1, j);		// 递归进行处理右子树
        return node;
    }
}
```



### 第一题-5 ：

给定一个二叉树，判断它是否是高度平衡的二叉树。本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。



    示例 1:
    给定二叉树 [3,9,20,null,null,15,7]
    
    	3
       / \
      9  20
        /  \
       15   7
       
    返回 true 。


    示例 2:
    给定二叉树 [1,2,2,3,3,null,null,4,4]
    
       	   1
          / \
         2   2
        / \
       3   3
      / \
     4   4
     
     返回 false 。
- 思路：根据平衡二叉树的定义，伪代码如下：
  

```
if abs(高度(root.left) - 高度(root.right)) <= 1 and root.left 也是平衡二叉树 and root.right 也是平衡二叉树:
    print('是平衡二叉树')
else:
    print('不是平衡二叉树')
```

- 而且root.left 和 root.right **如何判断是否是二叉平衡树就和 root 是一样的了**，可以看出这个问题有明显的递归性。

- Java实现如下:

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;	// 要是数为空，是平衡二叉树
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) >= 2) return false; // 要是树的左子树和右子树的最大深度超过2，则不是平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);// 递归求左右子树是不是平衡二叉树
    }
    public int getDepth(TreeNode root){ // 求二叉树的最大深度   
        if (root == null) return 0;		// 为空则返回 0
        // 否则一直递归左子树和右子树求深度
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
```



### 第二题-1：[77. 组合](https://leetcode-cn.com/problems/combinations/)

给定两个整数 *n* 和 *k*，返回 1 ... *n* 中所有可能的 *k* 个数的组合。

示例:

```java
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

- 思路：使用回溯：其实组合和子集问题都可以抽象为一个树形结构，如下：

![77.组合.png](https://pic.leetcode-cn.com/1599530938-bWgopL-77.%E7%BB%84%E5%90%88.png)

可以看一下这个棵树，一开始集合是 1，2，3，4， 从左向右去数，取过的数，不在重复取。

第一取1，集合变为2，3，4 ，因为k为2，我们只需要去一个数就可以了，分别取，2，3，4， 得到集合[1,2] [1,3] [1,4]，以此类推。

如何在这个树上遍历，然后收集到我们要的结果集呢，用的就是回溯搜索法，可以发现，每次搜索到了叶子节点，我们就找到了一个结果。

分析完过程，我们来看一下 回溯算法的模板框架如下：

```java
dfs() {
    if (终止条件) {
        存放结果;
    }

    for (选择：选择列表（可以想成树中节点孩子的数量）) {
        递归，处理节点;
        dfs();
        回溯，撤销处理结果
    }
}
```

- 分析模板：
  - 什么是达到了终止条件，树中就可以看出，搜到了叶子节点了，就找到了一个符合题目要求的答案，就把这个答案存放起来。
  - 看一下这个for循环，这个for循环是做什么的，for 就是处理树中节点各个孩子的情况， 一个节点有多少个孩子，这个for循环就执行多少次。
  - 最后就要看这个递归的过程了，注意这个dfs就是自己调用自己，实现递归。一些同学对递归操作本来就不熟练，递归上面又加上一个for循环，可能就更迷糊了， 我来给大家捋顺一下。
  - 这个dfs其实就是向树的叶子节点方向遍历， for循环可以理解是横向遍历，dfs就是纵向遍历，这样就把这棵树全遍历完了。
  - 那么dfs就是一直往深处遍历，总会遇到叶子节点，遇到了叶子节点，就要返回，那么dfs的下面部分就是回溯的操作了，撤销本次处理的结果。

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, res);
        return res;
    }
    void dfs(int n, int k, int index, List<Integer> list, List<List<Integer>> res){
        // 截止条件
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        // 遍历候选节点
        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n; i ++){
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
```



### 第二题-2：[216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)

找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

```
说明：
所有数字都是正整数。
解集不能包含重复的组合。

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]

示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
```

- 思路和上一题相识的，请看Java代码：

```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k >= n) return res;
        dfs(n,k,1,new ArrayList(), res);
        return res;
    }
    void dfs(int n,int k, int index, List<Integer> list, List<List<Integer>> res){
        // 截止条件，当list的长度大于等于k或者list中的数和大于等于时进入
        if (list.size() >= k || 0 >= n){
            if(list.size() == k && 0 == n){//当满足条件说明符合要求，添加到结果
                res.add(new ArrayList(list));
            }
            return;
        }
        // 遍历候选节点
        for (int i = index; i <= 9; i ++){
            list.add(i);
            // 注意将n-i的i传进去，即累加各个值，i+1为遍历1-9的值
            dfs(n - i, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
```

### 第三题-3：[79. 单词搜索](https://leetcode-cn.com/problems/word-search/)

给定一个二维网格和一个单词，找出该单词是否存在于网格中。单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

- 示例:

```
board =[
  	['A','B','C','E'],
  	['S','F','C','S'],
  	['A','D','E','E']]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
```

- 提示：

```
board 和 word 中只包含大写和小写英文字母。
1 <= boa rd.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
```

- 思路：回溯算法实际上一个类似枚举的搜索尝试过程，也就是一个个去试，我们解这道题也是通过一个个去试，下面就用示例1来画个图看一下

![](https://pic.leetcode-cn.com/b13c34a26060e7eea8ba5001928bcf6972abc65df05eca3b5a29e5fc483b9a94-image.png)

- 我们看到他是从矩形中的一个点开始往他的上下左右四个方向查找，这个点可以是矩形中的任何一个点，所以代码的大致轮廓我们应该能写出来，就是遍历矩形所有的点，然后从这个点开始往他的4个方向走，因为是二维数组，所以有两个for循环，代码如下 

```java
public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //从[i,j]这个坐标开始查找
            if (dfs(board, words, i, j, 0))
                return true;
        }
    }
    return false;
}
```

- 这里关键代码是dfs这个函数，因为每一个点我们都可以往他的4个方向查找，所以我们可以把它想象为一棵4叉树，就是每个节点有4个子节点，而树的遍历我们最容易想到的就是递归，我们来大概看一下  

```java
boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    if (边界条件的判断) {
        return;
    }

    一些逻辑处理

    boolean res;
    //往右
    res = dfs(board, word, i + 1, j, index + 1)
    //往左
    res |= dfs(board, word, i - 1, j, index + 1)
    //往下
    res |= dfs(board, word, i, j + 1, index + 1)
    //往上
    res |= dfs(board, word, i, j - 1, index + 1)
    //上面4个方向，只要有一个能查找到，就返回true；
    return res;
}
```

- 最终的完整代码如下  

```java
public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //从[i,j]这个坐标开始查找
            if (dfs(board, words, i, j, 0))
                return true;
        }
    }
    return false;
}

boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
    //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
        return false;
    //如果word的每个字符都查找完了，直接返回true
    if (index == word.length - 1)
        return true;
    //把当前坐标的值保存下来，为了在最后复原
    char tmp = board[i][j];
    //然后修改当前坐标的值
    board[i][j] = '.';
    //走递归，沿着当前坐标的上下左右4个方向查找
    boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
    //递归之后再把当前的坐标复原
    board[i][j] = tmp;
    return res;
}

```

- 我自己的版本：

```java
class Solution {
    int n;
    int m;
    int w;
    char[] letters;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.w = word.length();
        this.letters = word.toCharArray();
        this.board = board;

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                boolean res = dfs(i,j,0);
                if (res) return true;
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int k){
        if (k >= w) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || letters[k] != board[i][j])return false;
        board[i][j] += 128;

        boolean res = dfs(i+1,j,k+1) || dfs(i,j+1,k+1) || dfs(i-1,j,k+1)  || dfs(i,j-1,k+1);

        board[i][j] -= 128;
        return res;
    }
}
```































































































