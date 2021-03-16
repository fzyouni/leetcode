### 解题思路
此处撰写解题思路
![image.png](https://pic.leetcode-cn.com/1613306268-eqGsFQ-image.png)
看代码你一切都会懂得！
### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum=0;
       public int sumOfLeftLeaves(TreeNode root) {
           if(root==null){
               return 0;
           }
           if(root.left!=null){
               TreeNode node=root.left;
               if(node.left==null && node.right==null){
                   sum += node.val;
               }
           }
           sumOfLeftLeaves(root.left);
           
           sumOfLeftLeaves(root.right);
           return sum;
       }
   


}
```