#### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

```java
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。

提示：
1 <= nums.length <= 50000
1 <= nums[i] <= 10000
```



**答题思路：** 

```
1.看看代码不难理解，时间O(N) 空间O(1)
2.只有遍历到的nums[i]全为奇数时，p和i保持相同大小，如果遇到偶数元素，那么i直接跳过继续i++,而p则会停留在为偶数元素的位置上，这也是为什么要nums[i]和nums[p]互换，只有这样才能在一次遍历中把奇数元素位置的元素变为偶数。这个方法本质上和上一种方法一样，更简洁。
```



**答题代码：** 

```java
class Solution {
    public int[] exchange(int[] nums) {
        // 使用双指针，一个在前面找偶数，一个在后面找奇数
        // 一定要这样找吗？是的因为偶数要放在后面啊
        if(nums.length <= 1) return nums;
        int left = 0;
        int right = nums.length - 1;
        int temp = 0;
        // (nums[left] & 1) != 0  (两个相等)  (nums[left] & 1) == 1  
        // 与1相与不等于0就是奇数，既然是奇数自然往后找
        while(left < right){
            while(left < right && (nums[left] & 1) == 1) left++;
            while(left < right && (nums[right] & 1) != 1) right--;

            if(left < right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
```

```java
class Solution {
    public int[] exchange(int[] nums) {
        int p = 0;
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            if((nums[i]&1)==1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
        return nums;
    }
}
```



