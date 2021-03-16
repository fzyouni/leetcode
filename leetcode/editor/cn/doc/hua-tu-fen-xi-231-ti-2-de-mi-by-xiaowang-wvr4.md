### 思路分析

这道题通过位运算处理，先思考一个问题：二进制 1111 如何转为十进制
 
![21-02-09-01.png](https://pic.leetcode-cn.com/1612806446-YVIGmb-21-02-09-01.png)


显然，每一位都可以以 2 的幂的形式表现

![21-02-09-10.png](https://pic.leetcode-cn.com/1612805969-QIOLlD-21-02-09-10.png)


那判断一个数是否是 2 的幂就很简单了，如果把一个数中的 1 敲掉，结果为 0 ，那么这个数就是 2 的幂。

### 第一种方式敲掉 1

n & (n - 1) 用来去掉二进制数中的最后一位 1 。

例如 n = 20，n - 1 = 19。从十进制的角度来看，相当于 20 中的最后一位 1 借给后两位来减 1。

这就导致图中圈出的部分各位完全相反。

![21-02-09-02.png](https://pic.leetcode-cn.com/1612807160-WlqBoj-21-02-09-02.png)

因此，两数相与后， 20 的最后一个 1 就被敲掉了。

![image.png](https://pic.leetcode-cn.com/1612808305-kfsvoa-image.png)


**代码描述**

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

### 第二种方式敲掉 1

n ^ (n & -n) 用来去掉二进制数中的最后一位 1 。

例如 n = 20，20 的二进制表示为 0001 0100，而 -20 的二进制表示 1110 1100

![image.png](https://pic.leetcode-cn.com/1612808651-kwDCrt-image.png)

正是因为 -n 为 n 按位取反加 1 再补齐后的值，将 n 和 -n 进行与运算，将得到只包含 n 的最后一位 1 的数。

去除 n 的最后一位 1 可以异或处理 ：n ^ (n & -n)

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n ^(n & -n)) == 0;
    }
}
```







