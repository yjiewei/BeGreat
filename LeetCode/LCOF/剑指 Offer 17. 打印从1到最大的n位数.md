#### [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

```java
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```



**答题思路：** 

```
用快速幂计算，找到最大值，也就知道了数组的大小，直接遍历数组并改变每一个的值。
```



**答题代码：** 

```java
class Solution {
    public int[] printNumbers(int n) {
        // 剑指书上写的可不是这个啊，书上的重点是大数会溢出的问题。
        // 这里直接变成int范围了
        int b = n;
        int x = 10;
        int result = 1;
        while(b != 0){
            if((b&1) == 1) result = result * x;
            b >>= 1;
            x *= x;
        }
        // 计算了10的n次方，也就是我们要打印的最大值我们已经知道了
        int[] num = new int[result-1];
        for(int i = 0; i < result-1; i++){
            num[i] = i+1;
        }
        return num;
    }
}
```

