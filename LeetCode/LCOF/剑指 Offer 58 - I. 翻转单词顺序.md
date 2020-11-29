#### [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

```java
前后空格都不要
输入: "the sky is blue"
输出: "blue is sky the"
    
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```





**答题思路：** 时间复杂度为O(N) 本质只需要遍历一次字符串即可；空间复杂度为O(N) 一个字符串。将每个单词翻转，然后将整个字符串翻转。

![img](https://pic.leetcode-cn.com/b0ad3cf17cb1c7ee3b99a851990c74445ab8468f95b86f682bec241d699db485-Picture5.png)



**答题代码：**

```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1;
        int i = j; // 从最后一个字母开始遍历
        StringBuilder res = new StringBuilder();
        while(i >= 0){
            // 找到从后面开始的第一个空格，也就是一个字符串的起始位置
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            // 目标字符串中加入这个字符串
            res.append(s.substring(i+1,j+1)+ " ");
            // 跳过目前找到的字符串前面的空格，找到下一次要循环的最后一个
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i; 
        }
        return res.toString().trim();// 转换为字符串并返回
    }
}
```

```python
class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip() # 删除首尾空格
        strs = s.split() # 分割字符串
        strs.reverse() # 翻转单词列表
        return ' '.join(strs) # 拼接为字符串并返回
    
    
#class Solution:
#    def reverseWords(self, s: str) -> str:
#        return ' '.join(s.strip().split()[::-1])
```

```java
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}
```

