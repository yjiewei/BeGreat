#### [☆剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

```java
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```



**答题思路：** 

```
我居然写不出来。。。。多练几遍
```



**答题代码：** 

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 双指针遍历，注意边界，当一个结束后另外一个补上
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 好丢人啊，这不是刚写过的东西嘛
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
```

