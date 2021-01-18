#### [剑指 Offer 37. 序列化二叉树](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/)

```java
请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
```



**答题思路：** 

```
序列化二叉树其实是将它层次遍历转换成一个字符串，而反序列化是将其转换成一棵树，两个可以互相确定彼此。
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 层次遍历
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else res.append("null,");
        }
        res.deleteCharAt(res.length()-1); // 删除最后一个逗号
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 构造一棵二叉树
        if(data.equals("[]")) return null;
        // 取出每个元素放在数组
        String[] vals = data.substring(1, data.length() - 1).split(","); 
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 存放的都是未构造左右节点的节点
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll(); // 取出来构造左右节点
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```

