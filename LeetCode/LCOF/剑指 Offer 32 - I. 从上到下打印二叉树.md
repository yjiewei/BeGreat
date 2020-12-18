#### [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

```java
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]
```



**答题思路：** 

```
写的次数多了，条件反射了。
层次遍历用队列，先进先出，用队列的每一层的大小来控制出栈的个数也就是层次。
时间复杂度是O(N) 每个节点都要一进一出，所以是2N
空间也是O(N)
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
    List<Integer> list = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        // 层次遍历用队列完成 从上带下从左到右
        if(root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                count--;
            }
        }
        int[] array = new int[list.size()];
        int j = 0;
        for(int i : list){
            array[j++] = i;
        }
        return array;
    }
}
```

