### 解题思路
核心思路就是留一个前置指针，在游标移动K次之后前置指针开始移动，当游标到达最后一个元素时，前置指针刚好是要返回链表的头。

### 代码

```java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            if(k>0)
                k--;
            else{
                pre = pre.next;
            }
        }
        return pre;
    }
}
```