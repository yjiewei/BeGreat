#### [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

```java
在前面几道题的基础，改变遍历方向，变成之字型的。
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [20,9],
  [15,7]
]
```



**答题思路：** 

```
多加一个标志位，进行反转数组。
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 层次遍历用队列完成 从上带下从左到右
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean turn = false;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while(count>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                count--;
            }
            if(turn) Collections.reverse(list);
            result.add(list);
            turn = !turn;
        }
        return result;    
    }
}
```

