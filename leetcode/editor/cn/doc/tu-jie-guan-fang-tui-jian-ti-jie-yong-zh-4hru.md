![官方推荐题解](https://pic.leetcode-cn.com/1615649992-QvMuco-%E6%9C%AA%E6%A0%87%E9%A2%98-1.png)

### 解题思路

根据栈的 `FILO` 的特点，我们仅能使用 *push* 和 *pop* 操作。

### 示例代码

```javascript
/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
    // 创建入队操作栈 is，出队操作栈 os
    this.is = [];
    this.os = [];
};

/**
 * Push element x to the back of queue.
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.is.push(x);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    // 检查出队操作栈是否有数据
    if(!this.os.length){
        // 无数据的话，检查入队操作者是否有数据
        while(this.is.length){
            // 有，则全部倒入出队操作栈
            this.os.push(this.is.pop());
        }
    }
    // 弹出栈顶
    return this.os.pop();
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    // 和 pop 同理
    if(!this.os.length){
        while(this.is.length){
            this.os.push(this.is.pop());
        }
    }
    return this.os[this.os.length - 1];
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return !this.is.length && !this.os.length;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
```

* 时间复杂度：*O(1)*，1 为 push 和 pop 的操作。
* 空间复杂度：*O(n)*，n 为队列所用存储空间。

### 后序

若该题解对你有帮助，请不要吝啬你的赞哦，喜欢的可以加个关注，有关注，不迷路 🎉 。