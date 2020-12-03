#### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

```java
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```



**答题思路：** 

```
送分题 不会就画个图
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
    public ListNode reverseList(ListNode head) {
        // 熟悉的反转链表，我不知道为什么我要写这个写这么多遍 使用头插法
        ListNode ret = new ListNode(-1);
        ListNode headone = ret;
        while(head != null){
            ListNode next = head.next;
            head.next = headone.next;
            headone.next = head;
            head = next;
        }
        return ret.next;
    }
}
```

