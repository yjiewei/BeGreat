#### [★剑指 Offer 31. 栈的压入、弹出序列](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

```java
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
    
示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
```



**答题思路：** 

```
思路不难，看了别人代码也不难。
自己写，他妈这题是人能想出来的吗？？？
同时两个指针遍历数组，一个进栈指针，一个比较指针。
时间O(N) 需要遍历一遍数组。
空间O(N) 需要一个栈的空间。
```



**答题代码：** 

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int elem : pushed){
            stack.push(elem); // 空栈的时候
            // 1.popped数组还没遍历完 2.栈不空的时候 3.栈顶元素和popped数组元素相等。
            // 第二个条件是为了第三个条件不会空指针吧，而且空栈的时候说明已经结束了需要其他元素进栈
            while(j < popped.length &&!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
```

