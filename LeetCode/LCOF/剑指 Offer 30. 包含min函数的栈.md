#### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

```java
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```



**答题思路：** 

```
这题编码不难，难在分析，你是否能想到用另外一个栈来存放最小值，以空间来换时间，让O(1)的时间里获得最小值。
```



**答题代码：** 

```java
class MinStack {

    Stack<Integer> dataStack = null;
    Stack<Integer> helpStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        helpStack = new Stack<>();
    }
    
    public void push(int x) {
        dataStack.push(x);
        if(helpStack.isEmpty()){
            helpStack.push(x);
        }else{
            if(helpStack.peek() > x) helpStack.push(x);
            else helpStack.push(helpStack.peek());
        }
    }
    
    public void pop() {
        if(!dataStack.isEmpty()){
            dataStack.pop();
            helpStack.pop();
        }else{
            return;
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return helpStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

