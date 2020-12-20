#### [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

```java
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
    
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
```



**答题思路：** 

```
时间复杂度是O(N)每个节点都要遍历并比较。
空间复杂度是O(logN)吧，这个如果是不对称的应该很快就结束了，所以最坏的肯定不会达到O(N).
比较的方法其实很容易想通，我们要判断一颗树的左右子树是否对称，也就是左边和右边镜像相等。
我们把这棵树想象成两棵树，你的最左边=我的最右边，同时我的最右边=你的最左边。
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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root); // 重载方法
    }

    public boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isSymmetric(root1.left, root2.right) 
                && isSymmetric(root1.right, root2.left); 
    }
}
```

