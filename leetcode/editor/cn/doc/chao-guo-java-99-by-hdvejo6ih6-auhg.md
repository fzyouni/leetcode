### 解题思路
此处撰写解题思路
第一次写题解，思路基本就是将两个字符串转化为字符数组然后分别对两个字符数组对应的字符相加最后判断最前面是否需要加1。
![QQ图片20210302023436.png](https://pic.leetcode-cn.com/1614623688-jDXcLA-QQ%E5%9B%BE%E7%89%8720210302023436.png)
### 代码

```java
class Solution {
    public String addStrings(String num1, String num2) {
        char[] big = num1.length()>=num2.length()?num1.toCharArray():num2.toCharArray();
        char[] small = num1.length()<num2.length()?num1.toCharArray():num2.toCharArray();
        int l = big.length-1;
        int s = small.length-1;
        int carry = 0;
       while (l>=0||s>=0){
           if (l>=0)
               carry+=big[l]-'0';
           if (s>=0)
               carry+=small[s]-'0';
           big[l]=(char) (carry%10+'0');
           carry/=10;
           l--;
           s--;
       }
       if (carry>0)
           return "1"+String.valueOf(big);
       return String.valueOf(big);
    }
}
```