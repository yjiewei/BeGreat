## LeetCode Daily Challenge do it now!

### 12.27

#### [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/)

![image-20201227220809357](LeetCodeMould.assets/image-20201227220809357.png)



**答题思路：** 

```
有点像中文成语里面的AAB ABA这样的，比较两个字符串是否符合这样的结构。
这里用的是数组做hashmap，下标为字符的ASCII码值，值就是出现次数。次数是严格对应相等的，你细品。
时间复杂度是O(N)
空间复杂度是O(1)
```



**答题代码：** 

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 存放的是字符下标ASCII-i+1
        int[] preIndexofs = new int[256]; 
        int[] preIndexoft = new int[256];
        for(int i = 0;i<s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // 两个字符对应的ASCII  这里比的是上一个相同字符存放的值
            // 如果相同说明上一个我们对应的位置一样，现在也是一样
            if(preIndexofs[sc] != preIndexoft[tc]){
                return false;
            }
            // 不存在上一个相同的也是相等，都会到这一步
            preIndexofs[sc] = i+1;
            preIndexoft[tc] = i+1;
        }
        return true;
    }
}
```

