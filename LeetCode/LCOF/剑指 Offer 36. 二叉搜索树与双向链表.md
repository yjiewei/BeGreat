#### [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

 <img src="LeetCodeMould.assets/bstdlloriginalbst.png" alt="img" style="zoom:50%;" />

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 <img src="LeetCodeMould.assets/bstdllreturndll.png" alt="img" style="zoom:50%;" />

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。



**答题思路：** 

```
在中序遍历的基础上，增加一些指针及改变指向，最重要的是标记。
时间复杂度是O(N) 
空间复杂度是O(N) 因为是二叉搜索树，最坏可能退化成链表，最差需要N个大小的栈。
```



**答题代码：** 

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // 中序遍历问题
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node head = null;
        Node tail = null;
        Node pre = null;
        Node cur = root;
        // 中序遍历二叉树的同时构造指针
        while(!stack.isEmpty() || cur != null){
            // 左节点一直在进栈
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop(); // 最左节点也即是栈顶出栈
                if(pre != null){
                    cur.left = pre;
                    pre.right = cur;
                }else{
                    head = cur; // head为第一个节点
                }
                pre = cur;
                tail = cur; // 二叉树最后一个节点
                cur = cur.right;
            }
        }
        if(head != null){
            // 头和尾之间的联系
            head.left = tail;
            tail.right = head;
        }
        return head;
    }
}
```

