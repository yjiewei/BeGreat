#### [剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

```java
至少剪一次，剪完乘积最大。2 <= n <= 58
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```



**答题思路：** 

```
求最值，每个大的问题都可以化解成小的问题来解决。自下而上的解法直到n，数组最后一个就是我们要求的值，最后返回。时间复杂度是O(N2)空间复杂度是O(N)
```



**答题代码：** 

```java
class Solution {
    public int cuttingRope(int n) {
        // 至少要剪一次
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] products = new int[n+1]; // n+1 才能到n啊，第一个也就是下标为0是不存的呀。
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for(int i = 4; i <= n; i++){
            max = 0;
            for(int j = 1;j <= i/2;j++){
                int product = products[i-j]*products[j];
                if(max < product) max = product;
            }
            products[i] = max;
        }
        return max;
    }
}
```

