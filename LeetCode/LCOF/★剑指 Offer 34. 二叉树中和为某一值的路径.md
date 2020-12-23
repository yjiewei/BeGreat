#### [★剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

```java
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
```



**答题思路：** 

```
剑指offer182页，建议多看几遍。
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 这里有明确是从根节点到叶子节点的路径。
        // 按照书上的做法是直接递归 栈 书上是输出，这里是存起来
        // 后面用的都是同一个collector，但是会改变元素
        backTrack(root, sum, new ArrayList<>());
        return res;
    }

    public void backTrack(TreeNode node,int target,List<Integer> collector){
        if(node == null) return;
        collector.add(node.val); // 这个是用来记录每一次的路径
        target -= node.val;
        if(target == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(collector));
        } else{
            backTrack(node.left, target, collector);
            backTrack(node.right, target, collector);
        }
        // 递归函数结束后，回退需要删除最后一个节点，也即是回到父节点。
        collector.remove(collector.size() - 1);
    }
}
```

