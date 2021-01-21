#### [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

```java
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2

限制：
1 <= 数组长度 <= 50000
```



**答题思路：** 

```
1.第一种方法的时间复杂度比较高，用底层方法不推荐。
2.第二种用hash表存储出现次数，效率也比较低且空间复杂度是0(N)
3.推荐 第三种方法，时间和空间复杂度是O(N)
  摩尔投票法，你一票我一票，既然这样那就抵消，看最后一票是谁的。
```



**答题代码：** 

```java
class Solution {
    public int majorityElement(int[] nums) {
        // 常规套路以及摩尔投票法
        // 1.时间复杂度是O(nlogn)
        //Arrays.sort(nums);
        //return nums[nums.length / 2];

        // 2.降低时间复杂度，效率很低
        // HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
        // for(int num : nums){
        //     if(!map.containsKey(num)) map.put(num, 1);
        //     else map.put(num, map.get(num)+1);
        // }
        // int length = nums.length;
        // int res = 0;
        // for(int key : map.keySet()){
        //     if(map.get(key) > (length / 2)) {
        //         res = key;
        //         break;
        //     }
        // }
        // return res;

        // 3.摩尔投票法
        int mole = nums[0];
        int times = 0;
        for(int num : nums){
            if(mole == num) times++;
            else {
                times--;
                if(times == 0){
                    mole = num;
                    times++;
                }
            }
        }
        return mole;
    }
}
```

