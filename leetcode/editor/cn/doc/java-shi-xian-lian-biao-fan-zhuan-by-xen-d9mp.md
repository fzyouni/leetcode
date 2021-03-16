### 解题思路
1. 初始化prev cur next节点定义
2. 将prev与cur.next反转；
3. 将处理节点向后移动 cur设为prev，cur设为next


### 代码

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
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;

    }
}
```