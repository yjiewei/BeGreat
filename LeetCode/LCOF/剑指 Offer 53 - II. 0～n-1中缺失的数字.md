#### [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

```java
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
示例 1:
输入: [0,1,3]
输出: 2
    
示例 2:
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```



**答题思路：** 

```
暴力太慢了，最差的时候时间复杂度是o(n)就是遍历整个数组，空间是O(1)
二分查询，时间复杂度是O(logn) 空间复杂度是O(1)只用了两个变量。
```



**答题代码：** 

```java
class Solution {
    public int missingNumber(int[] nums) {
        // 递增，0~n-1 用二分？
        // 先来个暴力
        // for(int i = 0; i < nums.length; i++){
        //     if(i != nums[i]) return i;
        // }
        // return nums.length;
        
        // 使用二分法完成
        // 我本来还想在if里面加上最后一个else语句
        // 但是这里遍历到最后发现根本不存在mid>nums[mid]的情况，要么小要么相等
        // 最后结束条件是right < left ，而这个left就是我们要找的位置
        // 最后一个返回语句也是可以不要的，它其实已经涵盖在了循环里面，如果值都在，返回的是数组长度
        // 而循环里如果一直存在，left会一直增加直到超过right
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid == nums[mid]){
                left = mid+1;
            }else if(mid < nums[mid]){
                right = mid-1;
            }
        }
        if(right < left) return left;
        return nums.length;
    }
}
```

