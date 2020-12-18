#### [★剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

```java
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:
     3
    / \
   4   5
  / \
 1   2
         
给定的树 B：
   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
示例 1：
输入：A = [1,2,3], B = [3,1]
输出：false
         
示例 2：
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
         
限制：
0 <= 节点个数 <= 10000
```



**答题思路：** 

```
时间复杂度是O(logn) 递归栈的深度
空间复杂度是O(1) 只是判断并没有其他额外的空间。
判断是否是子树，除了节点值要相同，左右节点位置也是一样的。
具体代码解释如下。
```



**答题代码：** 

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false; // 比较的节点为null，不构成子结构
        // 1.如果不为空则判断是否相等及后续判断
        // 2.|| 符号右短接的功能，如果有一个成立后面的不用再继续了
        // 3.两个本函数的递归是当左子树、右子树也有可能是和B相同结构。每个进来就去判断是够相等。
        return subTree(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean subTree(TreeNode A,TreeNode B){
        if(B == null) return true; // 如果B是空的话，说明判断已经结束了，函数出口
        if(A == null || A.val != B.val) return false; // 如果Anull，或者是节点值不一样，false
        // 如果节点都不为空，也就是还有需要判断的，且 两个节点值是相等的，说明这个节点开始的子结构有可能成为可为true的情况，需要继续判断他们各自的左右都是否相等。
        return subTree(A.left,B.left) && subTree(A.right,B.right);
    }
}
```

