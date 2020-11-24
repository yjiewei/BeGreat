#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

```java
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    
示例:
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
 
限制：
0 <= s 的长度 <= 50000

```



**答题思路：** 

1.暴力计算 不考虑

2.哈希表存储 key-value （字符的ASCII码值对应的次数）

时间复杂度O(n)   空间复杂度O(1)

**答题代码：** 

```java
class Solution {
    public char firstUniqChar(String s) {
        // 用hash表完成
        int[] target = new int[256];
        for(char c : s.toCharArray()){
            target[(int)c]++;
        }
        for(char c : s.toCharArray()){
            if( target[(int)c] == 1 ) return c;
        }
        return ' ';
    }
}
```
