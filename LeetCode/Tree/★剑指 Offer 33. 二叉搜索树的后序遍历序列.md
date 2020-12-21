#### [剑指 Offer 33. 二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

```java
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
    
示例 1：
输入: [1,6,3,2,5]
输出: false
    
示例 2：
输入: [1,3,2,6,5]
输出: true
```



**答题思路：** 

```
要认真啊。
根据一维数组来判断是否存在某棵二叉搜索树可以通过后序遍历获得。
二叉搜索树的特点就是左边的节点比根节点小，右边的节点比根节点大。而数组的特点是最后一个节点为根节点。
大体思想就是：遍历数组最后一个为根节点，从头开始遍历，第一个比根节点大的数开始后面都是右子树。
			递归遍历左子树，右子树都要符合这个结构。
		递归出口是：右子树中存在某个树比根节点小；符合条件则最后只剩下一个节点或右子树中没有不符合条件的。
		
另外还有一种单调栈的方法，没看懂。
```



**答题代码：** 

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 递归实现
        // 每一个数组都要符合最后一个元素为根节点
        // 再根据二叉搜索树，左边比根节点小，右边比根节点大，如果右边里面出现比根小的值则错
        int length = postorder.length;
        if(length == 0) return true; // 数组为空
        return post(postorder,0,length-1); // 遍历数组
    }

    public boolean post(int[] postorder,int left,int right){
        if(left >= right) return true; // 只剩下一个节点了或者小于1个节点（没有左子树的情况）
        int root = postorder[right];
        int l = left;
        while(postorder[l] < root){
            l++;
        }
        int r = l;// 如果没有右子树这里r == right
        while(postorder[r] > root){
            r++; // 没有问题的话会走到root所在下标
        }
        // 判断是否有问题，&& 有短接功能
        return r == right && post(postorder,left,l-1) && post(postorder, l,right-1);
    }
}
```

