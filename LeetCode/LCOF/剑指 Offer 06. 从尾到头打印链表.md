#### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

难度简单75

```java
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]

限制：
0 <= 链表长度 <= 10000
```



**答题思路：** 

```
时间复杂度是O(N) 空间是O(1)都是常量级别的。返回的数组长度是确定的，不过是根据链表数目确定的。
总体思路是反转链表+遍历链表
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
    public int[] reversePrint(ListNode head) {
        // 反转链表吧，再遍历放到一个数组里面
        ListNode newHead = new ListNode(-1);
        ListNode h = newHead;
        if(head == null) return new int[]{};
        int i = 0;
        while(head != null){
            ListNode a = head.next;
            head.next = h.next;
            h.next = head;
            head = a;
            i++;
        }
        ListNode x = newHead.next;
        int[] ret = new int[i];
        int j = 0;
        while(x != null){
            ret[j] = x.val;
            j++;
            x = x.next;
        }
        return ret;
    }
}
```

