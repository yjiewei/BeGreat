> 刚才做题发现一个关于integer的问题，两个integer值到底比较的是什么？
>
> 因为不清楚这个，浪费了至少大半个下午....实在不划算

### [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)

给定一个字符串 **s** 和一个非空字符串 **p**，找到 **s** 中所有是 **p** 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 **s** 和 **p** 的长度都不超过 20100。

**说明：**

- 字母异位词指字母相同，但排列不同的字符串。
- 不考虑答案输出的顺序。

**示例 1:**

```
输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
```

 **示例 2:**

```
输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
```

**解答：**

这道题是用滑动窗口来完成的，这是一种高级的双指针技巧，主要就是左右指针的区间作为一个窗口，不断重复查找符合要求的结果的一个过程。

嗯，这里不是要说这道题怎么解的，而且我也只是能看懂... 有兴趣的自己去LeetCode查一下题解。

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        // 相当于两个计数器，记录的是窗口和目标字符串
        Map<Character,Integer> window = new HashMap<Character,Integer>();
        Map<Character,Integer> needs = new HashMap<Character,Integer>();

        // 将目标字符串的字符添加在我们map（needs）里面
        for(int i = 0; i < p.length();i++){
            char c = p.charAt(i);
            needs.put(c,needs.getOrDefault(c,0)+1);
        }

        int match = 0;
        // 窗口一直滑动到最后，窗口会不包含非t字符
        while(right < s.length()){
            // 查看当前right位置字符是否是目标字符
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)){
                // 滑动窗口里面的数字+1
                window.put(c1,window.getOrDefault(c1,0)+1);
                // 如果字符map值是相等的说明满足要求了，后面如果还有相同的则不会让match增加
                if(window.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            // 继续移动
            right++;
            // 判断是否已经达到目标子串要求了                        
            while(match == needs.size()){
                // 如果window的大小合适，就把起始索引left加入结果
                if(right - left == p.length()){
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if(needs.containsKey(c2)){
                    window.put(c2,window.getOrDefault(c2,0)-1);
                    if(window.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
```

这道题我被坑的地方在于这里

```java
// 一开始我是这么写的，结果267 / 268 个通过测试用例
// 这说明什么？说明思路大体没问题，但是有些细节问题没有注意到
if(window.get(c1) == needs.get(c1)){
	match++;
}
// 后面改成以下这些答案，就能通过测试了
if(window.get(c1).equals(needs.get(c1))){
	match++;
}

if (window.get(c1).compareTo(needs.get(c1)) == 0)
    // 字符 c1 的出现次数符合要求了
    match++;

if(window.get(c1).intValue() == needs.get(c1)){
	match++;
}

if(window.get(c1).intValue() == needs.get(c1).intValue()){
	match++;
}

// 条条大路通罗马，唯独死路一条我走上，哎
```

### 为什么这里会出现这样的情况呢？

我之前看了很久这个代码，都不知道，感觉白学了....

但是后面我对比了一下别人写的代码，发现只有那个地方不一样，瞬间发现问题，果然就是integer值的问题，对于包裹类型还是一知半解，功力不够，谷歌来揍。

```java
public static void main(String[] args) {

    // 两个new出来的Integer类型的数据比较，相当于把new出来的地址作比较
    Integer a0 = new Integer(1);
    Integer a1 = new Integer(1);
    System.out.println("Integer 对象作比较 a0 == a1: " 
                       + (a0 == a1));

    // 调用intValue方法得到其int值
    System.out.println("使用intValue得到int值作比较 a0 == a1: " 
                       + (a0.intValue() == a1.intValue()));

    // 把Integer类型的变量拆箱成int类型
    int a2 = 1;
    System.out.println("将Integer自动拆箱 a1 == a2: " 
                       + (a1 == a2));

    // Integer对象赋值比较，其实也是内存地址的比较
    // 自动装箱，如果在-128到127之间，则值存在常量池中
    Integer a3 = 30;
    Integer a4 = 30;
    System.out.println("Integer对象赋值比较 a3 == a4: " 
                       + (a3 == a4));

    // Integer对象赋值(超过-128~127区间)比较
    Integer a5 = 128;
    Integer a6 = 128;
    System.out.println("Integer对象赋值(超过-128~127区间)比较 a5 == a6: " 
                       + (a5 == a6));

    // Integer对象赋值(超过-128~127区间)比较,调用intValue后再作比较
    Integer a7 = 128;
    Integer a8 = 128;
    System.out.println("Integer对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: " 
                       + (a7.intValue() == a8.intValue()));

    // 使用Integer类的equals()方法进行的是数值的比较
    Integer a9 = 129;
    Integer a10 = 129;
    System.out.println("Integer类的equals()方法进行的是数值的比较 a9 == a10: " 
                       + a9.equals(a10));
}
```

```
运行结果如下：
Integer 对象作比较 a0 == a1: false
使用intValue得到int值作比较 a0 == a1: true
将Integer自动拆箱 a1 == a2: true
Integer对象赋值比较 a3 == a4: true
Integer对象赋值(超过-128~127区间)比较 a5 == a6: false
Integer对象赋值(超过-128~127区间)比较,调用intValue后 a7 == a8: true
Integer类的equals()方法进行的是数值的比较 a9 == a10: true
```

### 总结：

- 如果是两个new出来的Integer，两个比较的就是地址，可以通过intValue()来获得值。
  - 类似的还有`public byte byteValue() {return (byte)value;}`等

```java
/**
* Returns the value of this {@code Integer} as an
* {@code int}.
*/
public int intValue() {
    return value;
}
```

- 比较的两个值一个是integer一个是int，则integer会自动拆箱；
- Integer对象赋值比较，这个得区分你的值范围
  - 如果是-128~127，这个范围是存放在常量池中，也就是比较的是值
  - 如果超出这个范围，比较的就是地址
- 两个integer对象的地址，如果想要获得值的话，除了intValue()之外，还有equals()进行数值的比较。

```
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }
```

