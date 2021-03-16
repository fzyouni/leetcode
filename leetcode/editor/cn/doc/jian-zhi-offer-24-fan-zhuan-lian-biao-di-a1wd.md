### 解题思路
1. 递归遍历
- 先序遍历
- 后序遍历

2. 非递归遍历

### 复杂度分析
1. 递归先/后序遍历
- 时间复杂度：`O(N)`。其中`N`为链表长度，递归树深度为`N`。
- 空间复杂度：`O(N)`。递归所需栈空间为`N`。

2. 非递归遍历
- 时间复杂度：`O(N)`。其中`N`为链表长度，需要从前至后遍历一次链表。
- 空间复杂度：`O(1)`。

### 代码
1. 递归遍历
- 先序遍历
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        //递归入口：pre是null，cur是链表头节点head
        return preReverse(null, head);
    }
    public ListNode preReverse(ListNode pre, ListNode cur){
        //若链表为空或递归到链表最末节点时，回溯返回当前节点
        if(cur == null) return pre;
        /*先序反转链表的指针操作*/
        //保存住当前节点的下一节点
        ListNode next = cur.next;
        //当前节点的next域赋为当前节点的前驱结点
        cur.next = pre;
        //将pre、cur分别向后移动一位（进行下一轮反转）
        pre = cur;
        cur = next;
        //返回已经反转完成的链表头
        return preReverse(pre, cur);
    }
}
```

- 后序遍历
```java
class Solution {
    //后序遍历
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        return postReverse(cur);
    }
    public ListNode postReverse(ListNode cur) {
        ListNode tail = new ListNode(0);
        //若链表为空或递归到链表最末节点时，回溯返回当前节点
        if(cur == null || cur.next == null){
            return cur;
        }
        //tail指向链表的末尾，每次回溯后以tail为头节点的逆链表长度+1
        tail = postReverse(cur.next);
        /*反转链表的指针操作*/
        cur.next.next = cur;
        cur.next = null;
        //返回更新后的反转链表头
        return tail;
    }
}
```

2. 非递归遍历
```java
class Solution{
    //非递归遍历
    public ListNode reverseList(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```
