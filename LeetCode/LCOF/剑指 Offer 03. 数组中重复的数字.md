#### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

```java
找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```



**答题思路：** 注意与面试官沟通需求。是否改变原数组，是否要求时间复杂度？

1.排序后遍历 底层是快排，时间复杂度是O(NlogN)  空间复杂度是O(N)

2.哈希存储之后遍历，时间复杂度是O(N) 空间复杂度是O(N) 这个没有改变原有数组

3.用题目提供的特点完成，效率最高吧，时间复杂度是O(N) 空间复杂度是O(1) 

**答题代码：** 

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 书里提供了三种方法，不过这题是随意返回一个数字就可以吗
        // 1.排序后遍历
        // Arrays.sort(nums);
        // for(int i = 1; i < nums.length; i++){
        //     if(nums[i] == nums[i-1]) return nums[i];
        // }
        // return -1;
        // 2.使用哈希表来存储，如果发现已经存在了就直接返回就可以了
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num : nums){
        //     if(map.get(num) == null){
        //         map.put(num,1);
        //     }else{
        //         return num;
        //     }
        // }
        // return -1;

        // 3.这个方法不知道起啥名，有种具体情况具体分析那味
        // 他主要利用的是数组下标和数组范围的特性来排序
        // 某个位置上的数字如何超过了下标，说明那个位置不属于他，已经出现过了
        for(int i = 0; i < nums.length; ++i){
            while(i != nums[i]){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
```
