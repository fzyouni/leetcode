### 解题思路
此处撰写解题思路

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    
        ListNode p=head,q=head;
        while(p != null && q !=null){
            if(p.val == q.val){
                p.next=q.next;
            }else{
                p=p.next;
            }
            q=q.next;
        }
        return head;
    }
}
```