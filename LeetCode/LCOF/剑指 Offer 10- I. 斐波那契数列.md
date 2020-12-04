#### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

```java
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
```



**答题思路：** 

```
答案要取模。。
```



**答题代码：** 

```java
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int one = 0;
        int two = 1;
        for(int i = 2 ; i <= n; i++){
            two = one + two;
            one = two - one;
            two %= 1000000007;
        }
        return two;
    }
}
```

```java
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int one = 0;
        int two = 1;
        int sum = 0;
        for(int i = 2 ; i <= n; i++){
            sum = one + two;
            sum %= 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}
```

