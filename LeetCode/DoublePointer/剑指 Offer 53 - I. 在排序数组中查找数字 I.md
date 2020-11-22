#### [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

```java
统计排序数组中某个值出现次数。
```



**答题思路：** 可恶只用了一个变形我就不会了。。。

1.暴力

2.二分法这跟双指针其实一样吧

先找到最左边相等的值，再遍历计算个数

时间复杂度O(N)   空间复杂度O(1)



**答题代码：** 

```java
class Solution {
    public int search(int[] nums, int target) {
        // 返回的是出现次数
        // 1.先把暴力解法写出来，通过
        // if(nums.length == 0) return nums.length;
        // int times = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == target){
        //         times++;
        //     } else if(nums[i] < target){
        //         continue;
        //     } else if(nums[i] > target){
        //         break;
        //     }
        // }
        // return times;

        // 2.再用二分
        if(nums.length == 0) return nums.length;
        int times = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) right = mid;
            if(nums[mid] < target) left = mid + 1;
        }
        while(left < nums.length && nums[left] == target){
            left++;
            times++;
        }
        return times;
    }
}
```
