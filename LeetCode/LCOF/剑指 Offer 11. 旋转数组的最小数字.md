#### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

```java
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：
输入：[3,4,5,1,2]
输出：1
    
示例 2：
输入：[2,2,2,0,1]
输出：0
```



**答题思路：** 

```
从API使用层面直接前两行搞定，时间复杂度是O(NLOGN)，空间复杂度是O(1)
再者，就是二分法以及特殊情况处理，最快时间复杂度是O(LOGN)最坏就是O(N)，空间都是O(1)
特殊情况：全部重复、没有重复、空数组、数组中只有一个数以及最坑的情况：二分之后判断不了往前找还是往后找。
```



**答题代码：** 

```java
class Solution {
    public int minArray(int[] numbers) {
        // Arrays.sort(numbers);
        // return numbers[0];
        if(numbers.length == 0) return 0;
        if(numbers.length == 1) return numbers[0]; // 只存在一个值，怎么旋转都一样。
        int left = 0;
        int right = numbers.length - 1;
        int mid = left; // 防止没有旋转
        while(numbers[left] >= numbers[right]){
            if(right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left)/2;
            // 如果出现三个位置上的数相等的情况，如果不特殊处理，他只能默认一个是属于大数组的
            // 但是如果他不属于上半部分而是下半部分就会出现错误。
            if(numbers[left] == numbers[right] && numbers[mid] == numbers[left]){
                int result = numbers[left];
                for(int i = left + 1; i <= right; i++ ){
                    if(result > numbers[i]) result = numbers[i];
                }
                return result;
            } 
            if(numbers[mid] >= numbers[left]) left = mid;
            else if(numbers[mid] <= numbers[right]) right = mid;
        }
        return numbers[mid];
    }
}
```

