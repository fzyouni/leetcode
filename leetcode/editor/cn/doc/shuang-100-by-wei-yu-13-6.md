### 解题思路
暴力

### 代码

```java
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] c1=s1.toCharArray();
        Arrays.sort(c1);
        char[] c2=s2.toCharArray();
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }
}
```