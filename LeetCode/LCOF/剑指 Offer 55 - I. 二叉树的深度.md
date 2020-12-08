#### [剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

```java
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
```



**答题思路：** 

```
我似乎变强了，我只是有个大概思路然后写了一下大概的方法，似乎套路被刻在脑子里了。。。
求深度，那肯定递归啊，如果为空返回0，如果不空就是左节点和右节点的最大值+1，因为当前层次还没算。
时间复杂度是O(N) 树的节点都得遍历到
空间复杂度是O(logN)吧，二叉树的深度就是递归栈的个数。不对不对，如果二叉树退化成链表，最差是O(N)

此外，还可以使用层次遍历，相当于只计数就可以了。
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
    public int maxDepth(TreeNode root) {
        // 求深度那得递归吧 遍历左右子树拿到最大的那个
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
```

