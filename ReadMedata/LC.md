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

